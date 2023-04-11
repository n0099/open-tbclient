package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.kf0;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes7.dex */
public class MediaBaseRenderer implements IMediaRenderer {
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public GLViewPortLocation mGLViewPortLocation;
    public float[] mMtx;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float mRatio;
    public int mSurfaceViewHeight;
    public int mSurfaceViewWidth;
    public int mTextureId;
    public int mTextureMode;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float mTx = 0.0f;
    public float mTy = 0.0f;
    public float mRed = 0.0f;
    public float mGreen = 0.0f;
    public float mBlue = 0.0f;
    public float mAlpha = 0.0f;

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onResumeInGlThread() {
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setEnable(boolean z) {
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(kf0 kf0Var, int i, float[] fArr) {
        this.mTextureId = i;
        this.mMtx = fArr;
        GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
        GLES20.glViewport(gLViewPortLocation.x, gLViewPortLocation.y, gLViewPortLocation.width, gLViewPortLocation.height);
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(770, 771);
        if (this.mTextureMode == 1) {
            this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
            this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
            this.mFullScreen2D.drawFrame(i, fArr);
            this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
        } else {
            this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
            this.mFullScreenEXT.drawFrame(i, fArr);
            this.mFullScreenEXT.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
        }
        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        this.mGLViewPortLocation = gLViewPortLocation;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setResolutionRatio(float f) {
        this.mRatio = f;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setTextureMode(int i) {
        this.mTextureMode = i;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.mSurfaceViewWidth = i;
        this.mSurfaceViewHeight = i2;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        this.mFullScreenEXT = fullFrameRect;
        this.mFullScreen2D = fullFrameRect2;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setGlClearColor(float f, float f2, float f3, float f4) {
        this.mRed = f;
        this.mGreen = f2;
        this.mBlue = f3;
        this.mAlpha = f4;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        this.mScaleX = f;
        this.mScaleY = f2;
        this.mTx = f3;
        this.mTy = f4;
    }
}
