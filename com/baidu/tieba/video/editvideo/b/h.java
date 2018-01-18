package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
/* loaded from: classes2.dex */
class h implements SurfaceTexture.OnFrameAvailableListener {
    private boolean hoC;
    private String hoD;
    private com.faceunity.gles.c hoF;
    private com.faceunity.gles.c hoG;
    private Context mContext;
    private int mHeight;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mTextureId;
    private int mWidth;
    static int mFacebeautyItem = 0;
    static int mEffectItem = 0;
    static int hoE = 0;
    static int[] itemsArray = {mFacebeautyItem, mEffectItem, hoE};
    private Object hoB = new Object();
    private final float[] mSTMatrix = new float[16];

    public h(Context context, String str, int i, int i2) {
        this.hoD = "normal";
        this.mContext = context;
        this.hoD = str;
        this.mWidth = i;
        this.mHeight = i2;
        setup();
    }

    private void setup() {
        this.hoF = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        Log.d("OutputSurface", "onSurfaceCreated: ");
        this.hoG = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mTextureId = this.hoG.createTextureObject();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurface = new Surface(this.mSurfaceTexture);
        mFacebeautyItem = com.faceunity.a.cY(this.mContext);
        itemsArray[0] = mFacebeautyItem;
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
    }

    public void release() {
        this.mSurface.release();
        this.mSurface = null;
        this.mSurfaceTexture = null;
        if (this.hoF != null) {
            this.hoF.release(false);
            this.hoF = null;
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

    public void bAQ() {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        faceunity.fuItemSetParam(mFacebeautyItem, "filter_name", this.hoD);
        this.hoF.drawFrame(faceunity.fuBeautifyImage(this.mTextureId, 1, this.mWidth, this.mHeight, 0, itemsArray), this.mSTMatrix);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void bAR() {
        synchronized (this.hoB) {
            do {
                if (!this.hoC) {
                    try {
                        this.hoB.wait(500L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this.hoC = false;
                }
            } while (this.hoC);
            throw new RuntimeException("Surface frame wait timed out");
        }
        checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.d("OutputSurface", "new frame available");
        synchronized (this.hoB) {
            if (this.hoC) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.hoC = true;
            this.hoB.notifyAll();
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
