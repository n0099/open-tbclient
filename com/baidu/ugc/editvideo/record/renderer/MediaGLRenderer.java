package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Process;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.afb;
import com.baidu.tieba.pb0;
import com.baidu.tieba.reb;
import com.baidu.tieba.veb;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes9.dex */
public class MediaGLRenderer implements GLSurfaceView.Renderer, IMediaLifeCycle, EffectChangeObserver, MediaTrackChangeObserver {
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public GLViewPortLocation mGLViewPortLocation;
    public boolean mHasSetPro;
    public List<IEffectProcessor> mIEffectProcessors;
    public List<IMediaRenderer> mIMediaRenderers;
    public OnDrawFrameFrequencyListener mOnDrawFrameFrequencyListener;
    public OnEditStickerListener mOnEditStickerListener;
    public OnMediaGLRendererStatusListener mOnMediaGLRendererStatusListener;
    public GLSurfaceView.Renderer mRendererListener;
    public int mSurfaceViewHeight;
    public int mSurfaceViewWidth;
    public reb mTextureReader;
    public float[] mUpdateMatrix;
    public int mUpdateTextureId;
    public float mVideoRatio;
    public pb0 mVlogEdit;
    public boolean mWaitingDrawFrame;
    public int mUpdateTextureMode = 0;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float mTx = 0.0f;
    public float mTy = 0.0f;
    public float mRed = 0.0f;
    public float mGreen = 0.0f;
    public float mBlue = 0.0f;
    public float mAlpha = 0.0f;
    public List<Long> mProcessorCostTimeList = new CopyOnWriteArrayList();

