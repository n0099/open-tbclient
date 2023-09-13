package com.baidu.ugc.editvideo.record.processor.adapter;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tieba.iib;
import com.baidu.tieba.leb;
import com.baidu.tieba.nib;
import com.baidu.tieba.tg0;
import com.baidu.tieba.yg0;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.AREditProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.InputProcessor;
import com.baidu.ugc.editvideo.record.processor.MiniVideoEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.SuperpositionProcessor;
import com.baidu.ugc.editvideo.record.processor.TemplateEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.ThemeProcessor;
import com.baidu.ugc.editvideo.record.processor.glrender.MultiMediaPreGlRenderer;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.renderer.BackgroundRenderer;
import com.baidu.ugc.editvideo.record.renderer.ForegroundRenderer;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer;
import com.baidu.ugc.editvideo.record.renderer.MultiMediaCoverStickerRenderer;
import com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer;
import com.baidu.ugc.editvideo.record.renderer.MultiMediaStickerRenderer;
import com.baidu.ugc.editvideo.record.renderer.ResolutionRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView;
import com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import com.baidu.ugc.editvideo.record.source.multimedia.OnPreRunnableTask;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes9.dex */
public class MultiMediaDataSourceViewAdapter implements OnMediaPreviewTouchEventListener, EffectChangeObserver, MediaTrackChangeObserver, IMultiMediaDataSourceView, OnDrawUpdateTextureListener, OnPreRunnableTask {
    public boolean mAutoChange;
    public boolean mCanDoProcessor;
    public boolean mCompat;
    public Context mContext;
    public IMultiMediaDataSource mDataSource;
    public String mEditTrackType;
    public List<IEffectProcessor> mIEffectProcessorList;
    public MultiMediaPreGlRenderer mInnerRenderer;
    public List<IMediaRenderer> mMediaRenderers;
    public boolean mSeeking;
    public int mSurfaceHeight;
    public int mSurfaceWidth;
    public float[] mUpdateMatrix;
    public int mUpdateTextureId;
    public OnDrawUpdateTextureListener mUpdateTextureListener;
    public int mUpdateTextureMode;
    public yg0 mVlogEditCore;
    public OnMultiMediaDataTextureListener onMultiMediaDataTextureListener;

    /* loaded from: classes9.dex */
    public interface OnMultiMediaDataTextureListener {
        void onFrameAvailable(SurfaceTexture surfaceTexture);
    }

    public MultiMediaDataSourceViewAdapter() {
        this(true);
    }

    public MultiMediaDataSourceViewAdapter(Context context, boolean z) {
        this(z);
        this.mContext = (Context) new WeakReference(context).get();
    }

    public MultiMediaDataSourceViewAdapter(boolean z) {
        this.mUpdateTextureMode = 0;
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = new MultiMediaPreGlRenderer();
        this.mInnerRenderer = multiMediaPreGlRenderer;
        this.mCompat = z;
        multiMediaPreGlRenderer.setCompat(z);
    }

    public static void buildDefault(List<IEffectProcessor> list, List<IMediaRenderer> list2) {
        InputProcessor inputProcessor = new InputProcessor();
        SuperpositionProcessor superpositionProcessor = new SuperpositionProcessor();
        AREditProcessor aREditProcessor = new AREditProcessor();
        MiniVideoEffectProcessor miniVideoEffectProcessor = new MiniVideoEffectProcessor();
        ThemeProcessor themeProcessor = new ThemeProcessor();
        TemplateEffectProcessor templateEffectProcessor = new TemplateEffectProcessor();
        list.add(aREditProcessor);
        list.add(inputProcessor);
        list.add(templateEffectProcessor);
        list.add(superpositionProcessor);
        list.add(themeProcessor);
        list.add(miniVideoEffectProcessor);
        BackgroundRenderer backgroundRenderer = new BackgroundRenderer();
        MediaBaseRenderer mediaBaseRenderer = new MediaBaseRenderer();
        ResolutionRenderer resolutionRenderer = new ResolutionRenderer();
        MultiMediaStickerRenderer multiMediaStickerRenderer = new MultiMediaStickerRenderer();
        ForegroundRenderer foregroundRenderer = new ForegroundRenderer();
        MultiMediaCoverStickerRenderer multiMediaCoverStickerRenderer = new MultiMediaCoverStickerRenderer();
        list2.add(backgroundRenderer);
        list2.add(mediaBaseRenderer);
        list2.add(multiMediaStickerRenderer);
        list2.add(foregroundRenderer);
        list2.add(resolutionRenderer);
        list2.add(multiMediaCoverStickerRenderer);
    }

