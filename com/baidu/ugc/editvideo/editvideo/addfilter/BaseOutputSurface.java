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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.EglCore;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.OffscreenSurface;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.faceunity.gles.WindowSurface;
import com.faceunity.gles.GeneratedTexture;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class BaseOutputSurface implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EglCore mEglCore;
    public boolean mFrameAvailable;
    public Object mFrameSyncObject;
    public FullFrameRect mFullScreenEXT;
    public boolean mIsOffscreenRenderer;
    public OffscreenSurface mOffscreenSurface;
    public int[] mPbo;
    public int mPboIndex;
    public int mPboNextIndex;
    public ByteBuffer mPixelBuf;
    public final float[] mSTMatrix;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureId;
    public int mVideoHeight;
    public int mVideoWidth;

    public BaseOutputSurface() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrameSyncObject = new Object();
        this.mSTMatrix = new float[16];
    }

    private void initPbo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int[] iArr = new int[2];
            this.mPbo = iArr;
            GLES30.glGenBuffers(2, iArr, 0);
            GLES30.glBindBuffer(35051, this.mPbo[0]);
            GLES30.glBufferData(35051, this.mVideoWidth * this.mVideoHeight * 4, null, 35049);
            GLES30.glBindBuffer(35051, this.mPbo[1]);
            GLES30.glBufferData(35051, this.mVideoWidth * this.mVideoHeight * 4, null, 35049);
            GLES30.glBindBuffer(35051, 0);
        }
    }

    @RequiresApi(api = 24)
    private Bitmap saveOffscreenBitmapWith2Pbo(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i, i2)) == null) {
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
                bg9.g(e);
                return null;
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    private Bitmap saveOffscreenBitmapWithImageReader(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i, i2)) == null) {
            try {
                ImageReader newInstance = ImageReader.newInstance(i, i2, 1, 2);
                newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener(this, i, i2) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaseOutputSurface this$0;
                    public final /* synthetic */ int val$height;
                    public final /* synthetic */ int val$width;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$width = i;
                        this.val$height = i2;
                    }

                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public void onImageAvailable(ImageReader imageReader) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, imageReader) == null) {
                            Image.Plane[] planes = imageReader.acquireNextImage().getPlanes();
                            ByteBuffer buffer = planes[0].getBuffer();
                            byte[] bArr = new byte[this.val$width * this.val$height * 4];
                            int rowStride = planes[0].getRowStride() - (planes[0].getPixelStride() * this.val$width);
                            int i3 = 0;
                            for (int i4 = 0; i4 < this.val$height; i4++) {
                                buffer.position((i4 * rowStride) + i3);
                                buffer.get(bArr, i3, this.val$width * 4);
                                i3 += this.val$width * 4;
                            }
                        }
                    }
                }, null);
                new WindowSurface(this.mEglCore, newInstance.getSurface(), true).makeCurrent();
            } catch (OutOfMemoryError e) {
                bg9.g(e);
            }
            return null;
        }
        return (Bitmap) invokeII.objValue;
    }

    private void setupEgl() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mIsOffscreenRenderer) {
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
    }

    public void awaitNewImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    public void checkGlError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            bg9.d(str + ": glError " + glGetError);
        }
    }

    public void drawImage(int i) {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (surfaceTexture = this.mSurfaceTexture) == null) {
            return;
        }
        surfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    }

    public Bitmap getFrameBitmap() {
        InterceptResult invokeV;
        EglCore eglCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bitmap saveOffscreenBitmapWith2Pbo = (Build.VERSION.SDK_INT < 24 || (eglCore = this.mEglCore) == null || eglCore.getGlVersion() != 3) ? null : saveOffscreenBitmapWith2Pbo(this.mVideoWidth, this.mVideoHeight);
            if (saveOffscreenBitmapWith2Pbo != null) {
                return saveOffscreenBitmapWith2Pbo;
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
                bg9.g(e);
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public Surface getSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSurface : (Surface) invokeV.objValue;
    }

    public void init(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            init(i, i2, false, null);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, surfaceTexture) == null) {
            synchronized (this.mFrameSyncObject) {
                this.mFrameAvailable = true;
                this.mFrameSyncObject.notifyAll();
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    public void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mFullScreenEXT = fullFrameRect;
            this.mTextureId = fullFrameRect.createTextureObject();
        }
    }

    public void init(int i, int i2, boolean z, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), handler}) == null) {
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
}