    /* loaded from: classes9.dex */
    public interface OnDrawFrameFrequencyListener {
        void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation);
    }

    /* loaded from: classes9.dex */
    public interface OnEditStickerListener {
        boolean canDoProcessor();
    }

    /* loaded from: classes9.dex */
    public interface OnMediaGLRendererStatusListener {
        void onError(int i, String str);
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
    }

    private void release() {
        reb rebVar = this.mTextureReader;
        if (rebVar != null) {
            rebVar.release();
        }
        pb0 pb0Var = this.mVlogEdit;
        if (pb0Var != null) {
            pb0Var.release();
        }
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect != null) {
            fullFrameRect.release(false);
            this.mFullScreenEXT = null;
        }
        FullFrameRect fullFrameRect2 = this.mFullScreen2D;
        if (fullFrameRect2 != null) {
            fullFrameRect2.release(false);
            this.mFullScreen2D = null;
        }
    }

    public FullFrameRect getFullScreen2D() {
        return this.mFullScreen2D;
    }

    public FullFrameRect getFullScreenEXT() {
        return this.mFullScreenEXT;
    }

    public GLViewPortLocation getGLViewPortLocation() {
        return this.mGLViewPortLocation;
    }

    public int getSurfaceViewHeight() {
        return this.mSurfaceViewHeight;
    }

    public int getSurfaceViewWidth() {
        return this.mSurfaceViewWidth;
    }

    public pb0 getVlogEdit() {
        return this.mVlogEdit;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        release();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        release();
    }

    private void debugProcessorCostTime(long j) {
        this.mProcessorCostTimeList.add(Long.valueOf(j));
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        pb0 pb0Var = this.mVlogEdit;
        if (pb0Var == null) {
            return;
        }
        pb0Var.n(list);
    }

    public void setCore(pb0 pb0Var) {
        this.mVlogEdit = pb0Var;
    }

    public void setEffectProcessor(List<IEffectProcessor> list) {
        this.mIEffectProcessors = list;
    }

    public void setMediaRenderer(List<IMediaRenderer> list) {
        this.mIMediaRenderers = list;
    }

    public void setOnDrawFrameFrequencyListener(OnDrawFrameFrequencyListener onDrawFrameFrequencyListener) {
        this.mOnDrawFrameFrequencyListener = onDrawFrameFrequencyListener;
    }

    public void setOnEditStickerListener(OnEditStickerListener onEditStickerListener) {
        this.mOnEditStickerListener = onEditStickerListener;
    }

    public void setOnMediaGLRendererStatusListener(OnMediaGLRendererStatusListener onMediaGLRendererStatusListener) {
        this.mOnMediaGLRendererStatusListener = onMediaGLRendererStatusListener;
    }

    public void setRendererListener(GLSurfaceView.Renderer renderer) {
        this.mRendererListener = renderer;
    }

    public void setTextureReader(reb rebVar) {
        this.mTextureReader = rebVar;
    }

    public void setWaitingDrawFrame(boolean z) {
        this.mWaitingDrawFrame = z;
    }

    public double getProcessorCostTime() {
        if (afb.e(this.mProcessorCostTimeList)) {
            return 0.0d;
        }
        long j = 0;
        int size = this.mProcessorCostTimeList.size();
        for (Long l : this.mProcessorCostTimeList) {
            j += l.longValue();
        }
        this.mProcessorCostTimeList.clear();
        return j / size;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        pb0 pb0Var = this.mVlogEdit;
        if (pb0Var == null) {
            return;
        }
        pb0Var.f(list, map);
    }

    public void onDrawFrame(int i, long j) {
        pb0 pb0Var = this.mVlogEdit;
        if (pb0Var != null) {
            pb0Var.h(i, j);
            pb0 pb0Var2 = this.mVlogEdit;
            GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
            pb0Var2.c(gLViewPortLocation.width, gLViewPortLocation.height);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        IEffectProcessor next;
        int onProcessFrame;
        if (this.mWaitingDrawFrame) {
            return;
        }
        try {
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            if (this.mGLViewPortLocation == null) {
                setVideoRatio(this.mVideoRatio);
            }
            GLES20.glViewport(0, 0, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            if (this.mRendererListener != null) {
                this.mRendererListener.onDrawFrame(gl10);
            }
            if (this.mUpdateMatrix != null) {
                int i = this.mUpdateTextureId;
                int i2 = this.mUpdateTextureMode;
                float[] fArr = this.mUpdateMatrix;
                if (this.mOnEditStickerListener != null && !this.mOnEditStickerListener.canDoProcessor()) {
                    if (!afb.e(this.mIMediaRenderers)) {
                        for (IMediaRenderer iMediaRenderer : this.mIMediaRenderers) {
                            iMediaRenderer.onGLLocation(this.mGLViewPortLocation);
                            iMediaRenderer.setTextureMode(this.mUpdateTextureMode);
                            iMediaRenderer.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                            iMediaRenderer.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            iMediaRenderer.onDrawFrame(this.mVlogEdit, this.mUpdateTextureId, this.mUpdateMatrix);
                            iMediaRenderer.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                    }
                } else if (afb.e(this.mIEffectProcessors) && afb.e(this.mIMediaRenderers)) {
                    GLES20.glViewport(this.mGLViewPortLocation.x, this.mGLViewPortLocation.y, this.mGLViewPortLocation.width, this.mGLViewPortLocation.height);
                    if (i2 == 0) {
                        this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        this.mFullScreenEXT.drawFrame(i, fArr);
                    } else {
                        this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        this.mFullScreen2D.drawFrame(i, fArr);
                    }
                } else {
                    if (this.mIEffectProcessors != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator<IEffectProcessor> it = this.mIEffectProcessors.iterator();
                        int i3 = i2;
                        int i4 = i3;
                        loop1: while (true) {
                            int i5 = i;
                            while (it.hasNext()) {
                                next = it.next();
                                next.setInputTextureMode(i4);
                                next.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                                onProcessFrame = next.onProcessFrame(this.mVlogEdit, i5, fArr);
                                if (onProcessFrame <= 0 || onProcessFrame == i5) {
                                }
                            }
                            i3 = next.getOutputTextureMode();
                            i4 = i3;
                            i = onProcessFrame;
                        }
                        debugProcessorCostTime(System.currentTimeMillis() - currentTimeMillis);
                        i2 = i3;
                    }
                    this.mUpdateTextureId = i;
                    this.mUpdateTextureMode = i2;
                    if (!afb.e(this.mIMediaRenderers)) {
                        for (IMediaRenderer iMediaRenderer2 : this.mIMediaRenderers) {
                            iMediaRenderer2.onGLLocation(this.mGLViewPortLocation);
                            iMediaRenderer2.setTextureMode(i2);
                            iMediaRenderer2.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                            iMediaRenderer2.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            iMediaRenderer2.onDrawFrame(this.mVlogEdit, i, fArr);
                            iMediaRenderer2.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                    } else {
                        GLES20.glViewport(this.mGLViewPortLocation.x, this.mGLViewPortLocation.y, this.mGLViewPortLocation.width, this.mGLViewPortLocation.height);
                        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                        GLES20.glBlendFunc(770, 771);
                        if (i2 == 0) {
                            this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            this.mFullScreenEXT.drawFrame(i, fArr);
                            this.mFullScreenEXT.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        } else {
                            this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            this.mFullScreen2D.drawFrame(i, fArr);
                            this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                    }
                }
                if (this.mTextureReader != null) {
                    this.mTextureReader.b(i, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
                }
                if (this.mOnDrawFrameFrequencyListener != null) {
                    this.mOnDrawFrameFrequencyListener.onDrawFrameFrequency(this.mGLViewPortLocation);
                    return;
                }
                return;
            }
            throw new RuntimeException("update texture fail");
        } catch (Exception e) {
            veb.g(e);
            OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
            if (onMediaGLRendererStatusListener != null) {
                onMediaGLRendererStatusListener.onError(1251, "onDrawFrame error:" + veb.a(e.getMessage()) + GlUtil.mGLErrorMsg);
                GlUtil.mGLErrorMsg = "";
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        try {
            if (this.mSurfaceViewWidth != 0 && this.mSurfaceViewHeight != 0 && this.mSurfaceViewWidth == i && this.mSurfaceViewHeight == i2) {
                return;
            }
            this.mSurfaceViewWidth = i;
            this.mSurfaceViewHeight = i2;
            setVideoRatio(this.mVideoRatio);
        } catch (Exception e) {
            OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
            if (onMediaGLRendererStatusListener != null) {
                onMediaGLRendererStatusListener.onError(1251, "onSurfaceChanged error:" + veb.a(e.getMessage()) + GlUtil.mGLErrorMsg);
                GlUtil.mGLErrorMsg = "";
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        try {
            if (!this.mHasSetPro) {
                Process.setThreadPriority(-8);
                this.mHasSetPro = true;
            }
            this.mFullScreenEXT = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mFullScreen2D = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            if (this.mIEffectProcessors != null) {
                for (IEffectProcessor iEffectProcessor : this.mIEffectProcessors) {
                    iEffectProcessor.onSurfaceCreate(this.mFullScreenEXT, this.mFullScreen2D);
                }
            }
            if (this.mIMediaRenderers != null) {
                for (IMediaRenderer iMediaRenderer : this.mIMediaRenderers) {
                    iMediaRenderer.onSurfaceCreate(this.mFullScreenEXT, this.mFullScreen2D);
                }
            }
            if (this.mRendererListener != null) {
                this.mRendererListener.onSurfaceCreated(gl10, eGLConfig);
            }
            if (this.mTextureReader != null) {
                this.mTextureReader.a(EGL14.eglGetCurrentContext());
            }
        } catch (Exception e) {
            OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
            if (onMediaGLRendererStatusListener != null) {
                onMediaGLRendererStatusListener.onError(1251, "onSurfaceCreated error:" + veb.a(e.getMessage()) + GlUtil.mGLErrorMsg);
                GlUtil.mGLErrorMsg = "";
            }
        }
    }

    public void setGlClearColor(float f, float f2, float f3, float f4) {
        this.mRed = f;
        this.mGreen = f2;
        this.mBlue = f3;
        this.mAlpha = f4;
    }

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        this.mScaleX = f;
        this.mScaleY = f2;
        this.mTx = f3;
        this.mTy = f4;
    }

    public void setUpdateTexture(int i, float[] fArr, int i2) {
        this.mUpdateTextureId = i;
        this.mUpdateMatrix = fArr;
        this.mUpdateTextureMode = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setVideoRatio(float f) {
        int i;
        int i2;
        GLViewPortLocation gLViewPortLocation;
        List<IMediaRenderer> list;
        List<IEffectProcessor> list2;
        GLSurfaceView.Renderer renderer;
        this.mVideoRatio = f;
        int i3 = this.mSurfaceViewWidth;
        if (i3 != 0 && (i = this.mSurfaceViewHeight) != 0) {
            int i4 = 0;
            if (f != 0.0f) {
                if ((i * 1.0f) / i3 > f) {
                    int i5 = (int) (i3 * f);
                    int i6 = (i - i5) / 2;
                    i = i5;
                    i2 = i6;
                    gLViewPortLocation = this.mGLViewPortLocation;
                    if (gLViewPortLocation != null) {
                        this.mGLViewPortLocation = new GLViewPortLocation(i4, i2, i3, i);
                    } else {
                        gLViewPortLocation.x = i4;
                        gLViewPortLocation.y = i2;
                        gLViewPortLocation.width = i3;
                        gLViewPortLocation.height = i;
                    }
                    list = this.mIMediaRenderers;
                    if (list != null) {
                        for (IMediaRenderer iMediaRenderer : list) {
                            iMediaRenderer.onSurfaceChanged(null, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
                            iMediaRenderer.onGLLocation(this.mGLViewPortLocation);
                        }
                    }
                    list2 = this.mIEffectProcessors;
                    if (list2 != null) {
                        for (IEffectProcessor iEffectProcessor : list2) {
                            iEffectProcessor.setPreviewSize(i3, i);
                        }
                    }
                    renderer = this.mRendererListener;
                    if (renderer == null) {
                        GLViewPortLocation gLViewPortLocation2 = this.mGLViewPortLocation;
                        renderer.onSurfaceChanged(null, gLViewPortLocation2.width, gLViewPortLocation2.height);
                        return;
                    }
                    return;
                }
                int i7 = (int) (i / f);
                i4 = (i3 - i7) / 2;
                i3 = i7;
            }
            i2 = 0;
            gLViewPortLocation = this.mGLViewPortLocation;
            if (gLViewPortLocation != null) {
            }
            list = this.mIMediaRenderers;
            if (list != null) {
            }
            list2 = this.mIEffectProcessors;
            if (list2 != null) {
            }
            renderer = this.mRendererListener;
            if (renderer == null) {
            }
        }
    }
}
