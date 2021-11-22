package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.a0.a.f.a;
import b.a.a0.b.a.j;
import b.a.x0.b;
import b.a.x0.t.c;
import b.a.x0.t.d;
import b.a.x0.t.h;
import b.a.x0.t.m;
import b.a.x0.t.n;
import b.a.x0.t.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.AREditSticker;
import com.baidu.ugc.editvideo.data.ImageQualityData;
import com.baidu.ugc.editvideo.data.MediaInfo;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.AREditProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MultiMediaStickerRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@TargetApi(18)
/* loaded from: classes9.dex */
public class ComposeThemeVideoModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaTrackConfig editTrackConfig;
    public Map<BeautyType, Object> mAREditBeautyMap;
    public Map<BeautyType, Object> mAREditBeautyMapForMale;
    public AREditSticker mAREditSticker;
    public String mAudioPath;
    public InnerAudioProcessor mAudioProcessor;
    public long mClipDuration;
    public long mClipPoint;
    public boolean mCompat;
    public Context mContext;
    public boolean mEncodeHevcVideo;
    public FilterValue mFilterValue;
    public int mFrameRate;
    public ImageQualityData mImageQualityData;
    public boolean mIsAddWaterMark;
    public volatile boolean mIsAudioReady;
    public boolean mIsDefaultMale;
    public volatile boolean mIsMuxerStop;
    public boolean mIsRunning;
    public volatile boolean mIsVideoReady;
    public OnGenFilterVideoListener mListener;
    public InnerMuxerWrapper mMuxer;
    public volatile boolean mOnInterrupt;
    public int mOutBitRate;
    public int mOutHeight;
    public int mOutWidth;
    public String mOutputPath;
    public BaseOutputSurface mOutputSurface;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float mRotation;
    public String mSourcePath;
    public List<MultiMediaData> mStickerList;
    public SubTitleConfig mSubTitleConfig;
    public List<SubTitleUnit> mSubTitleUnits;
    public VideoEffectData mVideoEffectData;
    public InnerMediaProcessor mVideoProcessor;
    public String mWaterMarkBase64;
    public List<MultiMediaDataTrack> mediaDataTracks;

    public ComposeThemeVideoModel(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsAddWaterMark = false;
        this.mIsRunning = false;
        this.mCompat = false;
        this.mIsDefaultMale = false;
        this.mContext = context;
        this.mSourcePath = str;
        this.mOutputPath = str2;
    }

    public ComposeThemeVideoModel(Context context, List<MultiMediaDataTrack> list, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsAddWaterMark = false;
        this.mIsRunning = false;
        this.mCompat = false;
        this.mIsDefaultMale = false;
        this.mContext = context;
        this.mediaDataTracks = list;
        this.mAudioPath = str;
        this.mOutputPath = str2;
    }

    private void buildProcessorAndRenderer(List<IEffectProcessor> list, List<IMediaRenderer> list2, MultiMediaOutputSurface multiMediaOutputSurface) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, this, list, list2, multiMediaOutputSurface) == null) {
            if (!this.mCompat) {
                AEffectProcessor aEffectProcessor = new AEffectProcessor();
                MediaTrackConfig mediaTrackConfig = this.editTrackConfig;
                aEffectProcessor.changeEffect(mediaTrackConfig.shaderConfigMapDebug, mediaTrackConfig.mediaTracks);
                list.add(aEffectProcessor);
                return;
            }
            j jVar = new j();
            jVar.j(b.c().getContext());
            multiMediaOutputSurface.setVlogCore(jVar);
            MediaTrackConfig mediaTrackConfig2 = this.editTrackConfig;
            jVar.e(mediaTrackConfig2.mediaTracks, mediaTrackConfig2.shaderConfigMapDebug);
            MultiMediaDataSourceViewAdapter.buildDefault(list, list2);
            for (IEffectProcessor iEffectProcessor : list) {
                if (iEffectProcessor instanceof AREditProcessor) {
                    AREditProcessor aREditProcessor = (AREditProcessor) iEffectProcessor;
                    AREditSticker aREditSticker = this.mAREditSticker;
                    if (aREditSticker != null) {
                        aREditProcessor.setSticker(aREditSticker.sticker, aREditSticker.startTime, aREditSticker.endTime);
                    }
                    aREditProcessor.setBeautyValues((!this.mIsDefaultMale ? h.f(this.mAREditBeautyMap) : !h.f(this.mAREditBeautyMapForMale)) ? this.mAREditBeautyMapForMale : this.mAREditBeautyMap);
                    if (isOpenImageQuality()) {
                        ImageQualityData imageQualityData = this.mImageQualityData;
                        aREditProcessor.setImageQualityStatus(imageQualityData.isOpen, imageQualityData.needDefog, imageQualityData.needDenoise);
                    }
                    aREditProcessor.setSyncInputContent(true);
                    if (!h.f(this.mAREditBeautyMap) && !h.f(this.mAREditBeautyMapForMale)) {
                        aREditProcessor.setEditProcessCallback(new AREditProcessor.DuArEditProcessorCallback(this, aREditProcessor) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public boolean isMale;
                            public final /* synthetic */ ComposeThemeVideoModel this$0;
                            public final /* synthetic */ AREditProcessor val$arEditProcessor;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, aREditProcessor};
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
                                this.val$arEditProcessor = aREditProcessor;
                                this.isMale = this.this$0.mIsDefaultMale;
                            }

                            @Override // com.baidu.ugc.editvideo.record.processor.AREditProcessor.DuArEditProcessorCallback
                            public void onBeautyEnableChanged(a aVar) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                                }
                            }

                            @Override // com.baidu.ugc.editvideo.record.processor.AREditProcessor.DuArEditProcessorCallback
                            public void onChangeGender(boolean z) {
                                AREditProcessor aREditProcessor2;
                                Map<BeautyType, Object> map;
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.isMale == z) {
                                    return;
                                }
                                this.isMale = z;
                                if (z) {
                                    aREditProcessor2 = this.val$arEditProcessor;
                                    map = this.this$0.mAREditBeautyMapForMale;
                                } else {
                                    aREditProcessor2 = this.val$arEditProcessor;
                                    map = this.this$0.mAREditBeautyMap;
                                }
                                aREditProcessor2.setBeautyValues(map);
                            }
                        });
                    }
                }
            }
            if (h.e(this.mStickerList)) {
                return;
            }
            for (IMediaRenderer iMediaRenderer : list2) {
                if ((iMediaRenderer instanceof MultiMediaStickerRenderer) && (indexOf = this.editTrackConfig.mediaTracks.indexOf((subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.editTrackConfig.mediaTracks)))) >= 0) {
                    this.mediaDataTracks.get(indexOf).multiMediaDataList = this.mStickerList;
                    ((MultiMediaStickerRenderer) iMediaRenderer).setData(subtitleAndStickerTrack, this.mediaDataTracks.get(indexOf));
                    iMediaRenderer.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOrReportReady() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.mIsAudioReady && this.mIsVideoReady && !this.mIsMuxerStop) {
            this.mMuxer.stop();
            this.mIsMuxerStop = true;
            u.a().postDelayed(new Runnable(this) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComposeThemeVideoModel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mOnInterrupt) {
                        return;
                    }
                    this.this$0.onMediaComplete();
                }
            }, 200L);
        }
    }

    private boolean hasAudioTrack(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            try {
                return n.g(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                OnGenFilterVideoListener onGenFilterVideoListener = this.mListener;
                if (onGenFilterVideoListener != null) {
                    onGenFilterVideoListener.onGenFilterVideoFail(-1, "check audio track error!" + m.g(e2));
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean isOpenImageQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? ImageQualityData.isValidStatus(this.mImageQualityData) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMediaComplete() {
        int i2;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.mListener != null) {
                File file = new File(this.mOutputPath);
                boolean exists = file.exists();
                String str = "no exception";
                if (exists) {
                    FileInputStream fileInputStream = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                mediaMetadataRetriever.setDataSource(fileInputStream2.getFD());
                                i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                mediaMetadataRetriever.release();
                            } catch (Exception e3) {
                                e = e3;
                                fileInputStream = fileInputStream2;
                                try {
                                    str = e.toString();
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    i2 = -1;
                                    if (exists) {
                                    }
                                    StringBuilder sb = new StringBuilder("output file failed exist = " + exists);
                                    sb.append(" length : ");
                                    sb.append(file.length());
                                    sb.append(" duration : ");
                                    sb.append(i2);
                                    sb.append(" isOnInterrupt : ");
                                    sb.append(this.mOnInterrupt);
                                    sb.append(" eMsg : ");
                                    sb.append(str);
                                    if (file.getParentFile() != null) {
                                    }
                                    if (this.mVideoProcessor != null) {
                                    }
                                    sb.append(", mOutputPath = ");
                                    sb.append(this.mOutputPath);
                                    this.mListener.onGenFilterVideoFail(-1, sb.toString());
                                    this.mIsRunning = false;
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (mediaMetadataRetriever != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            mediaMetadataRetriever = null;
                        } catch (Throwable th3) {
                            th = th3;
                            mediaMetadataRetriever = null;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        mediaMetadataRetriever = null;
                    } catch (Throwable th4) {
                        th = th4;
                        mediaMetadataRetriever = null;
                    }
                    if (exists || file.length() <= 0 || i2 <= 0) {
                        StringBuilder sb2 = new StringBuilder("output file failed exist = " + exists);
                        sb2.append(" length : ");
                        sb2.append(file.length());
                        sb2.append(" duration : ");
                        sb2.append(i2);
                        sb2.append(" isOnInterrupt : ");
                        sb2.append(this.mOnInterrupt);
                        sb2.append(" eMsg : ");
                        sb2.append(str);
                        if (file.getParentFile() != null) {
                            sb2.append(" draftDir exist :");
                            sb2.append(FileUtils.checkFile(file.getParentFile().getParent()));
                        }
                        if (this.mVideoProcessor != null) {
                            sb2.append(", detailMsg = ");
                            sb2.append(this.mVideoProcessor.getMuxerLog());
                        }
                        sb2.append(", mOutputPath = ");
                        sb2.append(this.mOutputPath);
                        this.mListener.onGenFilterVideoFail(-1, sb2.toString());
                    } else {
                        this.mListener.onGenFilterVideoSuccess(this.mOutputPath);
                    }
                }
                i2 = -1;
                if (exists) {
                }
                StringBuilder sb22 = new StringBuilder("output file failed exist = " + exists);
                sb22.append(" length : ");
                sb22.append(file.length());
                sb22.append(" duration : ");
                sb22.append(i2);
                sb22.append(" isOnInterrupt : ");
                sb22.append(this.mOnInterrupt);
                sb22.append(" eMsg : ");
                sb22.append(str);
                if (file.getParentFile() != null) {
                }
                if (this.mVideoProcessor != null) {
                }
                sb22.append(", mOutputPath = ");
                sb22.append(this.mOutputPath);
                this.mListener.onGenFilterVideoFail(-1, sb22.toString());
            }
            this.mIsRunning = false;
        }
    }

    public void initMultiVideoProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            InnerMultiMediaProcessor innerMultiMediaProcessor = new InnerMultiMediaProcessor(this, this.mMuxer, this.mListener) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComposeThemeVideoModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((InnerMuxerWrapper) objArr2[0], (OnGenFilterVideoListener) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onInterrupt() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mOnInterrupt = true;
                        if (this.mListener != null) {
                            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    OnGenFilterVideoListener onGenFilterVideoListener;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (onGenFilterVideoListener = this.this$1.mListener) == null) {
                                        return;
                                    }
                                    onGenFilterVideoListener.onGenFilterVideoAbort();
                                }
                            });
                        }
                        try {
                            File file = new File(this.this$0.mOutputPath);
                            if (file.exists()) {
                                file.delete();
                            }
                            if (this.mMuxer.isStarted()) {
                                this.mMuxer.stop();
                            }
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            this.this$0.mIsMuxerStop = true;
                            this.this$0.mIsRunning = false;
                            throw th;
                        }
                        this.this$0.mIsMuxerStop = true;
                        this.this$0.mIsRunning = false;
                    }
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onPostExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.mIsVideoReady = true;
                        this.this$0.checkOrReportReady();
                    }
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onPreExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onProgress(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048579, this, i2) == null) || this.mListener == null) {
                        return;
                    }
                    u.a().post(new Runnable(this, i2) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 this$1;
                        public final /* synthetic */ int val$percent;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$percent = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            OnGenFilterVideoListener onGenFilterVideoListener;
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (onGenFilterVideoListener = this.this$1.mListener) == null) {
                                return;
                            }
                            onGenFilterVideoListener.onGenFilterVideoProgress(this.val$percent);
                        }
                    });
                }
            };
            this.mVideoProcessor = innerMultiMediaProcessor;
            innerMultiMediaProcessor.setSubTitleUnits(this.mSubTitleUnits);
            ((InnerMultiMediaProcessor) this.mVideoProcessor).setSubTitleConfig(this.mSubTitleConfig);
            ((InnerMultiMediaProcessor) this.mVideoProcessor).setData(this.mediaDataTracks, this.editTrackConfig);
            this.mVideoProcessor.setRecordConfigEncodeHevcVideo(this.mEncodeHevcVideo);
            this.mVideoProcessor.setOutputVideoSize(this.mOutWidth, this.mOutHeight);
            this.mVideoProcessor.setOutputVideoBitRate(this.mOutBitRate);
            this.mVideoProcessor.setFrameRate(this.mFrameRate);
            MultiMediaOutputSurface multiMediaOutputSurface = new MultiMediaOutputSurface((IMultiMediaDataSource) this.mVideoProcessor);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            buildProcessorAndRenderer(arrayList, arrayList2, multiMediaOutputSurface);
            if (!h.e(arrayList)) {
                multiMediaOutputSurface.setEffectProcessors(arrayList);
            }
            if (!h.e(arrayList2)) {
                multiMediaOutputSurface.setMediaRenderers(arrayList2);
            }
            multiMediaOutputSurface.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
            this.mVideoProcessor.setOutputSurface(multiMediaOutputSurface);
            this.mVideoProcessor.start();
        }
    }

    public void initOneVideoProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            InnerVideoProcessor innerVideoProcessor = new InnerVideoProcessor(this, this.mContext, this.mSourcePath, this.mMuxer, this.mListener) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComposeThemeVideoModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r12, r13, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r11, r12, r13, r14};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (String) objArr2[1], (InnerMuxerWrapper) objArr2[2], (OnGenFilterVideoListener) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onInterrupt() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.mListener != null) {
                            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    OnGenFilterVideoListener onGenFilterVideoListener;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (onGenFilterVideoListener = this.this$1.mListener) == null) {
                                        return;
                                    }
                                    onGenFilterVideoListener.onGenFilterVideoAbort();
                                }
                            });
                        }
                        try {
                            File file = new File(this.this$0.mOutputPath);
                            if (file.exists()) {
                                file.delete();
                            }
                            this.mMuxer.stop();
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            this.this$0.mIsMuxerStop = true;
                            this.this$0.mIsRunning = false;
                            throw th;
                        }
                        this.this$0.mIsMuxerStop = true;
                        this.this$0.mIsRunning = false;
                    }
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onPostExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.mIsVideoReady = true;
                        this.this$0.checkOrReportReady();
                    }
                }

                @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                public void onProgress(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.mListener == null) {
                        return;
                    }
                    u.a().post(new Runnable(this, i2) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.4.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass4 this$1;
                        public final /* synthetic */ int val$percent;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$percent = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            OnGenFilterVideoListener onGenFilterVideoListener;
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (onGenFilterVideoListener = this.this$1.mListener) == null) {
                                return;
                            }
                            onGenFilterVideoListener.onGenFilterVideoProgress(this.val$percent);
                        }
                    });
                }
            };
            this.mVideoProcessor = innerVideoProcessor;
            innerVideoProcessor.setRecordConfigEncodeHevcVideo(this.mEncodeHevcVideo);
            this.mVideoProcessor.setOutputVideoSize(this.mOutWidth, this.mOutHeight);
            this.mVideoProcessor.setOutputVideoBitRate(this.mOutBitRate);
            this.mVideoProcessor.setPreviewVideoSize(this.mPreviewWidth, this.mPreviewHeight);
            this.mVideoProcessor.setFrameRate(this.mFrameRate);
            this.mVideoProcessor.setClipRange(this.mClipPoint, this.mClipDuration);
            ((InnerVideoProcessor) this.mVideoProcessor).setRotation(this.mRotation);
            if (this.mOutputSurface == null) {
                OutputSurfaceWithFilter outputSurfaceWithFilter = new OutputSurfaceWithFilter(this.mContext);
                outputSurfaceWithFilter.setFilterValue(this.mFilterValue);
                VideoEffectData videoEffectData = this.mVideoEffectData;
                if (videoEffectData != null) {
                    outputSurfaceWithFilter.setMagicEffectList(videoEffectData.getMagicEffectList());
                }
                if (!TextUtils.isEmpty(this.mWaterMarkBase64)) {
                    outputSurfaceWithFilter.setWaterMarkBitmap(d.a(this.mWaterMarkBase64));
                }
                outputSurfaceWithFilter.setAddWaterMark(this.mIsAddWaterMark);
                this.mOutputSurface = outputSurfaceWithFilter;
            }
            this.mVideoProcessor.setOutputSurface(this.mOutputSurface);
            this.mVideoProcessor.start();
        }
    }

    public void interruptGenVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InnerMediaProcessor innerMediaProcessor = this.mVideoProcessor;
            if (innerMediaProcessor != null) {
                innerMediaProcessor.interrupt();
                this.mVideoProcessor = null;
            }
            InnerAudioProcessor innerAudioProcessor = this.mAudioProcessor;
            if (innerAudioProcessor != null) {
                innerAudioProcessor.interrupt();
                this.mAudioProcessor = null;
            }
        }
    }

    public boolean isAddWaterMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsAddWaterMark : invokeV.booleanValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIsRunning : invokeV.booleanValue;
    }

    public void setAREditBeautyMap(Map<BeautyType, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.mAREditBeautyMap = map;
        }
    }

    public void setAREditBeautyMapForMale(Map<BeautyType, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            this.mAREditBeautyMapForMale = map;
        }
    }

    public void setAREditSticker(AREditSticker aREditSticker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aREditSticker) == null) {
            this.mAREditSticker = aREditSticker;
        }
    }

    public void setAddWaterMark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mIsAddWaterMark = z;
        }
    }

    public void setClipRange(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mClipPoint = j;
            this.mClipDuration = j2;
        }
    }

    public void setCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mCompat = z;
        }
    }

    public void setDefaultMale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsDefaultMale = z;
        }
    }

    public void setFilterValue(FilterValue filterValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, filterValue) == null) {
            this.mFilterValue = filterValue;
        }
    }

    public void setFrameRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mFrameRate = i2;
        }
    }

    public void setImageQualityData(ImageQualityData imageQualityData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, imageQualityData) == null) {
            this.mImageQualityData = imageQualityData;
        }
    }

    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaTrackConfig) == null) {
            this.editTrackConfig = mediaTrackConfig;
        }
    }

    public void setOnGenerateListener(OnGenFilterVideoListener onGenFilterVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onGenFilterVideoListener) == null) {
            this.mListener = onGenFilterVideoListener;
        }
    }

    public void setOutputSurface(BaseOutputSurface baseOutputSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, baseOutputSurface) == null) {
            this.mOutputSurface = baseOutputSurface;
        }
    }

    public void setOutputVideoBitRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mOutBitRate = i2;
        }
    }

    public void setOutputVideoSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            this.mOutWidth = i2;
            this.mOutHeight = i3;
        }
    }

    public void setPreviewVideoSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            this.mPreviewWidth = i2;
            this.mPreviewHeight = i3;
        }
    }

    public void setRecordConfigEncodeHevcVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mEncodeHevcVideo = z;
        }
    }

    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.mRotation = f2;
        }
    }

    public void setStickerList(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.mStickerList = list;
        }
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, subTitleConfig) == null) {
            this.mSubTitleConfig = subTitleConfig;
        }
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.mSubTitleUnits = list;
        }
    }

    public void setVideoEffectData(VideoEffectData videoEffectData) {
        int duration;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, videoEffectData) == null) {
            this.mVideoEffectData = videoEffectData;
            if (VideoEffectData.hasRepeatTimeEffect(videoEffectData)) {
                BaseEffect timeEffect = this.mVideoEffectData.getTimeEffect();
                MediaInfo d2 = n.d(this.mSourcePath);
                if (d2 != null && (duration = (int) d2.getDuration()) > 100) {
                    if (timeEffect.startTime < 0) {
                        timeEffect.startTime = 0;
                    }
                    int i2 = duration - 100;
                    if (timeEffect.endTime > i2) {
                        timeEffect.endTime = i2;
                    }
                }
                if (timeEffect.startTime >= timeEffect.endTime) {
                    this.mVideoEffectData.setTimeEffect(null);
                }
            }
        }
    }

    public void setWaterMarkBase64(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mWaterMarkBase64 = str;
        }
    }

    public void startMuxVideoAsync() {
        boolean hasAudioTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (TextUtils.isEmpty(this.mSourcePath) && h.e(this.mediaDataTracks)) {
                OnGenFilterVideoListener onGenFilterVideoListener = this.mListener;
                if (onGenFilterVideoListener != null) {
                    onGenFilterVideoListener.onGenFilterVideoFail(-1, "filter job cannot start by no input!");
                }
            } else if (this.mIsRunning) {
                OnGenFilterVideoListener onGenFilterVideoListener2 = this.mListener;
                if (onGenFilterVideoListener2 != null) {
                    onGenFilterVideoListener2.onGenFilterVideoFail(-1, "filter job is running!");
                }
            } else {
                this.mIsRunning = true;
                this.mIsAudioReady = false;
                this.mIsVideoReady = false;
                this.mIsMuxerStop = false;
                this.mOnInterrupt = false;
                try {
                    File file = new File(new File(this.mOutputPath).getParent());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Exception e2) {
                    OnGenFilterVideoListener onGenFilterVideoListener3 = this.mListener;
                    if (onGenFilterVideoListener3 != null) {
                        onGenFilterVideoListener3.onGenFilterVideoFail(-1, "filter job start mux error!" + m.g(e2));
                    }
                    c.g(e2);
                }
                try {
                    this.mMuxer = new InnerMuxerWrapper(this.mOutputPath);
                    if (TextUtils.isEmpty(this.mSourcePath)) {
                        hasAudioTrack = hasAudioTrack(this.mAudioPath);
                        if (!hasAudioTrack) {
                            this.mMuxer.setMuxAudio(false);
                            this.mIsAudioReady = true;
                        }
                        initMultiVideoProcessor();
                    } else {
                        hasAudioTrack = hasAudioTrack(this.mSourcePath);
                        if (!hasAudioTrack) {
                            this.mMuxer.setMuxAudio(false);
                            this.mIsAudioReady = true;
                        }
                        initOneVideoProcessor();
                    }
                    if (hasAudioTrack) {
                        String str = TextUtils.isEmpty(this.mSourcePath) ? this.mAudioPath : this.mSourcePath;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        InnerAudioProcessor innerAudioProcessor = new InnerAudioProcessor(this, this.mContext, str, this.mMuxer, this.mListener) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ComposeThemeVideoModel this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r11, str, r13, r14);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r11, str, r13, r14};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((Context) objArr2[0], (String) objArr2[1], (InnerMuxerWrapper) objArr2[2], (OnGenFilterVideoListener) objArr2[3]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                            public void onPostExecute() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.mIsAudioReady = true;
                                    this.this$0.checkOrReportReady();
                                }
                            }
                        };
                        this.mAudioProcessor = innerAudioProcessor;
                        innerAudioProcessor.setClipRange(this.mClipPoint, this.mClipDuration);
                        this.mAudioProcessor.start();
                    }
                } catch (Exception e3) {
                    OnGenFilterVideoListener onGenFilterVideoListener4 = this.mListener;
                    if (onGenFilterVideoListener4 != null) {
                        onGenFilterVideoListener4.onGenFilterVideoFail(-2, "FilterVideoGenerator muxer video async fail " + m.g(e3));
                    }
                }
            }
        }
    }
}
