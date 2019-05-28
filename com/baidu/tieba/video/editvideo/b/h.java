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
    private boolean jpJ;
    private String jpK;
    private com.faceunity.gles.c jpM;
    private com.faceunity.gles.c jpN;
    private Context mContext;
    private int mHeight;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mTextureId;
    private int mWidth;
    static int mFacebeautyItem = 0;
    static int mEffectItem = 0;
    static int jpL = 0;
    static int[] itemsArray = {mFacebeautyItem, mEffectItem, jpL};
    private Object jpI = new Object();
    private final float[] mSTMatrix = new float[16];

    public h(Context context, String str, int i, int i2) {
        this.jpK = "normal";
        this.mContext = context;
        this.jpK = str;
        this.mWidth = i;
        this.mHeight = i2;
        setup();
    }

    private void setup() {
        this.jpM = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        Log.d("OutputSurface", "onSurfaceCreated: ");
        this.jpN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mTextureId = this.jpN.createTextureObject();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurface = new Surface(this.mSurfaceTexture);
        mFacebeautyItem = com.faceunity.a.eE(this.mContext);
        itemsArray[0] = mFacebeautyItem;
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
    }

    public void release() {
        this.mSurface.release();
        this.mSurface = null;
        this.mSurfaceTexture = null;
        if (this.jpM != null) {
            this.jpM.release(false);
            this.jpM = null;
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

    public void crK() {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        faceunity.fuItemSetParam(mFacebeautyItem, "filter_name", this.jpK);
        faceunity.fuItemSetParam(mFacebeautyItem, "eye_bright", 0.0d);
        faceunity.fuItemSetParam(mFacebeautyItem, "tooth_whiten", 0.0d);
        this.jpM.drawFrame(faceunity.fuBeautifyImage(this.mTextureId, 1, this.mWidth, this.mHeight, 0, itemsArray), this.mSTMatrix);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void crL() {
        synchronized (this.jpI) {
            do {
                if (!this.jpJ) {
                    try {
                        this.jpI.wait(500L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this.jpJ = false;
                }
            } while (this.jpJ);
            throw new RuntimeException("Surface frame wait timed out");
        }
        checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.d("OutputSurface", "new frame available");
        synchronized (this.jpI) {
            if (this.jpJ) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.jpJ = true;
            this.jpI.notifyAll();
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
