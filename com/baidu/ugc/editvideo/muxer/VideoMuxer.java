package com.baidu.ugc.editvideo.muxer;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.MusicData;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel;
import com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener;
import com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer;
import com.baidu.ugc.editvideo.editvideo.muxer.a;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import com.repackage.ac9;
import com.repackage.bc9;
import com.repackage.cc9;
import com.repackage.g89;
import com.repackage.h89;
import com.repackage.i89;
import com.repackage.j89;
import com.repackage.jc9;
import com.repackage.k89;
import com.repackage.ma9;
import com.repackage.mc9;
import com.repackage.na9;
import com.repackage.oa9;
import com.repackage.p89;
import com.repackage.q89;
import com.repackage.rb9;
import com.repackage.t79;
import com.repackage.u79;
import com.repackage.wb9;
import com.repackage.x89;
import com.repackage.y79;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoMuxer implements j89.b, OnGenFilterVideoListener, a.InterfaceC0272a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILTER_TEMP_DIR_PREFIX = "video_addfilter_";
    public static int MAX_RETRY_COUNT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public j89 mAudioMixtureManager;
    public long mAudioStartTime;
    public a mAuidoVideoMuxer;
    public ComposeThemeVideoModel mComposeThemeVideoModel;
    public volatile boolean mIsAudioCombineDone;
    public boolean mIsUseNewAudioMixture;
    public int mLastAudioPercent;
    public int mLastAudioVideoPercent;
    public int mLastVideoPercent;
    public y79 mListener;
    public volatile VideoMuxerData mMuxerData;
    public volatile boolean mNeedAbort;
    public int mRetryCount;
    public x89 mSoundStreamFileWriter;
    public long mStartTime;
    public volatile boolean misVideoCombineDone;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface MuxerProgressType {
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_AUDIO_VIDEO = 2;
        public static final int TYPE_VIDEO = 0;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1967647395, "Lcom/baidu/ugc/editvideo/muxer/VideoMuxer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1967647395, "Lcom/baidu/ugc/editvideo/muxer/VideoMuxer;");
        }
    }

    public VideoMuxer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNeedAbort = false;
    }

    private List<g89> buildAudioDataList(List<MultiMediaData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, list)) == null) {
            if (wb9.e(list)) {
                return null;
            }
            VideoMuxerData videoMuxerData = this.mMuxerData;
            ArrayList arrayList = new ArrayList();
            boolean z = true;
            for (int i = 0; i < list.size(); i++) {
                MultiMediaData multiMediaData = list.get(i);
                int i2 = multiMediaData.type;
                if (i2 == 0) {
                    int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) wb9.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                    int i3 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd == 0) {
                        multiMediaDataRealEnd = (int) multiMediaData.end;
                    }
                    arrayList.add(new g89(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
                } else if (i2 == 1) {
                    if (multiMediaData.volume > 0.0f) {
                        z = false;
                    }
                    int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (((float) multiMediaData.start) + (((float) MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) wb9.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) * multiMediaData.mSpeed)) : 0;
                    String str = multiMediaData.path;
                    int i4 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd2 == 0) {
                        multiMediaDataRealEnd2 = (int) multiMediaData.end;
                    }
                    arrayList.add(new g89(new AudioPlayData(str, i4, multiMediaDataRealEnd2, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
                }
            }
            if (z) {
                return null;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AudioPlayData> buildAudioPlayDataList(List<MultiMediaData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, list)) == null) {
            if (wb9.e(list)) {
                return null;
            }
            VideoMuxerData videoMuxerData = this.mMuxerData;
            if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                videoMuxerData.setCachePath(u79.c().a() + "/tempaudio");
                rb9.e("VideoMuxer", "have not set audioCachePath");
            }
            File file = new File(videoMuxerData.getCachePath());
            if (!file.exists()) {
                file.mkdirs();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                MultiMediaData multiMediaData = list.get(i);
                int i2 = multiMediaData.type;
                if (i2 == 0) {
                    int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) wb9.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                    int i3 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd == 0) {
                        multiMediaDataRealEnd = (int) multiMediaData.end;
                    }
                    arrayList.add(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume));
                } else if (i2 == 1) {
                    File file2 = new File(videoMuxerData.getCachePath(), ac9.b(multiMediaData.path));
                    if (!file2.exists()) {
                        mc9.c(multiMediaData.path, file2.getPath());
                    }
                    int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) wb9.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                    String path = file2.getPath();
                    int i4 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd2 == 0) {
                        multiMediaDataRealEnd2 = (int) multiMediaData.end;
                    }
                    arrayList.add(new AudioPlayData(path, i4, multiMediaDataRealEnd2, multiMediaData.volume));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private List<MultiMediaDataTrack> buildTracks(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, videoMuxerData)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            MultiDataSourceUtil.buildMultiMediaDataSource(this.mMuxerData.getPhotoDataList(), videoMuxerData.getCurrThemeEffect(), arrayList, arrayList2, hashMap, null, null);
            if (videoMuxerData.getCurrThemeEffect() != null) {
                videoMuxerData.getCurrThemeEffect().shaderConfigMapDebug = hashMap;
                videoMuxerData.getCurrThemeEffect().mediaTracks = arrayList2;
            } else {
                MediaTrackConfig mediaTrackConfig = new MediaTrackConfig();
                mediaTrackConfig.shaderConfigMapDebug = hashMap;
                mediaTrackConfig.mediaTracks = arrayList2;
                videoMuxerData.setCurrThemeEffect(mediaTrackConfig);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private boolean checkMuxerData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? (this.mMuxerData == null || TextUtils.isEmpty(this.mMuxerData.getVideoPath())) ? false : true : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineAudio(List<MultiMediaData> list, List<AudioPlayData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, list, list2) == null) {
            oa9.b("combineAudio", "音频拼接混合处理");
            this.mIsAudioCombineDone = false;
            new Thread(new Runnable(this, list, list2) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoMuxer this$0;
                public final /* synthetic */ List val$audioList;
                public final /* synthetic */ List val$videoList;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list, list2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$videoList = list;
                    this.val$audioList = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    StringBuilder sb;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoMuxerData videoMuxerData = this.this$0.mMuxerData;
                        if (videoMuxerData != null && videoMuxerData.getPhotoDataList() != null && videoMuxerData.getPhotoDataList().get(0) != null) {
                            List buildAudioPlayDataList = !wb9.e(this.val$videoList) ? this.this$0.buildAudioPlayDataList(this.val$videoList) : this.val$audioList;
                            if (!wb9.e(buildAudioPlayDataList)) {
                                String str2 = videoMuxerData.getCachePath() + "/" + ac9.b(videoMuxerData.toString()) + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                                try {
                                    File file = new File(new File(str2).getParent());
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                } catch (Exception e) {
                                    rb9.g(e);
                                }
                                na9 na9Var = new na9();
                                boolean startCombineAudio = this.this$0.startCombineAudio(buildAudioPlayDataList, str2, na9Var);
                                oa9.b("combineAudio", "音频拼接混合处理-结果" + startCombineAudio);
                                if (startCombineAudio) {
                                    videoMuxerData.setFinalAudioPath(str2);
                                    sb = new StringBuilder();
                                    sb.append("audiocombineresult:");
                                    sb.append(startCombineAudio);
                                    sb.append("audiopath:");
                                    sb.append(str2);
                                    sb.append(",isVideoDone:");
                                    sb.append(this.this$0.misVideoCombineDone);
                                } else {
                                    t79.a("v_log_audio_mixer_error", na9Var.e, null);
                                    sb = new StringBuilder();
                                    sb.append("mixtureAACFileList fail");
                                    sb.append(na9Var.e);
                                }
                                str = sb.toString();
                            }
                            this.this$0.combineAudioFinish();
                        }
                        str = "origin data fomat error";
                        rb9.e("VideoMuxer", str);
                        this.this$0.combineAudioFinish();
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineAudioFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || this.mNeedAbort) {
            return;
        }
        if (!this.mIsUseNewAudioMixture || this.mRetryCount != 1) {
            jc9.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoMuxer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mIsAudioCombineDone = true;
                        if (this.this$0.misVideoCombineDone) {
                            this.this$0.onProgress(1, 100);
                            VideoMuxer videoMuxer = this.this$0;
                            videoMuxer.combineVA(videoMuxer.mMuxerData.getVideoPath());
                        }
                    }
                }
            });
            return;
        }
        oa9.b("onGenFilterVideoFail", "视频处理-失败重试-combineAudioFinish：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        this.mIsAudioCombineDone = true;
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineVA(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            oa9.b("combineVA", "音视频混合");
            if (this.mNeedAbort) {
                onGenFilterVideoAbort();
                str2 = "muxerMusic:abort";
            } else if (this.mMuxerData != null) {
                rb9.e("VideoMuxer", "combineVA:" + str);
                if (this.mMuxerData != null && !FileUtils.checkFile(this.mMuxerData.getFinalAudioPath()) && this.mMuxerData.getMuteAudioData() != null) {
                    this.mMuxerData.setFinalAudioPath(this.mMuxerData.getMuteAudioData().audioPath);
                }
                if (!FileUtils.checkFile(this.mMuxerData.getFinalAudioPath())) {
                    rb9.e("VideoMuxer", "combineVADone");
                    notifyMuxerEnd(str);
                    return;
                }
                if (this.mAuidoVideoMuxer == null) {
                    a aVar = new a();
                    this.mAuidoVideoMuxer = aVar;
                    aVar.a(this);
                }
                rb9.e("VideoMuxer", "muxmusic:vp:" + this.mMuxerData.getVideoPath() + ",ap:" + this.mMuxerData.getFinalAudioPath());
                this.mAuidoVideoMuxer.a(this.mMuxerData);
                return;
            } else {
                str2 = "muxerMusic:mMuxerData == null";
            }
            rb9.e("VideoMuxer", str2);
        }
    }

    private void doChangeAuidoSpeed(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, this, list) == null) || wb9.e(list)) {
            return;
        }
        new Thread(new Runnable(this, list) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoMuxer this$0;
            public final /* synthetic */ List val$videoList;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$videoList = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < this.val$videoList.size(); i++) {
                        MultiMediaData multiMediaData = (MultiMediaData) this.val$videoList.get(i);
                        int i2 = multiMediaData.type;
                        if (i2 == 0) {
                            int multiMediaDataRealEnd = this.this$0.mMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) wb9.c(this.this$0.mMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                            if (multiMediaDataRealEnd == 0) {
                                multiMediaDataRealEnd = (int) multiMediaData.end;
                            }
                            arrayList.add(new AudioPlayData("", (int) multiMediaData.start, multiMediaDataRealEnd, multiMediaData.volume));
                        } else if (i2 == 1) {
                            File file = new File(FileUtils.removeExtention(multiMediaData.path) + "_audio.aac");
                            if (!file.exists()) {
                                mc9.c(multiMediaData.path, file.getPath());
                            }
                            arrayList.add(new AudioPlayData(file.getPath(), (int) multiMediaData.start, (int) multiMediaData.end, multiMediaData.volume, multiMediaData.getCurrentSpeed()));
                        }
                    }
                    p89 p89Var = new p89();
                    p89Var.h(arrayList);
                    p89Var.g(new p89.b(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                        }

                        public void onCancel() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.this$1.this$0.onGenFilterVideoAbort();
                            }
                        }

                        @Override // com.repackage.p89.b
                        public void onFailed(String str) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                na9 na9Var = new na9();
                                na9Var.e = "audioeditorerror:" + str;
                                this.this$1.this$0.notifyMuxerFail(na9Var);
                            }
                        }

                        public void onProgress(int i3) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                            }
                        }

                        @Override // com.repackage.p89.b
                        public void onSuccess(List<AudioPlayData> list2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048579, this, list2) == null) {
                                if (q89.o(this.this$1.this$0.mMuxerData.getFakeVoiceTypes())) {
                                    this.this$1.this$0.processFakeVoice(null, list2);
                                } else {
                                    this.this$1.this$0.combineAudio(null, list2);
                                }
                            }
                        }
                    });
                    p89Var.i();
                }
            }
        }).start();
    }

    private void filterVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (!checkMuxerData()) {
                notifyMuxerEnd(this.mMuxerData.getVideoPath());
            } else if (!CheckUtils.checkEffect(this.mMuxerData)) {
                onGenFilterVideoSuccess(this.mMuxerData.getVideoPath());
            } else if (TextUtils.isEmpty(this.mMuxerData.getVideoPath()) || !new File(this.mMuxerData.getVideoPath()).exists()) {
                onGenFilterVideoFail(-1, "inputPath invalid or no file");
            } else {
                ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(u79.c().getContext(), this.mMuxerData.getVideoPath(), new File(this.mMuxerData.getVideoPath()).getParent() + File.separator + FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                this.mComposeThemeVideoModel = composeThemeVideoModel;
                composeThemeVideoModel.setOnGenerateListener(this);
                FilterValue filterValue = this.mMuxerData.getFilterValue();
                if (filterValue != null) {
                    this.mComposeThemeVideoModel.setFilterValue(filterValue);
                }
                if (this.mMuxerData.getVideoEffectData() != null) {
                    this.mComposeThemeVideoModel.setVideoEffectData((VideoEffectData) this.mMuxerData.getVideoEffectData().clone());
                }
                this.mComposeThemeVideoModel.startMuxVideoAsync();
            }
        }
    }

    private i89 getAudioMixDataFormMuxerData(VideoMuxerData videoMuxerData, List<MultiMediaDataTrack> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, videoMuxerData, list)) == null) {
            if (videoMuxerData == null || wb9.e(list)) {
                return null;
            }
            CheckUtils.syncMusicData(videoMuxerData);
            List<g89> buildAudioDataList = buildAudioDataList(list.get(0).multiMediaDataList);
            ArrayList arrayList = new ArrayList();
            if (!wb9.e(buildAudioDataList)) {
                k89 k89Var = new k89(buildAudioDataList);
                k89Var.c(videoMuxerData.getFakeVoiceTypes());
                arrayList.add(k89Var);
            }
            if (!wb9.e(videoMuxerData.getAudioPlayDataList())) {
                ArrayList arrayList2 = new ArrayList();
                for (AudioPlayData audioPlayData : videoMuxerData.getAudioPlayDataList()) {
                    arrayList2.add(new g89(audioPlayData));
                }
                arrayList.add(new k89(arrayList2));
            }
            if (!wb9.e(videoMuxerData.getAudioPlayTrackDataList())) {
                CheckUtils.checkAudioPlayTrackDataList(videoMuxerData.getAudioPlayTrackDataList(), videoMuxerData);
                for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
                    if (audioPlayTrackData != null && !wb9.e(audioPlayTrackData.mAudioPlayDataList)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (AudioPlayData audioPlayData2 : audioPlayTrackData.mAudioPlayDataList) {
                            arrayList3.add(new g89(audioPlayData2));
                        }
                        arrayList.add(new k89(arrayList3));
                    }
                }
            }
            i89 i89Var = new i89(arrayList);
            if (!TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                i89Var.d(videoMuxerData.getCachePath() + "/");
            }
            i89Var.e(new g89(videoMuxerData.getMuteAudioData()));
            return i89Var;
        }
        return (i89) invokeLL.objValue;
    }

    private boolean isMute(List<MultiMediaData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, list)) == null) {
            if (wb9.e(list)) {
                return false;
            }
            for (MultiMediaData multiMediaData : list) {
                if (multiMediaData != null && multiMediaData.volume != 0.0f) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00a8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00bd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00c0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x003c */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bd, code lost:
        if (r5 == null) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void notifyMuxerEnd(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, str) == null) {
            oa9.b("notifyMuxerEnd", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime));
            if (this.mNeedAbort) {
                onGenFilterVideoAbort();
                return;
            }
            if (this.mListener != null) {
                File file = new File(str);
                int i = -1;
                String str2 = "no exception";
                if (file.exists()) {
                    FileInputStream fileInputStream2 = 0;
                    try {
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                fileInputStream = new FileInputStream(file);
                            } catch (Exception e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            mediaMetadataRetriever.setDataSource(fileInputStream.getFD());
                            i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                            fileInputStream2 = "muxer_publish_log";
                            oa9.a("muxer_publish_log", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime) + ", duration : " + i + ", bitrate : " + mediaMetadataRetriever.extractMetadata(20) + ", hevc : " + this.mMuxerData.isCurrentEncodeHevcVideo());
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream2 = fileInputStream;
                            str2 = e.toString();
                            if (fileInputStream2 != 0) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
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
                    mediaMetadataRetriever.release();
                }
                if (!FileUtils.checkFile(str) || i <= 0) {
                    na9 na9Var = new na9();
                    na9Var.b = true;
                    na9Var.a = 24;
                    na9Var.c = "error_mixtrue";
                    StringBuilder sb = new StringBuilder();
                    sb.append("视频预处理合成失败,视频文件丢失 FinalVideoPath=");
                    sb.append(str);
                    sb.append(" , 时长=");
                    sb.append(i);
                    sb.append(" , size=");
                    sb.append(FileUtils.getFileSize(str));
                    sb.append(" , eMsg=");
                    sb.append(str2);
                    if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getVideoPath())) {
                        sb.append(" , video path=");
                        sb.append(this.mMuxerData.getVideoPath());
                        sb.append(" , video 时长=");
                        sb.append(cc9.f(this.mMuxerData.getVideoPath()));
                        sb.append(" , video size=");
                        sb.append(FileUtils.getFileSize(this.mMuxerData.getVideoPath()));
                    }
                    if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getFinalAudioPath())) {
                        sb.append(" , audio path=");
                        sb.append(this.mMuxerData.getFinalAudioPath());
                        sb.append(" , audio 时长=");
                        sb.append(cc9.f(this.mMuxerData.getFinalAudioPath()));
                        sb.append(" , audio size=");
                        sb.append(FileUtils.getFileSize(this.mMuxerData.getFinalAudioPath()));
                    }
                    sb.append(" , needAbort=");
                    sb.append(this.mNeedAbort);
                    sb.append(" , trace=");
                    sb.append(bc9.g(new RuntimeException()));
                    na9Var.e = sb.toString();
                    this.mListener.e(na9Var.a().toString());
                } else {
                    onProgress(2, 100);
                    this.mListener.d(str);
                }
            }
            resetProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMuxerFail(na9 na9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, na9Var) == null) {
            resetProgress();
            if (this.mListener != null) {
                String str = null;
                if (na9Var != null) {
                    if (this.mMuxerData != null && this.mMuxerData.getCurrThemeEffect() != null && !TextUtils.isEmpty(na9Var.e)) {
                        na9Var.e += ",themeName : " + this.mMuxerData.getCurrThemeEffect().name;
                    }
                    na9Var.e += ",checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData);
                    na9Var.e += ",checkVideoDirectNext : " + CheckUtils.checkVideoDirectNext(this.mMuxerData);
                    na9Var.e += ",needAbort : " + this.mNeedAbort;
                    str = na9Var.a().toString();
                }
                this.mListener.e(str);
            }
        }
    }

    private void notifyMuxerMusicEnd() {
        y79 y79Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || (y79Var = this.mListener) == null) {
            return;
        }
        y79Var.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65569, this, i, i2) == null) || this.mListener == null) {
            return;
        }
        if (i == 0) {
            int i3 = (int) (i2 * 0.45f);
            if (this.mLastVideoPercent == i3) {
                return;
            }
            this.mLastVideoPercent = i3;
        } else if (i == 1) {
            int i4 = (int) (i2 * 0.45f);
            if (this.mLastAudioPercent == i4) {
                return;
            }
            this.mLastAudioPercent = i4;
        } else if (i == 2) {
            int i5 = (int) (i2 * 0.1f);
            if (this.mLastAudioVideoPercent == i5) {
                return;
            }
            this.mLastAudioVideoPercent = i5;
        }
        int i6 = this.mLastVideoPercent + this.mLastAudioPercent + this.mLastAudioVideoPercent;
        this.mListener.b(i6);
        StringBuilder sb = new StringBuilder();
        sb.append("progressType : ");
        sb.append(i == 0 ? "video" : "audio");
        sb.append(" percent : ");
        sb.append(i2);
        sb.append(" progress : ");
        sb.append(i6);
        oa9.b("onProgress", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAuidoMuxProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i) == null) {
            jc9.a().post(new Runnable(this, i) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoMuxer this$0;
                public final /* synthetic */ int val$audioProgress;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
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
                    this.val$audioProgress = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mListener == null) {
                        return;
                    }
                    rb9.j("VideoMuxer", "audioProgress:" + this.val$audioProgress);
                    int i2 = this.val$audioProgress;
                    if (i2 <= 100) {
                        this.this$0.onProgress(1, i2);
                    }
                }
            });
        }
    }

    private void preMuxKSongRepair(String str) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65571, this, str) == null) && (multiMediaData = (MultiMediaData) wb9.c(this.mMuxerData.getPhotoDataList(), 0)) != null && FileUtils.isExists(multiMediaData.path)) {
            if (!this.mMuxerData.isKSongHuaTongMode()) {
                new Thread(new Runnable(this, multiMediaData, str) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoMuxer this$0;
                    public final /* synthetic */ MultiMediaData val$multiMediaData;
                    public final /* synthetic */ String val$repairAudioPath;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, multiMediaData, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$multiMediaData = multiMediaData;
                        this.val$repairAudioPath = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String str2 = new File(this.val$multiMediaData.path).getParentFile().getAbsoluteFile() + File.separator + System.currentTimeMillis() + "_audio_repair.mp4";
                            rb9.e("VideoMuxer: ", "K歌修音处理， out_put_path = " + str2);
                            boolean j = mc9.j(sb, this.val$repairAudioPath, this.val$multiMediaData.path, str2, 0L, -1L);
                            if (j) {
                                this.val$multiMediaData.path = str2;
                            }
                            rb9.e("VideoMuxer: ", "K歌修音处理合成结果：" + j);
                            if (!this.this$0.mNeedAbort || this.this$0.mListener == null) {
                                jc9.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2.1
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
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            VideoMuxer videoMuxer = this.this$1.this$0;
                                            videoMuxer.realStartMux(videoMuxer.mMuxerData);
                                        }
                                    }
                                });
                            } else {
                                this.this$0.mListener.c();
                            }
                        }
                    }
                }).start();
                return;
            }
            multiMediaData.path = str;
            realStartMux(this.mMuxerData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processFakeVoice(List<MultiMediaData> list, List<AudioPlayData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, this, list, list2) == null) {
            oa9.b("processFakeVoice", "变声处理");
            this.mIsAudioCombineDone = false;
            new Thread(new Runnable(this, list, list2) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoMuxer this$0;
                public final /* synthetic */ List val$audioList;
                public final /* synthetic */ List val$videoList;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list, list2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$videoList = list;
                    this.val$audioList = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoMuxerData videoMuxerData = this.this$0.mMuxerData;
                        if (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || videoMuxerData.getPhotoDataList().get(0) == null) {
                            str = "origin data fomat error";
                        } else {
                            List buildAudioPlayDataList = !wb9.e(this.val$videoList) ? this.this$0.buildAudioPlayDataList(this.val$videoList) : this.val$audioList;
                            if (wb9.e(buildAudioPlayDataList)) {
                                this.this$0.combineAudioFinish();
                                return;
                            }
                            if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                                videoMuxerData.setCachePath(u79.c().a() + "/tempaudio");
                                rb9.e("VideoMuxer", "have not set audioCachePath");
                            }
                            File file = new File(videoMuxerData.getCachePath());
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            String str2 = videoMuxerData.getCachePath() + "/" + ac9.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_for_fake_voice.aac";
                            na9 na9Var = new na9();
                            if (videoMuxerData.isKSongHuaTongMode()) {
                                if (buildAudioPlayDataList == null) {
                                    buildAudioPlayDataList = new ArrayList();
                                }
                                buildAudioPlayDataList.clear();
                                buildAudioPlayDataList.add(new AudioPlayData(this.this$0.mMuxerData.getKSongHuaTongRecordPath(), 0, cc9.f(this.this$0.mMuxerData.getKSongHuaTongRecordPath()), 1.0f));
                            }
                            if (VLogMultiAudioMixer.mixtureAACFileList(buildAudioPlayDataList, str2, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass5 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                                public void mixerProgress(int i) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeI(1048576, this, i) == null) {
                                    }
                                }
                            }, na9Var)) {
                                String str3 = videoMuxerData.getCachePath() + "/" + ac9.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_fake_voice.aac";
                                try {
                                    this.this$0.mSoundStreamFileWriter = new x89(str2, str3, videoMuxerData.getFakeVoiceTypes());
                                    this.this$0.mSoundStreamFileWriter.S(new ma9(this, videoMuxerData, str3) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass5 this$1;
                                        public final /* synthetic */ String val$fakeVoiceOutputPath;
                                        public final /* synthetic */ VideoMuxerData val$videoMuxerData;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, videoMuxerData, str3};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$videoMuxerData = videoMuxerData;
                                            this.val$fakeVoiceOutputPath = str3;
                                        }

                                        @Override // com.repackage.ma9, com.repackage.la9
                                        public void onExceptionThrown(String str4) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, str4) == null) {
                                                rb9.e("VideoMuxer: ", "onExceptionThrown: " + str4);
                                                if (this.this$1.this$0.mNeedAbort) {
                                                    return;
                                                }
                                                this.this$1.this$0.combineAudioFinish();
                                            }
                                        }

                                        @Override // com.repackage.ma9
                                        public void onFinishedWriting(boolean z) {
                                            String str4;
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.this$1.this$0.mNeedAbort) {
                                                return;
                                            }
                                            rb9.e("VideoMuxer: ", "变声处理：end_time" + System.currentTimeMillis());
                                            String str5 = this.val$videoMuxerData.getCachePath() + "/" + ac9.b(this.val$videoMuxerData.toString()) + System.currentTimeMillis() + "_mix_fake_voice.aac";
                                            try {
                                                File file2 = new File(new File(str5).getParent());
                                                if (!file2.exists()) {
                                                    file2.mkdirs();
                                                }
                                            } catch (Exception e) {
                                                rb9.g(e);
                                            }
                                            na9 na9Var2 = new na9();
                                            int b = (int) mc9.b(this.val$fakeVoiceOutputPath);
                                            ArrayList arrayList = new ArrayList();
                                            if (b > 0) {
                                                arrayList.add(new AudioPlayData(this.val$fakeVoiceOutputPath, 0, b, 1.0f));
                                            }
                                            boolean startCombineAudio = this.this$1.this$0.startCombineAudio(arrayList, str5, na9Var2);
                                            if (startCombineAudio) {
                                                this.val$videoMuxerData.setFinalAudioPath(str5);
                                                str4 = "audiocombineresult:" + startCombineAudio + "audiopath:" + str5 + ",isVideoDone:" + this.this$1.this$0.misVideoCombineDone;
                                            } else {
                                                t79.a("v_log_audio_mixer_error", na9Var2.e, null);
                                                str4 = "mixtureAACFileList fail" + na9Var2.e;
                                            }
                                            rb9.e("VideoMuxer", str4);
                                            this.this$1.this$0.combineAudioFinish();
                                        }

                                        @Override // com.repackage.ma9, com.repackage.la9
                                        public void onProgressChanged(int i, double d, long j) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                                            }
                                        }

                                        @Override // com.repackage.ma9, com.repackage.la9
                                        public void onTrackEnd(int i) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeI(1048579, this, i) == null) {
                                            }
                                        }
                                    });
                                    if (this.this$0.mNeedAbort) {
                                        return;
                                    }
                                    this.this$0.mSoundStreamFileWriter.D(videoMuxerData.getFakeVoiceTypes());
                                    this.this$0.mSoundStreamFileWriter.I();
                                    rb9.e("VideoMuxer: ", "变声处理：start_time" + System.currentTimeMillis());
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    rb9.e("VideoMuxer: ", "onExceptionThrown: " + bc9.g(e));
                                }
                            } else {
                                t79.a("v_log_audio_mixer_error", na9Var.e, null);
                                str = "mixtureAACFileList fail" + na9Var.e;
                            }
                        }
                        rb9.e("VideoMuxer", str);
                        this.this$0.combineAudioFinish();
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStartMux(VideoMuxerData videoMuxerData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, videoMuxerData) == null) {
            if (CheckUtils.checkDirectNext(videoMuxerData)) {
                if (wb9.b(videoMuxerData.getPhotoDataList()) == 1) {
                    MultiMediaData multiMediaData = (MultiMediaData) wb9.c(videoMuxerData.getPhotoDataList(), 0);
                    videoMuxerData.setVideoPath(multiMediaData.path);
                    videoMuxerData.setFinalAudioPath(multiMediaData.path);
                    onProgress(1, 100);
                    onProgress(0, 100);
                    notifyMuxerEnd(multiMediaData.path);
                    return;
                }
                return;
            }
            this.misVideoCombineDone = false;
            List<MultiMediaDataTrack> buildTracks = buildTracks(videoMuxerData);
            if (CheckUtils.checkVideoDirectNext(videoMuxerData)) {
                oa9.b("startMuxer", "checkVideoDirectNext");
                if (wb9.b(videoMuxerData.getPhotoDataList()) == 1) {
                    onProgress(0, 100);
                    onGenFilterVideoSuccess(((MultiMediaData) wb9.c(videoMuxerData.getPhotoDataList(), 0)).path);
                }
            } else {
                themeVideo(buildTracks);
            }
            if (!CheckUtils.checkAudioDirectNext(videoMuxerData)) {
                this.mAudioStartTime = System.currentTimeMillis();
                if (!this.mIsUseNewAudioMixture) {
                    if (CheckUtils.checkOriginVideoChangeSpeed(this.mMuxerData) && !isMute(buildTracks.get(0).multiMediaDataList)) {
                        doChangeAuidoSpeed(buildTracks.get(0).multiMediaDataList);
                        return;
                    } else if (!q89.o(this.mMuxerData.getFakeVoiceTypes()) || isMute(buildTracks.get(0).multiMediaDataList)) {
                        combineAudio(buildTracks.get(0).multiMediaDataList, null);
                        return;
                    } else {
                        processFakeVoice(buildTracks.get(0).multiMediaDataList, null);
                        return;
                    }
                }
                i89 audioMixDataFormMuxerData = getAudioMixDataFormMuxerData(this.mMuxerData, buildTracks);
                if (audioMixDataFormMuxerData != null && !wb9.e(audioMixDataFormMuxerData.c())) {
                    j89 j89Var = new j89(audioMixDataFormMuxerData);
                    this.mAudioMixtureManager = j89Var;
                    j89Var.q(this);
                    this.mAudioMixtureManager.r();
                    return;
                }
            } else if (wb9.b(videoMuxerData.getPhotoDataList()) != 1) {
                return;
            } else {
                videoMuxerData.setFinalAudioPath(((MultiMediaData) wb9.c(videoMuxerData.getPhotoDataList(), 0)).path);
                onProgress(1, 100);
            }
            combineAudioFinish();
        }
    }

    private void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.mLastVideoPercent = 0;
            this.mLastAudioPercent = 0;
            this.mLastAudioVideoPercent = 0;
            this.mRetryCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startCombineAudio(List<AudioPlayData> list, String str, na9 na9Var) {
        InterceptResult invokeLLL;
        boolean z;
        boolean z2;
        List<AudioPlayData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65575, this, list, str, na9Var)) == null) {
            oa9.b("startCombineAudio", "拼接混合音频");
            VideoMuxerData videoMuxerData = this.mMuxerData;
            if (videoMuxerData == null) {
                return false;
            }
            boolean z3 = true;
            if (!wb9.e(list)) {
                for (AudioPlayData audioPlayData : list) {
                    if (FileUtils.isExists(audioPlayData.audioPath)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            CheckUtils.syncMusicData(videoMuxerData);
            if (videoMuxerData != null && !wb9.e(videoMuxerData.getAudioPlayDataList())) {
                for (AudioPlayData audioPlayData2 : videoMuxerData.getAudioPlayDataList()) {
                    if (FileUtils.isExists(audioPlayData2.audioPath) && audioPlayData2.volume > 0.0f) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (z || z2 || videoMuxerData == null || videoMuxerData.getMuteAudioData() == null || !FileUtils.isExists(videoMuxerData.getMuteAudioData().audioPath)) {
                list2 = list;
                z3 = z;
            } else {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.clear();
                if (videoMuxerData.getMuteAudioData().end - videoMuxerData.getMuteAudioData().start < 1000) {
                    long f = cc9.f(videoMuxerData.getMuteAudioData().audioPath);
                    videoMuxerData.getMuteAudioData().start = 0;
                    videoMuxerData.getMuteAudioData().end = (int) f;
                }
                list.add(videoMuxerData.getMuteAudioData());
                list2 = list;
            }
            if (z3) {
                return z2 ? VLogMultiAudioMixer.mixtureAACFileList(list2, videoMuxerData.getAudioPlayDataList(), str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoMuxer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                    public void mixerProgress(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            this.this$0.postAuidoMuxProgress(i);
                        }
                    }
                }, na9Var) : VLogMultiAudioMixer.mixtureAACFileList(list2, str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoMuxer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                    public void mixerProgress(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            this.this$0.postAuidoMuxProgress(i);
                        }
                    }
                }, na9Var);
            } else if (z2) {
                return VLogMultiAudioMixer.mixtureAACFileList(videoMuxerData.getAudioPlayDataList(), str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoMuxer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                    public void mixerProgress(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            this.this$0.postAuidoMuxProgress(i);
                        }
                    }
                }, na9Var);
            } else {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0169, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0172, code lost:
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0174, code lost:
        r1.release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void themeVideo(List<MultiMediaDataTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, list) == null) {
            oa9.b("themeVideo", "视频处理开始");
            MediaExtractor mediaExtractor = null;
            if (wb9.e(this.mMuxerData.getPhotoDataList()) || this.mMuxerData.getCurrThemeEffect() == null) {
                notifyMuxerEnd(null);
                return;
            }
            ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(u79.c().getContext(), list, null, u79.c().f() + "/video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
            this.mComposeThemeVideoModel = composeThemeVideoModel;
            composeThemeVideoModel.setOnGenerateListener(this);
            this.mComposeThemeVideoModel.setMediaTrackConfig(this.mMuxerData.getCurrThemeEffect());
            this.mComposeThemeVideoModel.setSubTitleConfig(this.mMuxerData.getSubTitleConfig());
            this.mComposeThemeVideoModel.setSubTitleUnits(this.mMuxerData.getSubTitleUnits());
            this.mComposeThemeVideoModel.setStickerList(this.mMuxerData.getStickerDataList());
            this.mComposeThemeVideoModel.setOutputVideoSize(this.mMuxerData.getOutWidth(), this.mMuxerData.getOutHeight());
            this.mComposeThemeVideoModel.setOutputVideoBitRate(this.mMuxerData.getOutBitRate());
            this.mComposeThemeVideoModel.setPreviewVideoSize(this.mMuxerData.getPreviewWidth(), this.mMuxerData.getPreviewHeight());
            this.mComposeThemeVideoModel.setCompat(this.mMuxerData.isCompat());
            this.mComposeThemeVideoModel.setRecordConfigEncodeHevcVideo(this.mMuxerData.isRecordConfigEncodeHevcVideo());
            this.mComposeThemeVideoModel.setAREditSticker(this.mMuxerData.getAREditSticker());
            this.mComposeThemeVideoModel.setImageQualityData(this.mMuxerData.getImageQualityData());
            this.mComposeThemeVideoModel.setAREditBeautyMap(this.mMuxerData.getAREditBeautyMap());
            if (this.mMuxerData.isDefaultBeauty()) {
                this.mComposeThemeVideoModel.setAREditBeautyMapForMale(this.mMuxerData.getAREditBeautyMapForMale());
                this.mComposeThemeVideoModel.setDefaultMale(this.mMuxerData.isDefaultMale());
            }
            if (wb9.b(this.mMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) wb9.c(this.mMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1) {
                    int frameRate = this.mMuxerData.getFrameRate();
                    if (frameRate == 0) {
                        frameRate = 30;
                    }
                    try {
                        try {
                            mediaExtractor = bc9.b(multiMediaData.path);
                            int integer = mediaExtractor.getTrackFormat(bc9.f(mediaExtractor)).getInteger("frame-rate");
                            if (integer < frameRate) {
                                frameRate = integer;
                            }
                            this.mComposeThemeVideoModel.setFrameRate(frameRate);
                            rb9.j("startMuxer", "videoFrameRate : " + integer + " frameRate : " + frameRate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        throw th;
                    }
                }
            }
            if (this.mMuxerData.getVideoEffectData() != null) {
                this.mComposeThemeVideoModel.setVideoEffectData((VideoEffectData) this.mMuxerData.getVideoEffectData().clone());
            }
            this.mComposeThemeVideoModel.startMuxVideoAsync();
        }
    }

    public void interruptProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mNeedAbort = true;
            resetProgress();
            ComposeThemeVideoModel composeThemeVideoModel = this.mComposeThemeVideoModel;
            if (composeThemeVideoModel != null) {
                composeThemeVideoModel.interruptGenVideo();
            }
            j89 j89Var = this.mAudioMixtureManager;
            if (j89Var != null) {
                j89Var.i();
                this.mAudioMixtureManager.p();
            }
            a aVar = this.mAuidoVideoMuxer;
            if (aVar != null) {
                aVar.a();
            }
            x89 x89Var = this.mSoundStreamFileWriter;
            if (x89Var != null) {
                x89Var.J();
            }
        }
    }

    @Override // com.repackage.j89.b
    public void onAudioMixtureCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            rb9.j("VideoMuxer", "onAudioMixtureCancel");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    @Override // com.repackage.j89.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAudioMixtureFail(String str) {
        String json;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.mNeedAbort) {
            return;
        }
        rb9.j("VideoMuxer", "onAudioMixtureFail:" + str);
        StringBuilder sb = new StringBuilder();
        if (this.mMuxerData != null) {
            if (wb9.e(this.mMuxerData.getAudioPlayDataList())) {
                json = "no music info";
            } else {
                sb.append("musicinfo:");
                for (AudioPlayData audioPlayData : this.mMuxerData.getAudioPlayDataList()) {
                    sb.append(audioPlayData.audioPath);
                }
                if (this.mMuxerData.getMusicData() != null) {
                    sb.append("musidata:");
                    json = MusicData.toJSON(this.mMuxerData.getMusicData());
                }
                if (wb9.e(this.mMuxerData.getPhotoDataList())) {
                    sb.append("videopaths:");
                    for (MultiMediaData multiMediaData : this.mMuxerData.getPhotoDataList()) {
                        sb.append(multiMediaData.path);
                    }
                } else {
                    sb.append("no video info");
                }
            }
            sb.append(json);
            if (wb9.e(this.mMuxerData.getPhotoDataList())) {
            }
        }
        t79.a("v_log_audio_mixer_error", "onAudioMixtureFail:" + str + ",inputinfo:" + sb.toString(), null);
        combineAudioFinish();
    }

    @Override // com.repackage.j89.b
    public void onAudioMixtureProgress(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.mNeedAbort) {
            return;
        }
        postAuidoMuxProgress(i);
    }

    @Override // com.repackage.j89.b
    public void onAudioMixtureSuccess(h89 h89Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, h89Var) == null) || this.mNeedAbort) {
            return;
        }
        if (h89Var == null || !FileUtils.checkFile(h89Var.h())) {
            rb9.j("VideoMuxer", "onAudioMixtureSuccess file not exit");
            t79.a("v_log_audio_mixer_error", "onAudioMixtureSuccess file not exit", null);
        } else {
            rb9.j("VideoMuxer", "onAudioMixtureSuccess path:" + h89Var.h() + "audioduration:" + cc9.c(h89Var.h(), 0));
            this.mMuxerData.setFinalAudioPath(h89Var.h());
        }
        combineAudioFinish();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0272a
    public void onAudioVideoMuxerCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            onGenFilterVideoAbort();
            rb9.e("VideoMuxer", "onMuxerCancel");
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0272a
    public void onAudioVideoMuxerFail(na9 na9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, na9Var) == null) {
            notifyMuxerFail(na9Var);
            if (na9Var != null) {
                rb9.e("VideoMuxer", "onMuxerMusicFail:" + na9Var.e);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0272a
    public void onAudioVideoMuxerFinish(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            rb9.e("VideoMuxer", "onMuxerMusicFinish:" + str);
            if (FileUtils.checkFile(str)) {
                rb9.e("VideoMuxer", "notifyMuxerMusicEnd+notifyMuxerEnd:" + str);
                notifyMuxerMusicEnd();
            } else {
                str = this.mMuxerData.getVideoPath();
            }
            notifyMuxerEnd(str);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoAbort() {
        y79 y79Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (y79Var = this.mListener) == null) {
            return;
        }
        y79Var.c();
        resetProgress();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoFail(int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) || this.mNeedAbort) {
            return;
        }
        if (i != -100 || (i2 = this.mRetryCount) >= MAX_RETRY_COUNT) {
            oa9.b("onGenFilterVideoFail", "视频处理-失败");
            na9 na9Var = new na9();
            na9Var.a = 24;
            na9Var.c = "error_mixtrue";
            na9Var.b = true;
            na9Var.e = "视频预处理合成处理视频特效合成失败 checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData) + " --- " + str;
            j89 j89Var = this.mAudioMixtureManager;
            if (j89Var != null) {
                j89Var.i();
            }
            notifyMuxerFail(na9Var);
            return;
        }
        this.mRetryCount = i2 + 1;
        oa9.b("onGenFilterVideoFail", "视频处理-失败重试 ：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        if (this.mRetryCount == 1 && !this.mIsAudioCombineDone && this.mIsUseNewAudioMixture) {
            return;
        }
        if (this.mRetryCount == MAX_RETRY_COUNT) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.mNeedAbort) {
                return;
            }
        }
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        this.mMuxerData.setCurrentEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
        try {
            t79.a("v_log_retry_inner_multimedia_processor", str + ",视频处理-失败重试 ：" + this.mRetryCount, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            onProgress(0, i);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoRecordError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            notifyMuxerEnd(null);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            oa9.b("onGenFilterVideoSuccess", "视频处理-成功");
            this.misVideoCombineDone = true;
            if (this.mNeedAbort) {
                onGenFilterVideoAbort();
                return;
            }
            this.mMuxerData.setVideoPath(str);
            rb9.j("VideoMuxer", "videocombinedone" + this.mIsAudioCombineDone + ",videopath:" + str + "videoduration:" + cc9.c(str, 1) + "," + cc9.b(str) + "," + mc9.f(str));
            if (this.mIsAudioCombineDone) {
                combineVA(str);
            }
        }
    }

    public void setListener(y79 y79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, y79Var) == null) {
            this.mListener = y79Var;
        }
    }

    public void startMuxer(VideoMuxerData videoMuxerData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoMuxerData) == null) {
            StringBuilder sb = new StringBuilder();
            if (videoMuxerData != null && (FileUtils.isExists(videoMuxerData.getVideoPath()) || CheckUtils.checkAllFileExist(videoMuxerData, sb))) {
                this.mStartTime = System.currentTimeMillis();
                y79 y79Var = this.mListener;
                if (y79Var != null) {
                    y79Var.f();
                }
                this.mMuxerData = videoMuxerData;
                this.mIsUseNewAudioMixture = this.mMuxerData.isUserNewAudioMixture();
                try {
                    t79.a("v_log_codec_h265_support", bc9.m(MimeTypes.VIDEO_H265) != null ? "yes" : "no", null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!CheckUtils.checkPhotoMovie(this.mMuxerData)) {
                    notifyMuxerEnd(videoMuxerData.getVideoPath());
                    return;
                } else if (FileUtils.isExists(this.mMuxerData.getRepairAudioPath())) {
                    preMuxKSongRepair(this.mMuxerData.getRepairAudioPath());
                    return;
                } else {
                    realStartMux(videoMuxerData);
                    return;
                }
            }
            na9 na9Var = new na9();
            na9Var.a = 24;
            na9Var.c = "error_mixtrue";
            na9Var.b = true;
            StringBuilder sb2 = new StringBuilder();
            if (videoMuxerData == null) {
                str = "开始合成，合成信息丢失:muxerData为空";
            } else {
                sb2.append("开始合成，合成信息丢失,videopath:" + videoMuxerData.getVideoPath());
                sb2.append(",photoDataList size:" + wb9.b(videoMuxerData.getPhotoDataList()));
                sb2.append(",draftName:" + videoMuxerData.getDraftName());
                sb2.append(",muxerFrom:" + videoMuxerData.getMuxerFrom());
                str = ",checkerror:" + sb.toString();
            }
            sb2.append(str);
            na9Var.e = sb2.toString();
            notifyMuxerFail(na9Var);
        }
    }

    public void startMuxerForJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                startMuxer((VideoMuxerData) new Gson().fromJson(str, (Class<Object>) VideoMuxerData.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
