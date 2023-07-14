package com.baidu.ugc.editvideo.faceunity.gles;

import android.opengl.Matrix;
import com.baidu.ugc.editvideo.faceunity.gles.Drawable2d;
/* loaded from: classes9.dex */
public class FullFrameRect {
    public float mAngle;
    public Texture2dProgram mProgram;
    public final Drawable2d mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    public final Drawable2d mRectLine = new Drawable2d(Drawable2d.Prefab.FULL_LINE);
    public float[] mMvpMtx = GlUtil.IDENTITY_MATRIX;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float[] mScratchMatrix = new float[16];
    public float[] mModelViewMatrix = new float[16];

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        this.mProgram = texture2dProgram;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        this.mProgram.release();
        this.mProgram = texture2dProgram;
    }

    public void drawFrame(float[] fArr) {
        this.mProgram.draw(fArr, this.mRectLine.getVertexArray());
    }

    public void release(boolean z) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.release();
            }
            this.mProgram = null;
        }
    }

    public void setAlpha(float f) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.setAlpha(f);
    }

    public void setAngle(float f) {
        this.mAngle = f;
    }

    public void setDistance(float f) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.setDistance(f);
    }

    public void setMirror(boolean z) {
        float f;
        if (z) {
            f = this.mScaleX * (-1.0f);
        } else {
            f = this.mScaleX;
        }
        this.mScaleX = f;
    }

    public void setShaderBgColor(String str) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.setShaderBgColor(str);
    }

    public void setVertexPoint(float[] fArr) {
        this.mMvpMtx = fArr;
    }

    private void recomputeMatrix() {
        float[] fArr = this.mModelViewMatrix;
        Matrix.setIdentityM(fArr, 0);
        float f = this.mAngle;
        if (f != 0.0f) {
            Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        }
        Matrix.scaleM(fArr, 0, this.mScaleX, this.mScaleY, 1.0f);
    }

    public int createTexture2DObject() {
        return this.mProgram.createTexture2DObject();
    }

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public float[] getModelViewMatrix() {
        recomputeMatrix();
        return this.mModelViewMatrix;
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public void drawFrame(int i, float[] fArr) {
        drawFrame(i, fArr, false);
    }

    public void setDxDy(float f, float f2) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.setDxDy(f, f2);
    }

    public void setScale(float f, float f2) {
        this.mRectDrawable.setScale(f, f2);
    }

    public void drawFrame(int i, float[] fArr, int i2, float[] fArr2) {
        drawFrame(i, fArr, i2, fArr2, false);
    }

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        this.mRectDrawable.setScaleAndTranslate(f, f2, f3, f4);
    }

    public void drawFrame(int i, float[] fArr, int i2, float[] fArr2, boolean z) {
        if (this.mProgram == null) {
            return;
        }
        float[] fArr3 = GlUtil.IDENTITY_MATRIX;
        if (z) {
            this.mScaleX = -1.0f;
            this.mAngle = 180.0f;
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr3, 0, getModelViewMatrix(), 0);
        } else if (this.mAngle != 0.0f) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr3, 0, getModelViewMatrix(), 0);
        } else {
            this.mScratchMatrix = fArr3;
        }
        this.mProgram.draw(this.mScratchMatrix, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride(), i2, fArr2, this.mRectDrawable.getTexCoordArray2());
    }

    public void drawFrame(int i, float[] fArr, boolean z) {
        if (this.mProgram == null) {
            return;
        }
        float[] fArr2 = this.mMvpMtx;
        if (z) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr2, 0, getModelViewMatrix(), 0);
        } else if (this.mAngle != 0.0f) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr2, 0, getModelViewMatrix(), 0);
        } else {
            this.mScratchMatrix = fArr2;
        }
        this.mProgram.draw(this.mScratchMatrix, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride());
    }

    public void setHumanSegMaskParams(int i, String str, float f) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.setHumanSegMaskParams(i, str, f);
    }
}
