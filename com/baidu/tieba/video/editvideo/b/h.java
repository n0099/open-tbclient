package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class h implements SurfaceTexture.OnFrameAvailableListener {
    private boolean hFo;
    private String hFp;
    private com.faceunity.gles.c hFr;
    private com.faceunity.gles.c hFs;
    private Context mContext;
    private int mHeight;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mTextureId;
    private int mWidth;
    static int mFacebeautyItem = 0;
    static int mEffectItem = 0;
    static int hFq = 0;
    static int[] itemsArray = {mFacebeautyItem, mEffectItem, hFq};
    private Object hFn = new Object();
    private final float[] mSTMatrix = new float[16];

    public h(Context context, String str, int i, int i2) {
        this.hFp = "normal";
        this.mContext = context;
        this.hFp = str;
        this.mWidth = i;
        this.mHeight = i2;
        setup();
    }

    private void setup() {
        this.hFr = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        Log.d("OutputSurface", "onSurfaceCreated: ");
        this.hFs = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mTextureId = this.hFs.createTextureObject();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurface = new Surface(this.mSurfaceTexture);
        mFacebeautyItem = com.faceunity.a.dv(this.mContext);
        itemsArray[0] = mFacebeautyItem;
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
    }

    public void release() {
        this.mSurface.release();
        this.mSurface = null;
        this.mSurfaceTexture = null;
        if (this.hFr != null) {
            this.hFr.release(false);
            this.hFr = null;
        }
        faceunity.fuDestroyItem(mEffectItem);
        int[] iArr = itemsArray;
        mEffectItem = 0;
        iArr[1] = 0;
        faceunity.fuDestroyItem(mFacebeautyItem);
        int[] iArr2 = itemsArray;
        mFacebeautyItem = 0;
        iArr2[0] = 0;
        faceunity.fuOnDeviceLost();
    }

    public void bJy() {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        faceunity.fuItemSetParam(mFacebeautyItem, "filter_name", this.hFp);
        faceunity.fuItemSetParam(mFacebeautyItem, "eye_bright", 0.0d);
        faceunity.fuItemSetParam(mFacebeautyItem, "tooth_whiten", 0.0d);
        this.hFr.drawFrame(faceunity.fuBeautifyImage(this.mTextureId, 1, this.mWidth, this.mHeight, 0, itemsArray), this.mSTMatrix);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void bJz() {
        synchronized (this.hFn) {
            do {
                if (!this.hFo) {
                    try {
                        this.hFn.wait(500L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this.hFo = false;
                }
            } while (this.hFo);
            throw new RuntimeException("Surface frame wait timed out");
        }
        checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.d("OutputSurface", "new frame available");
        synchronized (this.hFn) {
            if (this.hFo) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.hFo = true;
            this.hFn.notifyAll();
        }
    }

    public void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("OutputSurface", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }
}
