package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.fna;
import com.baidu.ugc.editvideo.faceunity.gles.EglCore;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.OffscreenSurface;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.faceunity.gles.WindowSurface;
import com.faceunity.gles.GeneratedTexture;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes8.dex */
public abstract class BaseOutputSurface implements SurfaceTexture.OnFrameAvailableListener {
    public EglCore mEglCore;
    public boolean mFrameAvailable;
    public FullFrameRect mFullScreenEXT;
    public boolean mIsOffscreenRenderer;
    public OffscreenSurface mOffscreenSurface;
    public int[] mPbo;
    public int mPboIndex;
    public int mPboNextIndex;
    public ByteBuffer mPixelBuf;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureId;
    public int mVideoHeight;
    public int mVideoWidth;
    public Object mFrameSyncObject = new Object();
    public final float[] mSTMatrix = new float[16];

    public void awaitNewImage() {
        synchronized (this.mFrameSyncObject) {
            while (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(5000L);
                } catch (InterruptedException unused) {
                }
                this.mFrameAvailable = true;
            }
            this.mFrameAvailable = false;
        }
        checkGlError("before updateTexImage");
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return;
        }
        surfaceTexture.updateTexImage();
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void setup() {
        FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mFullScreenEXT = fullFrameRect;
        this.mTextureId = fullFrameRect.createTextureObject();
    }

    private void initPbo() {
        int[] iArr = new int[2];
        this.mPbo = iArr;
        GLES30.glGenBuffers(2, iArr, 0);
        GLES30.glBindBuffer(35051, this.mPbo[0]);
        GLES30.glBufferData(35051, this.mVideoWidth * this.mVideoHeight * 4, null, 35049);
        GLES30.glBindBuffer(35051, this.mPbo[1]);
        GLES30.glBufferData(35051, this.mVideoWidth * this.mVideoHeight * 4, null, 35049);
        GLES30.glBindBuffer(35051, 0);
    }

    private void setupEgl() {
        if (!this.mIsOffscreenRenderer) {
            return;
        }
        EglCore eglCore = new EglCore(null, 2);
        this.mEglCore = eglCore;
        OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, this.mVideoWidth, this.mVideoHeight);
        this.mOffscreenSurface = offscreenSurface;
        offscreenSurface.makeCurrent();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mVideoWidth * this.mVideoHeight * 4);
        this.mPixelBuf = allocateDirect;
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        initPbo();
    }

    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect != null) {
            fullFrameRect.release(true);
            this.mFullScreenEXT = null;
        }
        OffscreenSurface offscreenSurface = this.mOffscreenSurface;
        if (offscreenSurface != null) {
            offscreenSurface.release();
            this.mOffscreenSurface = null;
        }
        EglCore eglCore = this.mEglCore;
        if (eglCore != null) {
            eglCore.release();
            this.mEglCore = null;
        }
        GLES20.glDeleteTextures(1, new int[]{this.mTextureId}, 0);
        int[] iArr = this.mPbo;
        if (iArr != null) {
            GLES20.glDeleteBuffers(iArr.length, iArr, 0);
        }
    }

    @RequiresApi(api = 24)
    private Bitmap saveOffscreenBitmapWith2Pbo(int i, int i2) {
        try {
            System.currentTimeMillis();
            GLES30.glBindBuffer(35051, this.mPbo[this.mPboIndex]);
            GLES30.glReadPixels(0, 0, i, i2, (int) GeneratedTexture.FORMAT, 5121, 0);
            System.currentTimeMillis();
            System.currentTimeMillis();
            GLES30.glBindBuffer(35051, this.mPbo[this.mPboNextIndex]);
            Buffer glMapBufferRange = GLES30.glMapBufferRange(35051, 0, this.mVideoWidth * 4 * this.mVideoHeight, 1);
            System.currentTimeMillis();
            System.currentTimeMillis();
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(glMapBufferRange);
            System.currentTimeMillis();
            GLES30.glUnmapBuffer(35051);
            GLES30.glBindBuffer(35051, 0);
            int i3 = (this.mPboIndex + 1) % 2;
            this.mPboIndex = i3;
            this.mPboNextIndex = (i3 + 1) % 2;
            return createBitmap;
        } catch (OutOfMemoryError e) {
            fna.g(e);
            return null;
        }
    }

    private Bitmap saveOffscreenBitmapWithImageReader(final int i, final int i2) {
        try {
            ImageReader newInstance = ImageReader.newInstance(i, i2, 1, 2);
            newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface.1
                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    Image.Plane[] planes = imageReader.acquireNextImage().getPlanes();
                    ByteBuffer buffer = planes[0].getBuffer();
                    byte[] bArr = new byte[i * i2 * 4];
                    int rowStride = planes[0].getRowStride() - (planes[0].getPixelStride() * i);
                    int i3 = 0;
                    for (int i4 = 0; i4 < i2; i4++) {
                        buffer.position((i4 * rowStride) + i3);
                        buffer.get(bArr, i3, i * 4);
                        i3 += i * 4;
                    }
                }
            }, null);
            new WindowSurface(this.mEglCore, newInstance.getSurface(), true).makeCurrent();
        } catch (OutOfMemoryError e) {
            fna.g(e);
        }
        return null;
    }

    public void init(int i, int i2) {
        init(i, i2, false, null);
    }

    public void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                fna.d(str + ": glError " + glGetError);
            } else {
                return;
            }
        }
    }

    public void drawImage(int i) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return;
        }
        surfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mFrameSyncObject) {
            this.mFrameAvailable = true;
            this.mFrameSyncObject.notifyAll();
        }
    }

    public Bitmap getFrameBitmap() {
        Bitmap bitmap;
        EglCore eglCore;
        if (Build.VERSION.SDK_INT >= 24 && (eglCore = this.mEglCore) != null && eglCore.getGlVersion() == 3) {
            bitmap = saveOffscreenBitmapWith2Pbo(this.mVideoWidth, this.mVideoHeight);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            System.currentTimeMillis();
            if (this.mPixelBuf == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mVideoWidth * this.mVideoHeight * 4);
                this.mPixelBuf = allocateDirect;
                allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            }
            this.mPixelBuf.rewind();
            GLES20.glReadPixels(0, 0, this.mVideoWidth, this.mVideoHeight, GeneratedTexture.FORMAT, 5121, this.mPixelBuf);
            System.currentTimeMillis();
            System.currentTimeMillis();
            Bitmap createBitmap = Bitmap.createBitmap(this.mVideoWidth, this.mVideoHeight, Bitmap.Config.ARGB_8888);
            this.mPixelBuf.rewind();
            createBitmap.copyPixelsFromBuffer(this.mPixelBuf);
            System.currentTimeMillis();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            fna.g(e);
            return null;
        }
    }

    public void init(int i, int i2, boolean z, Handler handler) {
        this.mIsOffscreenRenderer = z;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        setupEgl();
        setup();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurface = new Surface(this.mSurfaceTexture);
        if (handler != null && Build.VERSION.SDK_INT >= 21) {
            this.mSurfaceTexture.setOnFrameAvailableListener(this, handler);
        } else {
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }
    }
}
