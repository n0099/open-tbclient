package com.baidu.ugc.editvideo.record.preview;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.tieba.cgb;
import com.baidu.tieba.fkb;
import com.baidu.tieba.sg0;
import com.baidu.tieba.tkb;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes9.dex */
public class MediaPreviewView extends GLSurfaceView implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IMediaLifeCycle, MediaGLRenderer.OnDrawFrameFrequencyListener {
    public float mAlpha;
    public float mBlue;
    public float mGreen;
    public List<IEffectProcessor> mIEffectProcessorList;
    public List<IMediaRenderer> mIMediaRendererList;
    public MediaGLRenderer.OnDrawFrameFrequencyListener mOnDrawFrameListener;
    public OnSurfaceTextureCreateListener mOnSurfaceTextureCreateListener;
    public float mRed;
    public MediaGLRenderer mRenderer;
    public float[] mSTMatrix;
    public float mScaleX;
    public float mScaleY;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureIdEXT;
    public float mTx;
    public float mTy;

    /* loaded from: classes9.dex */
    public interface OnSurfaceTextureCreateListener {
        void onSurfaceTextureCreate(SurfaceTexture surfaceTexture, int i);
    }

    public MediaPreviewView(Context context) {
        this(context, null);
    }

    public MediaPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSTMatrix = new float[16];
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTx = 0.0f;
        this.mTy = 0.0f;
        this.mRed = 0.0f;
        this.mGreen = 0.0f;
        this.mBlue = 0.0f;
        this.mAlpha = 0.0f;
        this.mRenderer = new MediaGLRenderer();
        setEGLContextFactory(new MyEGLContextFactory(Build.VERSION.SDK_INT >= 23 ? 3 : 2));
        setEGLConfigChooser(new MSAAConfigChooser());
        setRenderer(this.mRenderer);
        setRenderMode(0);
        this.mRenderer.setOnDrawFrameFrequencyListener(this);
        this.mRenderer.setRendererListener(this);
        this.mRenderer.setOnMediaGLRendererStatusListener(new MediaGLRenderer.OnMediaGLRendererStatusListener() { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.1
            @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnMediaGLRendererStatusListener
            public void onError(int i, String str) {
                cgb.a("v_log_preview_render_error", str, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnDestroy(boolean z) {
        int b = fkb.b(this.mIEffectProcessorList);
        for (int i = 0; i < b; i++) {
            IEffectProcessor iEffectProcessor = (IEffectProcessor) fkb.c(this.mIEffectProcessorList, i);
            if (z) {
                iEffectProcessor.onDestroyInGlThread();
            } else {
                iEffectProcessor.onDestroy();
            }
        }
        List<IMediaRenderer> list = this.mIMediaRendererList;
        if (list != null) {
            for (IMediaRenderer iMediaRenderer : list) {
                if (z) {
                    iMediaRenderer.onDestroyInGlThread();
                } else {
                    iMediaRenderer.onDestroy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnPause(boolean z) {
        int b = fkb.b(this.mIEffectProcessorList);
        for (int i = 0; i < b; i++) {
            IEffectProcessor iEffectProcessor = (IEffectProcessor) fkb.c(this.mIEffectProcessorList, i);
            if (z) {
                iEffectProcessor.onPauseInGlThread();
            } else {
                iEffectProcessor.onPause();
            }
        }
        List<IMediaRenderer> list = this.mIMediaRendererList;
        if (list != null) {
            for (IMediaRenderer iMediaRenderer : list) {
                if (z) {
                    iMediaRenderer.onPauseInGlThread();
                } else {
                    iMediaRenderer.onPause();
                }
            }
        }
    }

    private void scissor(GLViewPortLocation gLViewPortLocation) {
        if (!(this.mScaleX == 1.0f && this.mScaleY == 1.0f) && gLViewPortLocation.width > tkb.c()) {
            GLES20.glEnable(3089);
            int i = gLViewPortLocation.width;
            int ceil = (int) Math.ceil((((1.0f - this.mScaleX) * i) / 2.0f) - (((i - tkb.c()) * this.mScaleX) / 2.0f));
            int ceil2 = (int) Math.ceil((1.0f - this.mScaleY) * gLViewPortLocation.height);
            int ceil3 = (int) Math.ceil((gLViewPortLocation.width - tkb.c()) * this.mScaleX);
            int ceil4 = (int) Math.ceil(gLViewPortLocation.height * this.mScaleY);
            GLES20.glScissor(ceil, ceil2, ceil3, ceil4);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glScissor((gLViewPortLocation.width - ceil) - ceil3, ceil2, ceil3, ceil4);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glDisable(3089);
        }
    }

    public PointF getCenterPointOfViewport() {
        float f = this.mScaleX;
        float width = (((getWidth() * 1.0f) / 2.0f) * f) + ((((1.0f - f) * getWidth()) * 1.0f) / 2.0f) + (((getWidth() * this.mTx) * 1.0f) / 2.0f);
        float f2 = this.mScaleY;
        return new PointF(width, ((((getHeight() * 1.0f) / 2.0f) * f2) + ((((1.0f - f2) * getHeight()) * 1.0f) / 2.0f)) - (((getHeight() * this.mTy) * 1.0f) / 2.0f));
    }

    public void onDestroy() {
        notifyOnDestroy(false);
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.6
            @Override // java.lang.Runnable
            public void run() {
                MediaPreviewView.this.mRenderer.onDestroy();
                if (MediaPreviewView.this.mSurfaceTexture != null) {
                    MediaPreviewView.this.mSurfaceTexture.release();
                    MediaPreviewView.this.mSurfaceTexture = null;
                }
                int i = MediaPreviewView.this.mTextureIdEXT;
                if (i != 0) {
                    GLES20.glDeleteTextures(1, new int[]{i}, 0);
                    MediaPreviewView.this.mTextureIdEXT = 0;
                }
                MediaPreviewView.this.notifyOnDestroy(true);
            }
        });
    }

    public void onDrawFrame(GL10 gl10) {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        this.mRenderer.setUpdateTexture(this.mTextureIdEXT, this.mSTMatrix, 0);
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnDrawFrameFrequencyListener
    public void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation) {
        scissor(gLViewPortLocation);
        MediaGLRenderer.OnDrawFrameFrequencyListener onDrawFrameFrequencyListener = this.mOnDrawFrameListener;
        if (onDrawFrameFrequencyListener != null) {
            onDrawFrameFrequencyListener.onDrawFrameFrequency(gLViewPortLocation);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        notifyOnPause(false);
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.5
            @Override // java.lang.Runnable
            public void run() {
                MediaPreviewView.this.mRenderer.onPause();
                MediaPreviewView.this.notifyOnPause(true);
            }
        });
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        super.onResume();
        this.mRenderer.onResume();
        int b = fkb.b(this.mIEffectProcessorList);
        for (int i = 0; i < b; i++) {
            ((IEffectProcessor) fkb.c(this.mIEffectProcessorList, i)).onResume();
        }
        List<IMediaRenderer> list = this.mIMediaRendererList;
        if (list != null) {
            for (IMediaRenderer iMediaRenderer : list) {
                iMediaRenderer.onResume();
            }
        }
        requestRender();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (this.mRenderer.getFullScreenEXT() != null) {
            this.mTextureIdEXT = this.mRenderer.getFullScreenEXT().createTextureObject();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureIdEXT);
            this.mSurfaceTexture = surfaceTexture;
            setSurfaceTexture(surfaceTexture, this.mTextureIdEXT);
        }
    }

    public void setEffectProcessor(List<IEffectProcessor> list) {
        this.mIEffectProcessorList = list;
        this.mRenderer.setEffectProcessor(list);
    }

    public void setGlClearColor(final float f, final float f2, final float f3, final float f4) {
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.4
            @Override // java.lang.Runnable
            public void run() {
                MediaPreviewView.this.mRed = f;
                MediaPreviewView.this.mGreen = f2;
                MediaPreviewView.this.mBlue = f3;
                MediaPreviewView.this.mAlpha = f4;
                MediaPreviewView.this.mRenderer.setGlClearColor(f, f2, f3, f4);
                MediaPreviewView.this.requestRender();
            }
        });
    }

    public void setMediaRenderers(List<IMediaRenderer> list) {
        this.mIMediaRendererList = list;
        this.mRenderer.setMediaRenderer(list);
    }

    public void setOnDrawFrameListener(MediaGLRenderer.OnDrawFrameFrequencyListener onDrawFrameFrequencyListener) {
        this.mOnDrawFrameListener = onDrawFrameFrequencyListener;
    }

    public void setOnSurfaceTextureCreateListener(OnSurfaceTextureCreateListener onSurfaceTextureCreateListener) {
        this.mOnSurfaceTextureCreateListener = onSurfaceTextureCreateListener;
    }

    public void setScaleAndTranslate(final float f, final float f2, final float f3, final float f4) {
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.3
            @Override // java.lang.Runnable
            public void run() {
                MediaPreviewView mediaPreviewView = MediaPreviewView.this;
                float f5 = f;
                mediaPreviewView.mScaleX = f5;
                float f6 = f2;
                mediaPreviewView.mScaleY = f6;
                float f7 = f3;
                mediaPreviewView.mTx = f7;
                float f8 = f4;
                mediaPreviewView.mTy = f8;
                mediaPreviewView.mRenderer.setScaleAndTranslate(f5, f6, f7, f8);
                MediaPreviewView.this.requestRender();
            }
        });
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture, int i) {
        if (surfaceTexture == null) {
            return;
        }
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        OnSurfaceTextureCreateListener onSurfaceTextureCreateListener = this.mOnSurfaceTextureCreateListener;
        if (onSurfaceTextureCreateListener != null) {
            onSurfaceTextureCreateListener.onSurfaceTextureCreate(surfaceTexture, i);
        }
        requestRender();
    }

    public void setVlogCore(sg0 sg0Var) {
        this.mRenderer.setCore(sg0Var);
    }

    public void setWaitingDrawFrame(final boolean z) {
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.2
            @Override // java.lang.Runnable
            public void run() {
                MediaPreviewView.this.mRenderer.setWaitingDrawFrame(z);
            }
        });
    }
}
