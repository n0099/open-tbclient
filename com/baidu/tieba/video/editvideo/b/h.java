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
    private boolean jvU;
    private String jvV;
    private com.faceunity.gles.c jvX;
    private com.faceunity.gles.c jvY;
    private Context mContext;
    private int mHeight;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mTextureId;
    private int mWidth;
    static int mFacebeautyItem = 0;
    static int mEffectItem = 0;
    static int jvW = 0;
    static int[] itemsArray = {mFacebeautyItem, mEffectItem, jvW};
    private Object jvT = new Object();
    private final float[] mSTMatrix = new float[16];

    public h(Context context, String str, int i, int i2) {
        this.jvV = "normal";
        this.mContext = context;
        this.jvV = str;
        this.mWidth = i;
        this.mHeight = i2;
        setup();
    }

    private void setup() {
        this.jvX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        Log.d("OutputSurface", "onSurfaceCreated: ");
        this.jvY = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mTextureId = this.jvY.createTextureObject();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurface = new Surface(this.mSurfaceTexture);
        mFacebeautyItem = com.faceunity.a.eF(this.mContext);
        itemsArray[0] = mFacebeautyItem;
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
    }

    public void release() {
        this.mSurface.release();
        this.mSurface = null;
        this.mSurfaceTexture = null;
        if (this.jvX != null) {
            this.jvX.release(false);
            this.jvX = null;
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

    public void cuw() {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        faceunity.fuItemSetParam(mFacebeautyItem, "filter_name", this.jvV);
        faceunity.fuItemSetParam(mFacebeautyItem, "eye_bright", 0.0d);
        faceunity.fuItemSetParam(mFacebeautyItem, "tooth_whiten", 0.0d);
        this.jvX.drawFrame(faceunity.fuBeautifyImage(this.mTextureId, 1, this.mWidth, this.mHeight, 0, itemsArray), this.mSTMatrix);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void cux() {
        synchronized (this.jvT) {
            do {
                if (!this.jvU) {
                    try {
                        this.jvT.wait(500L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this.jvU = false;
                }
            } while (this.jvU);
            throw new RuntimeException("Surface frame wait timed out");
        }
        checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.d("OutputSurface", "new frame available");
        synchronized (this.jvT) {
            if (this.jvU) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.jvU = true;
            this.jvT.notifyAll();
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