    private boolean isStickerLayer() {
        return TextUtils.equals(this.mEditTrackType, FaceItem.DIR_STICKER) || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, "cover_sticker");
    }

    private void onSubtitleAndStickerChanged(List<IMediaRenderer> list) {
        MediaTrack subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mDataSource.getUpdateMediaTracks());
        int indexOf = this.mDataSource.getUpdateMediaTracks().indexOf(subtitleAndStickerTrack);
        if (indexOf >= 0) {
            MultiMediaDataTrack multiMediaDataTrack = this.mDataSource.getMultiMediaDataTrack().get(indexOf);
            for (IMediaRenderer iMediaRenderer : list) {
                if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                    ((MultiMediaStickerRenderer) iMediaRenderer).setData(subtitleAndStickerTrack, multiMediaDataTrack);
                    return;
                }
            }
        }
    }

    private void release() {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer != null) {
            multiMediaPreGlRenderer.releaseProgram();
        }
        IMultiMediaDataSource iMultiMediaDataSource = this.mDataSource;
        if (iMultiMediaDataSource != null) {
            iMultiMediaDataSource.releaseTextures();
        }
    }

    private void runOnDraw(Runnable runnable) {
        if (getRunOnDrawList() == null) {
            return;
        }
        getRunOnDrawList().add(runnable);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void addCoverStickerData(final MultiMediaData multiMediaData) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                for (IMediaRenderer iMediaRenderer : MultiMediaDataSourceViewAdapter.this.mMediaRenderers) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).setCoverStickerData(multiMediaData);
                        return;
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void addCoverStickerDataList(final List<MultiMediaData> list) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                for (IMediaRenderer iMediaRenderer : MultiMediaDataSourceViewAdapter.this.mMediaRenderers) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).setCoverStickerDataList(list);
                        return;
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    public void buildProcessorsAndRenderers(List<IEffectProcessor> list, List<IMediaRenderer> list2, boolean z) {
        this.mAutoChange = z;
        buildDefault(list, list2);
        if (!this.mCompat) {
            list.clear();
            list.add(new AEffectProcessor());
        }
        this.mIEffectProcessorList = list;
        this.mMediaRenderers = list2;
        setUpEditLayer(this.mEditTrackType);
    }

    public boolean canDoProcessor() {
        return this.mCanDoProcessor;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void cancelStickerSelected() {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).cancelStickerSelected();
            }
            if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                ((MultiMediaCoverStickerRenderer) iMediaRenderer).cancelStickerSelected();
            }
        }
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnMultiMediaCaptureCallback
    public void capture(int i, long j, int i2, int i3) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer != null) {
            try {
                onDrawFrame(i, j);
                int onPreProcess = multiMediaPreGlRenderer.onPreProcess(i, j);
                int i4 = this.mUpdateTextureId;
                int i5 = this.mUpdateTextureMode;
                float[] fArr = this.mUpdateMatrix;
                if (this.mIEffectProcessorList != null) {
                    for (IEffectProcessor iEffectProcessor : this.mIEffectProcessorList) {
                        if (!(iEffectProcessor instanceof MiniVideoEffectProcessor)) {
                            iEffectProcessor.setInputTextureMode(i5);
                            int onProcessFrame = iEffectProcessor.onProcessFrame(this.mVlogEditCore, i4, fArr);
                            if (onProcessFrame > 0 && onProcessFrame != i4) {
                                i5 = iEffectProcessor.getOutputTextureMode();
                                i4 = onProcessFrame;
                            }
                        }
                    }
                    onPreProcess = i4;
                }
                GLES20.glViewport(0, 0, i2, i3);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                if (this.mMediaRenderers != null) {
                    GLViewPortLocation gLViewPortLocation = new GLViewPortLocation(0, 0, i2, i3);
                    for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).setUpEditLayer("cover_sticker");
                        }
                        iMediaRenderer.onGLLocation(gLViewPortLocation);
                        iMediaRenderer.setPreviewSize(this.mSurfaceWidth, this.mSurfaceHeight);
                        iMediaRenderer.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        iMediaRenderer.setTextureMode(i5);
                        iMediaRenderer.onDrawFrame(this.mVlogEditCore, onPreProcess, fArr);
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).setUpEditLayer("");
                        }
                        iMediaRenderer.setPreviewSize(0, 0);
                    }
                }
            } catch (Exception e) {
                iib.g(e);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void deleteCoverStickerData(final MultiMediaData multiMediaData) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                for (IMediaRenderer iMediaRenderer : MultiMediaDataSourceViewAdapter.this.mMediaRenderers) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).deleteCoverStickerData(multiMediaData);
                        return;
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void deleteStickerData(MultiMediaData multiMediaData, String str) {
        if (TextUtils.isEmpty(str) || nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).deleteStickerData(multiMediaData, str);
                onFrameAvailable(null);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public List<MultiMediaData> getCoverStickerDataList() {
        if (nib.e(this.mMediaRenderers)) {
            return new ArrayList(1);
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                return ((MultiMediaCoverStickerRenderer) iMediaRenderer).getCoverStickerDataList();
            }
        }
        return new ArrayList(1);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRect2D() {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            return onDrawUpdateTextureListener.getFullFrameRect2D();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRectEXT() {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            return onDrawUpdateTextureListener.getFullFrameRectEXT();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnPreRunnableTask
    public LinkedList<Runnable> getRunOnDrawList() {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer == null) {
            return null;
        }
        return multiMediaPreGlRenderer.getRunOnDrawList();
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public PointF getStickerCenterPoint() {
        OnMediaPreviewTouchEventListener onMediaPreviewTouchEventListener;
        if (!TextUtils.isEmpty(this.mEditTrackType) && isStickerLayer() && !nib.e(this.mMediaRenderers)) {
            for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        onMediaPreviewTouchEventListener = (MultiMediaCoverStickerRenderer) iMediaRenderer;
                        return onMediaPreviewTouchEventListener.getStickerCenterPoint();
                    }
                } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                    onMediaPreviewTouchEventListener = (MultiMediaStickerRenderer) iMediaRenderer;
                    return onMediaPreviewTouchEventListener.getStickerCenterPoint();
                }
            }
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public tg0 getVlogCore() {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            return onDrawUpdateTextureListener.getVlogCore();
        }
        return null;
    }

    public boolean handleTouchEvent() {
        return isStickerLayer() || TextUtils.equals(this.mEditTrackType, "input");
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void moveBoundsCheckEnabled(boolean z) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).moveBoundsCheckEnabled(z);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnMultiMediaCaptureCallback
    public void needDrawEffect(boolean z) {
        if (nib.e(this.mIEffectProcessorList)) {
            return;
        }
        for (int i = 0; i < this.mIEffectProcessorList.size(); i++) {
            IEffectProcessor iEffectProcessor = this.mIEffectProcessorList.get(i);
            if (iEffectProcessor instanceof MiniVideoEffectProcessor) {
                ((MiniVideoEffectProcessor) iEffectProcessor).needDrawEffect(z);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void notifyStickerDataChange(String str) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).notifyStickerDataChange(str);
                return;
            }
        }
    }

    public void onChangeProcessorsAndRenderers(List<IEffectProcessor> list, List<IMediaRenderer> list2) {
        if (this.mAutoChange) {
            onSubtitleAndStickerChanged(list2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(final List<MediaTrack> list) {
        if (this.mCompat) {
            if (this.mUpdateTextureListener != null) {
                runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MultiMediaDataSourceViewAdapter.this.mUpdateTextureListener != null) {
                            MultiMediaDataSourceViewAdapter.this.mUpdateTextureListener.onChanged(list);
                        }
                    }
                });
            }
        } else if (!nib.e(this.mIEffectProcessorList)) {
            for (IEffectProcessor iEffectProcessor : this.mIEffectProcessorList) {
                if (iEffectProcessor instanceof AEffectProcessor) {
                    ((AEffectProcessor) iEffectProcessor).updateMediaTracks(list);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(final Map<String, ShaderConfig> map, final List<MediaTrack> list) {
        if (this.mCompat) {
            if (this.mUpdateTextureListener != null) {
                runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MultiMediaDataSourceViewAdapter.this.mUpdateTextureListener != null) {
                            MultiMediaDataSourceViewAdapter.this.mUpdateTextureListener.onChanged(map, list);
                        }
                    }
                });
            }
        } else if (!nib.e(this.mIEffectProcessorList)) {
            for (IEffectProcessor iEffectProcessor : this.mIEffectProcessorList) {
                if (iEffectProcessor instanceof AEffectProcessor) {
                    ((AEffectProcessor) iEffectProcessor).changeEffect(map, list);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onDestroy() {
        release();
        this.mInnerRenderer = null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onDrawFrame(int i, long j) {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            onDrawUpdateTextureListener.onDrawFrame(i, j);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        IMultiMediaDataSource iMultiMediaDataSource;
        onDrawFrame(this.mDataSource.getCurrentIndex(), this.mDataSource.getCurrentPlayTime());
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer != null) {
            if (isStickerLayer() && (iMultiMediaDataSource = this.mDataSource) != null && iMultiMediaDataSource.isPaused() && !this.mSeeking && this.mDataSource.isResourceReady()) {
                this.mCanDoProcessor = false;
                multiMediaPreGlRenderer.runPendingOnProcessTasks();
            } else {
                this.mCanDoProcessor = true;
                multiMediaPreGlRenderer.onPreProcess();
            }
        }
        this.mSeeking = false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            onDrawUpdateTextureListener.onFrameAvailable(surfaceTexture);
        }
        OnMultiMediaDataTextureListener onMultiMediaDataTextureListener = this.onMultiMediaDataTextureListener;
        if (onMultiMediaDataTextureListener != null) {
            onMultiMediaDataTextureListener.onFrameAvailable(surfaceTexture);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onPause() {
        release();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onResume() {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onSizeChange(int i, int i2) {
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            onDrawUpdateTextureListener.onSizeChange(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer != null) {
            multiMediaPreGlRenderer.onSizeChange(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer != null) {
            multiMediaPreGlRenderer.initProgram();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public boolean onTouchDown(float f, float f2, float f3, float f4) {
        if (!TextUtils.isEmpty(this.mEditTrackType) && !nib.e(this.mMediaRenderers) && isStickerLayer()) {
            for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).onTouchDown(f, f2, f3, f4);
                        return true;
                    }
                } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                    ((MultiMediaStickerRenderer) iMediaRenderer).onTouchDown(f, f2, f3, f4);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchMove(float f, float f2, float f3, float f4) {
        OnMediaPreviewTouchEventListener onMediaPreviewTouchEventListener;
        if (TextUtils.isEmpty(this.mEditTrackType)) {
            return;
        }
        if (isStickerLayer()) {
            if (nib.e(this.mMediaRenderers)) {
                return;
            }
            for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        onMediaPreviewTouchEventListener = (MultiMediaCoverStickerRenderer) iMediaRenderer;
                        onMediaPreviewTouchEventListener.onTouchMove(f, f2, f3, f4);
                        return;
                    }
                } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                    onMediaPreviewTouchEventListener = (MultiMediaStickerRenderer) iMediaRenderer;
                    onMediaPreviewTouchEventListener.onTouchMove(f, f2, f3, f4);
                    return;
                }
            }
        } else if (TextUtils.equals(this.mEditTrackType, "input")) {
            IMultiMediaDataSource iMultiMediaDataSource = this.mDataSource;
            if (iMultiMediaDataSource instanceof IVlogEditManager) {
                IVlogEditManager iVlogEditManager = (IVlogEditManager) iMultiMediaDataSource;
                if (iVlogEditManager.isPlaying()) {
                    iVlogEditManager.pause();
                }
                MultiMediaData multiMediaData = iVlogEditManager.getMultiMediaData(this.mDataSource.getCurrentIndex());
                if (multiMediaData != null) {
                    multiMediaData.x += f;
                    multiMediaData.y += f2;
                    multiMediaData.angle += f4;
                    multiMediaData.scaleX *= f3;
                    multiMediaData.scaleY *= f3;
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchUp(float f, float f2) {
        OnMediaPreviewTouchEventListener onMediaPreviewTouchEventListener;
        if (TextUtils.isEmpty(this.mEditTrackType) || !isStickerLayer() || nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                    onMediaPreviewTouchEventListener = (MultiMediaCoverStickerRenderer) iMediaRenderer;
                    onMediaPreviewTouchEventListener.onTouchUp(f, f2);
                    return;
                }
            } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                onMediaPreviewTouchEventListener = (MultiMediaStickerRenderer) iMediaRenderer;
                onMediaPreviewTouchEventListener.onTouchUp(f, f2);
                return;
            }
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
        if (multiMediaPreGlRenderer != null) {
            multiMediaPreGlRenderer.onSizeChange(i, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void replaceCoverStickerData(final MultiMediaData multiMediaData) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                for (IMediaRenderer iMediaRenderer : MultiMediaDataSourceViewAdapter.this.mMediaRenderers) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).replaceCoverStickerData(multiMediaData);
                        return;
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void seek(long j) {
        this.mSeeking = true;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setCurrentStickerData(int i, String str) {
        if (TextUtils.isEmpty(str) || nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setCurrentStickerData(i, str);
                onFrameAvailable(null);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setIMultiMediaDataSource(IMultiMediaDataSource iMultiMediaDataSource) {
        this.mDataSource = iMultiMediaDataSource;
        if (iMultiMediaDataSource != null) {
            iMultiMediaDataSource.registerObserver((EffectChangeObserver) this);
            iMultiMediaDataSource.registerObserver((MediaTrackChangeObserver) this);
        }
        this.mInnerRenderer.setMultiMediaDataSource(iMultiMediaDataSource);
    }

    public void setMultiMediaDataTextureListener(OnMultiMediaDataTextureListener onMultiMediaDataTextureListener) {
        this.onMultiMediaDataTextureListener = onMultiMediaDataTextureListener;
    }

    public void setOnChangeCoverStickerListener(OnChangeStickerListener onChangeStickerListener) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                ((MultiMediaCoverStickerRenderer) iMediaRenderer).setOnChangeStickerListener(onChangeStickerListener);
                return;
            }
        }
    }

    public void setOnChangeStickerListener(OnChangeStickerListener onChangeStickerListener) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setOnChangeStickerListener(onChangeStickerListener);
                return;
            }
        }
    }

    public void setOnDrawUpdateTextureListener(OnDrawUpdateTextureListener onDrawUpdateTextureListener) {
        this.mUpdateTextureListener = onDrawUpdateTextureListener;
        this.mInnerRenderer.setOnDrawUpdateTextureListener(this);
        if (onDrawUpdateTextureListener == null || !this.mCompat) {
            return;
        }
        yg0 yg0Var = new yg0();
        this.mVlogEditCore = yg0Var;
        yg0Var.a(leb.c().getContext());
        onDrawUpdateTextureListener.setVlogCore(this.mVlogEditCore);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerDeleteButton(String str, String str2) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerDeleteButton(str, str2);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerEditButton(String str, String str2) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerEditButton(str, str2);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerMaxScale(float f) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerMaxScale(f);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerMinScale(float f) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerMinScale(f);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerRotationButton(String str, String str2) {
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerRotationButton(str, str2);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setUpEditLayer(String str) {
        this.mEditTrackType = str;
        if (nib.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaEditBaseRenderer) {
                ((MultiMediaEditBaseRenderer) iMediaRenderer).setUpEditLayer(str);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setUpdateTexture(int i, float[] fArr, int i2) {
        this.mUpdateTextureId = i;
        this.mUpdateMatrix = fArr;
        this.mUpdateTextureMode = i2;
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            onDrawUpdateTextureListener.setUpdateTexture(i, fArr, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView, com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVideoRatio(float f) {
        this.mUpdateTextureListener.setVideoRatio(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVlogCore(tg0 tg0Var) {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            onDrawUpdateTextureListener.setVlogCore(tg0Var);
        }
    }
}
