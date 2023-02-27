package com.baidu.ugc.editvideo.record.processor;

import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
/* loaded from: classes7.dex */
public abstract class BaseEffectProcessor implements IEffectProcessor {
    public int mInputTextureMode;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public int mOutputTextureMode = 1;
    public float mRed = 0.0f;
    public float mGreen = 0.0f;
    public float mBlue = 0.0f;
    public float mAlpha = 0.0f;

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onResumeInGlThread() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
    }

    public abstract void release();

    public abstract void releaseInGlThread();

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int getOutputTextureMode() {
        return this.mOutputTextureMode;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        release();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        releaseInGlThread();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        release();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        releaseInGlThread();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setGlClearColor(float f, float f2, float f3, float f4) {
        this.mRed = f;
        this.mGreen = f2;
        this.mBlue = f3;
        this.mAlpha = f4;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setInputTextureMode(int i) {
        this.mInputTextureMode = i;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }
}
