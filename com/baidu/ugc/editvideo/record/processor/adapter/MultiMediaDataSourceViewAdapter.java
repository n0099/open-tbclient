package com.baidu.ugc.editvideo.record.processor.adapter;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import d.a.v0.b;
import d.a.v0.t.c;
import d.a.v0.t.h;
import d.a.z.b.a.e;
import d.a.z.b.a.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes5.dex */
public class MultiMediaDataSourceViewAdapter implements OnMediaPreviewTouchEventListener, EffectChangeObserver, MediaTrackChangeObserver, IMultiMediaDataSourceView, OnDrawUpdateTextureListener, OnPreRunnableTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAutoChange;
    public boolean mCanDoProcessor;
    public boolean mCompat;
    public Context mContext;
    public IMultiMediaDataSource mDataSource;
    public String mEditTrackType;
    public EGLContext mEglContext;
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
    public j mVlogEditCore;
    public OnMultiMediaDataTextureListener onMultiMediaDataTextureListener;
    public int reDrawCount;

    /* loaded from: classes5.dex */
    public interface OnMultiMediaDataTextureListener {
        void onFrameAvailable(SurfaceTexture surfaceTexture);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiMediaDataSourceViewAdapter() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiMediaDataSourceViewAdapter(Context context, boolean z) {
        this(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = (Context) new WeakReference(context).get();
    }

    public MultiMediaDataSourceViewAdapter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUpdateTextureMode = 0;
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = new MultiMediaPreGlRenderer();
        this.mInnerRenderer = multiMediaPreGlRenderer;
        this.mCompat = z;
        multiMediaPreGlRenderer.setCompat(z);
    }

    public static void buildDefault(List<IEffectProcessor> list, List<IMediaRenderer> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, list2) == null) {
            InputProcessor inputProcessor = new InputProcessor();
            SuperpositionProcessor superpositionProcessor = new SuperpositionProcessor();
            AREditProcessor aREditProcessor = new AREditProcessor();
            MiniVideoEffectProcessor miniVideoEffectProcessor = new MiniVideoEffectProcessor();
            ThemeProcessor themeProcessor = new ThemeProcessor();
            list.add(aREditProcessor);
            list.add(inputProcessor);
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
    }

    private boolean isStickerLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? TextUtils.equals(this.mEditTrackType, FaceItem.DIR_STICKER) || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, "cover_sticker") : invokeV.booleanValue;
    }

    private void onSubtitleAndStickerChanged(List<IMediaRenderer> list) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, list) == null) || (indexOf = this.mDataSource.getUpdateMediaTracks().indexOf((subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mDataSource.getUpdateMediaTracks())))) < 0) {
            return;
        }
        MultiMediaDataTrack multiMediaDataTrack = this.mDataSource.getMultiMediaDataTrack().get(indexOf);
        for (IMediaRenderer iMediaRenderer : list) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setData(subtitleAndStickerTrack, multiMediaDataTrack);
                return;
            }
        }
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
            if (multiMediaPreGlRenderer != null) {
                multiMediaPreGlRenderer.releaseProgram();
            }
            IMultiMediaDataSource iMultiMediaDataSource = this.mDataSource;
            if (iMultiMediaDataSource != null) {
                iMultiMediaDataSource.releaseTextures();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void addCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, multiMediaData) == null) || h.e(this.mMediaRenderers)) {
            return;
        }
        getRunOnDrawList().add(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceViewAdapter this$0;
            public final /* synthetic */ MultiMediaData val$coverStickerData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, multiMediaData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$coverStickerData = multiMediaData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (IMediaRenderer iMediaRenderer : this.this$0.mMediaRenderers) {
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).setCoverStickerData(this.val$coverStickerData);
                            return;
                        }
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void addCoverStickerDataList(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || h.e(this.mMediaRenderers)) {
            return;
        }
        getRunOnDrawList().add(new Runnable(this, list) { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceViewAdapter this$0;
            public final /* synthetic */ List val$coverStickerDataList;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$coverStickerDataList = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (IMediaRenderer iMediaRenderer : this.this$0.mMediaRenderers) {
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).setCoverStickerDataList(this.val$coverStickerDataList);
                            return;
                        }
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    public void buildProcessorsAndRenderers(List<IEffectProcessor> list, List<IMediaRenderer> list2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, list2, z) == null) {
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
    }

    public boolean canDoProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCanDoProcessor : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void cancelStickerSelected() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || h.e(this.mMediaRenderers)) {
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
    public void capture(int i2, long j, int i3, int i4) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || (multiMediaPreGlRenderer = this.mInnerRenderer) == null) {
            return;
        }
        try {
            int onPreProcess = multiMediaPreGlRenderer.onPreProcess(i2, j);
            int i5 = this.mUpdateTextureId;
            int i6 = this.mUpdateTextureMode;
            float[] fArr = this.mUpdateMatrix;
            if (this.mIEffectProcessorList != null) {
                for (IEffectProcessor iEffectProcessor : this.mIEffectProcessorList) {
                    if (!(iEffectProcessor instanceof MiniVideoEffectProcessor)) {
                        iEffectProcessor.setInputTextureMode(i6);
                        int onProcessFrame = iEffectProcessor.onProcessFrame(this.mVlogEditCore, i5, fArr);
                        if (onProcessFrame > 0 && onProcessFrame != i5) {
                            i6 = iEffectProcessor.getOutputTextureMode();
                            i5 = onProcessFrame;
                        }
                    }
                }
                onPreProcess = i5;
            }
            GLES20.glViewport(0, 0, i3, i4);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            if (this.mMediaRenderers != null) {
                GLViewPortLocation gLViewPortLocation = new GLViewPortLocation(0, 0, i3, i4);
                for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).setUpEditLayer("cover_sticker");
                    }
                    iMediaRenderer.onGLLocation(gLViewPortLocation);
                    iMediaRenderer.setPreviewSize(this.mSurfaceWidth, this.mSurfaceHeight);
                    iMediaRenderer.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                    iMediaRenderer.setTextureMode(i6);
                    iMediaRenderer.onDrawFrame(this.mVlogEditCore, onPreProcess, fArr);
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        ((MultiMediaCoverStickerRenderer) iMediaRenderer).setUpEditLayer("");
                    }
                    iMediaRenderer.setPreviewSize(0, 0);
                }
            }
        } catch (Exception e2) {
            c.g(e2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void deleteCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, multiMediaData) == null) || h.e(this.mMediaRenderers)) {
            return;
        }
        getRunOnDrawList().add(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceViewAdapter this$0;
            public final /* synthetic */ MultiMediaData val$coverStickerData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, multiMediaData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$coverStickerData = multiMediaData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (IMediaRenderer iMediaRenderer : this.this$0.mMediaRenderers) {
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).deleteCoverStickerData(this.val$coverStickerData);
                            return;
                        }
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void deleteStickerData(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, multiMediaData, str) == null) || TextUtils.isEmpty(str) || h.e(this.mMediaRenderers)) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (h.e(this.mMediaRenderers)) {
                return new ArrayList(1);
            }
            for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                    return ((MultiMediaCoverStickerRenderer) iMediaRenderer).getCoverStickerDataList();
                }
            }
            return new ArrayList(1);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRect2D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
            if (onDrawUpdateTextureListener != null) {
                return onDrawUpdateTextureListener.getFullFrameRect2D();
            }
            return null;
        }
        return (FullFrameRect) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRectEXT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
            if (onDrawUpdateTextureListener != null) {
                return onDrawUpdateTextureListener.getFullFrameRectEXT();
            }
            return null;
        }
        return (FullFrameRect) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnPreRunnableTask
    public LinkedList<Runnable> getRunOnDrawList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
            if (multiMediaPreGlRenderer == null) {
                return null;
            }
            return multiMediaPreGlRenderer.getRunOnDrawList();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public PointF getStickerCenterPoint() {
        InterceptResult invokeV;
        OnMediaPreviewTouchEventListener onMediaPreviewTouchEventListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!TextUtils.isEmpty(this.mEditTrackType) && isStickerLayer() && !h.e(this.mMediaRenderers)) {
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
        return (PointF) invokeV.objValue;
    }

    public boolean handleTouchEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? isStickerLayer() || TextUtils.equals(this.mEditTrackType, "input") : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void moveBoundsCheckEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || h.e(this.mMediaRenderers)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || h.e(this.mIEffectProcessorList)) {
            return;
        }
        for (int i2 = 0; i2 < this.mIEffectProcessorList.size(); i2++) {
            IEffectProcessor iEffectProcessor = this.mIEffectProcessorList.get(i2);
            if (iEffectProcessor instanceof MiniVideoEffectProcessor) {
                ((MiniVideoEffectProcessor) iEffectProcessor).needDrawEffect(z);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void notifyStickerDataChange(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || h.e(this.mMediaRenderers)) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, list2) == null) && this.mAutoChange) {
            onSubtitleAndStickerChanged(list2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            if (this.mCompat) {
                if (this.mUpdateTextureListener != null) {
                    getRunOnDrawList().add(new Runnable(this, list) { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSourceViewAdapter this$0;
                        public final /* synthetic */ List val$updateMediaTracks;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, list};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$updateMediaTracks = list;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mUpdateTextureListener == null) {
                                return;
                            }
                            this.this$0.mUpdateTextureListener.onChanged(this.val$updateMediaTracks);
                        }
                    });
                }
            } else if (!h.e(this.mIEffectProcessorList)) {
                for (IEffectProcessor iEffectProcessor : this.mIEffectProcessorList) {
                    if (iEffectProcessor instanceof AEffectProcessor) {
                        ((AEffectProcessor) iEffectProcessor).updateMediaTracks(list);
                    }
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, map, list) == null) {
            if (this.mCompat) {
                if (this.mUpdateTextureListener != null) {
                    getRunOnDrawList().add(new Runnable(this, map, list) { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSourceViewAdapter this$0;
                        public final /* synthetic */ Map val$shaderConfigMap;
                        public final /* synthetic */ List val$updateMediaTracks;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, map, list};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$shaderConfigMap = map;
                            this.val$updateMediaTracks = list;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mUpdateTextureListener == null) {
                                return;
                            }
                            this.this$0.mUpdateTextureListener.onChanged(this.val$shaderConfigMap, this.val$updateMediaTracks);
                        }
                    });
                }
            } else if (!h.e(this.mIEffectProcessorList)) {
                for (IEffectProcessor iEffectProcessor : this.mIEffectProcessorList) {
                    if (iEffectProcessor instanceof AEffectProcessor) {
                        ((AEffectProcessor) iEffectProcessor).changeEffect(map, list);
                    }
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            release();
            this.mInnerRenderer = null;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onDrawFrame(int i2, long j) {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (onDrawUpdateTextureListener = this.mUpdateTextureListener) == null) {
            return;
        }
        onDrawUpdateTextureListener.onDrawFrame(i2, j);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        EGLContext eGLContext;
        IMultiMediaDataSource iMultiMediaDataSource;
        EGLContext eGLContext2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gl10) == null) {
            MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
            if (multiMediaPreGlRenderer != null) {
                if (!isStickerLayer() || (iMultiMediaDataSource = this.mDataSource) == null || !iMultiMediaDataSource.isPaused() || this.mSeeking || (eGLContext2 = this.mEglContext) == null || !eGLContext2.equals(EGL14.eglGetCurrentContext())) {
                    this.mCanDoProcessor = true;
                    this.reDrawCount++;
                    multiMediaPreGlRenderer.onPreProcess();
                } else {
                    this.mCanDoProcessor = false;
                    this.reDrawCount = 0;
                    multiMediaPreGlRenderer.runPendingOnProcessTasks();
                }
            }
            this.mSeeking = false;
            if (this.reDrawCount <= 3 || (eGLContext = this.mEglContext) == null || eGLContext.equals(EGL14.eglGetCurrentContext())) {
                return;
            }
            this.mEglContext = EGL14.eglGetCurrentContext();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, surfaceTexture) == null) {
            OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
            if (onDrawUpdateTextureListener != null) {
                onDrawUpdateTextureListener.onFrameAvailable(surfaceTexture);
            }
            OnMultiMediaDataTextureListener onMultiMediaDataTextureListener = this.onMultiMediaDataTextureListener;
            if (onMultiMediaDataTextureListener != null) {
                onMultiMediaDataTextureListener.onFrameAvailable(surfaceTexture);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onSizeChange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            this.mSurfaceWidth = i2;
            this.mSurfaceHeight = i3;
            OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
            if (onDrawUpdateTextureListener != null) {
                onDrawUpdateTextureListener.onSizeChange(i2, i3);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048603, this, gl10, i2, i3) == null) || (multiMediaPreGlRenderer = this.mInnerRenderer) == null) {
            return;
        }
        multiMediaPreGlRenderer.onSizeChange(i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, gl10, eGLConfig) == null) {
            if (this.mEglContext == null) {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            MultiMediaPreGlRenderer multiMediaPreGlRenderer = this.mInnerRenderer;
            if (multiMediaPreGlRenderer != null) {
                multiMediaPreGlRenderer.initProgram();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public boolean onTouchDown(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            if (!TextUtils.isEmpty(this.mEditTrackType) && !h.e(this.mMediaRenderers) && isStickerLayer()) {
                for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                    if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).onTouchDown(f2, f3, f4, f5);
                            return true;
                        }
                    } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                        ((MultiMediaStickerRenderer) iMediaRenderer).onTouchDown(f2, f3, f4, f5);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchMove(float f2, float f3, float f4, float f5) {
        MultiMediaData multiMediaData;
        OnMediaPreviewTouchEventListener onMediaPreviewTouchEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) || TextUtils.isEmpty(this.mEditTrackType)) {
            return;
        }
        if (!isStickerLayer()) {
            if (TextUtils.equals(this.mEditTrackType, "input")) {
                IMultiMediaDataSource iMultiMediaDataSource = this.mDataSource;
                if (!(iMultiMediaDataSource instanceof IVlogEditManager) || (multiMediaData = ((IVlogEditManager) iMultiMediaDataSource).getMultiMediaData(iMultiMediaDataSource.getCurrentIndex())) == null) {
                    return;
                }
                multiMediaData.x += f2;
                multiMediaData.y += f3;
                multiMediaData.angle += f5;
                multiMediaData.scaleX *= f4;
                multiMediaData.scaleY *= f4;
            }
        } else if (!h.e(this.mMediaRenderers)) {
            for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                    if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                        onMediaPreviewTouchEventListener = (MultiMediaCoverStickerRenderer) iMediaRenderer;
                        onMediaPreviewTouchEventListener.onTouchMove(f2, f3, f4, f5);
                        return;
                    }
                } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                    onMediaPreviewTouchEventListener = (MultiMediaStickerRenderer) iMediaRenderer;
                    onMediaPreviewTouchEventListener.onTouchMove(f2, f3, f4, f5);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchUp(float f2, float f3) {
        OnMediaPreviewTouchEventListener onMediaPreviewTouchEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || TextUtils.isEmpty(this.mEditTrackType) || !isStickerLayer() || h.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                    onMediaPreviewTouchEventListener = (MultiMediaCoverStickerRenderer) iMediaRenderer;
                    onMediaPreviewTouchEventListener.onTouchUp(f2, f3);
                    return;
                }
            } else if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                onMediaPreviewTouchEventListener = (MultiMediaStickerRenderer) iMediaRenderer;
                onMediaPreviewTouchEventListener.onTouchUp(f2, f3);
                return;
            }
        }
    }

    public void onVideoSizeChanged(int i2, int i3) {
        MultiMediaPreGlRenderer multiMediaPreGlRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) || (multiMediaPreGlRenderer = this.mInnerRenderer) == null) {
            return;
        }
        multiMediaPreGlRenderer.onSizeChange(i2, i3);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void replaceCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, multiMediaData) == null) || h.e(this.mMediaRenderers)) {
            return;
        }
        getRunOnDrawList().add(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceViewAdapter this$0;
            public final /* synthetic */ MultiMediaData val$coverStickerData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, multiMediaData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$coverStickerData = multiMediaData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (IMediaRenderer iMediaRenderer : this.this$0.mMediaRenderers) {
                        if (iMediaRenderer instanceof MultiMediaCoverStickerRenderer) {
                            ((MultiMediaCoverStickerRenderer) iMediaRenderer).replaceCoverStickerData(this.val$coverStickerData);
                            return;
                        }
                    }
                }
            }
        });
        onFrameAvailable(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void seek(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.mSeeking = true;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setCurrentStickerData(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048611, this, i2, str) == null) || TextUtils.isEmpty(str) || h.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setCurrentStickerData(i2, str);
                onFrameAvailable(null);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setIMultiMediaDataSource(IMultiMediaDataSource iMultiMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iMultiMediaDataSource) == null) {
            this.mDataSource = iMultiMediaDataSource;
            if (iMultiMediaDataSource != null) {
                iMultiMediaDataSource.registerObserver((EffectChangeObserver) this);
                iMultiMediaDataSource.registerObserver((MediaTrackChangeObserver) this);
            }
            this.mInnerRenderer.setMultiMediaDataSource(iMultiMediaDataSource);
        }
    }

    public void setMultiMediaDataTextureListener(OnMultiMediaDataTextureListener onMultiMediaDataTextureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onMultiMediaDataTextureListener) == null) {
            this.onMultiMediaDataTextureListener = onMultiMediaDataTextureListener;
        }
    }

    public void setOnChangeCoverStickerListener(OnChangeStickerListener onChangeStickerListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, onChangeStickerListener) == null) || h.e(this.mMediaRenderers)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, onChangeStickerListener) == null) || h.e(this.mMediaRenderers)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onDrawUpdateTextureListener) == null) {
            this.mUpdateTextureListener = onDrawUpdateTextureListener;
            this.mInnerRenderer.setOnDrawUpdateTextureListener(this);
            if (onDrawUpdateTextureListener == null || !this.mCompat) {
                return;
            }
            j jVar = new j();
            this.mVlogEditCore = jVar;
            jVar.j(b.d().b());
            onDrawUpdateTextureListener.setVlogCore(this.mVlogEditCore);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerDeleteButton(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, str, str2) == null) || h.e(this.mMediaRenderers)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, str, str2) == null) || h.e(this.mMediaRenderers)) {
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
    public void setStickerMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048619, this, f2) == null) || h.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerMaxScale(f2);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048620, this, f2) == null) || h.e(this.mMediaRenderers)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
            if (iMediaRenderer instanceof MultiMediaStickerRenderer) {
                ((MultiMediaStickerRenderer) iMediaRenderer).setStickerMinScale(f2);
                return;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView
    public void setStickerRotationButton(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) || h.e(this.mMediaRenderers)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mEditTrackType = str;
            if (h.e(this.mMediaRenderers)) {
                return;
            }
            for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                if (iMediaRenderer instanceof MultiMediaEditBaseRenderer) {
                    ((MultiMediaEditBaseRenderer) iMediaRenderer).setUpEditLayer(str);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setUpdateTexture(int i2, float[] fArr, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3)}) == null) {
            this.mUpdateTextureId = i2;
            this.mUpdateMatrix = fArr;
            this.mUpdateTextureMode = i3;
            OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
            if (onDrawUpdateTextureListener != null) {
                onDrawUpdateTextureListener.setUpdateTexture(i2, fArr, i3);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSourceView, com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVideoRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048624, this, f2) == null) {
            this.mUpdateTextureListener.setVideoRatio(f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVlogCore(e eVar) {
        OnDrawUpdateTextureListener onDrawUpdateTextureListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, eVar) == null) || (onDrawUpdateTextureListener = this.mUpdateTextureListener) == null) {
            return;
        }
        onDrawUpdateTextureListener.setVlogCore(eVar);
    }
}
