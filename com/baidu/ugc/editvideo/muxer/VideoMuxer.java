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
import com.google.gson.Gson;
import d.a.y0.e.b;
import d.a.y0.h.d;
import d.a.y0.h.e;
import d.a.y0.i.b;
import d.a.y0.t.c;
import d.a.y0.t.h;
import d.a.y0.t.l;
import d.a.y0.t.m;
import d.a.y0.t.n;
import d.a.y0.t.u;
import d.a.y0.t.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoMuxer implements d.b, OnGenFilterVideoListener, a.InterfaceC0251a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILTER_TEMP_DIR_PREFIX = "video_addfilter_";
    public static int MAX_RETRY_COUNT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public d mAudioMixtureManager;
    public long mAudioStartTime;
    public a mAuidoVideoMuxer;
    public ComposeThemeVideoModel mComposeThemeVideoModel;
    public volatile boolean mIsAudioCombineDone;
    public boolean mIsUseNewAudioMixture;
    public int mLastAudioPercent;
    public int mLastAudioVideoPercent;
    public int mLastVideoPercent;
    public b mListener;
    public volatile VideoMuxerData mMuxerData;
    public volatile boolean mNeedAbort;
    public int mRetryCount;
    public d.a.y0.i.g.a mSoundStreamFileWriter;
    public long mStartTime;
    public volatile boolean misVideoCombineDone;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNeedAbort = false;
    }

    private List<d.a.y0.h.a> buildAudioDataList(List<MultiMediaData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, list)) == null) {
            if (h.e(list)) {
                return null;
            }
            VideoMuxerData videoMuxerData = this.mMuxerData;
            ArrayList arrayList = new ArrayList();
            boolean z = true;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MultiMediaData multiMediaData = list.get(i2);
                int i3 = multiMediaData.type;
                if (i3 == 0) {
                    int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) h.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i2)) : 0;
                    int i4 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd == 0) {
                        multiMediaDataRealEnd = (int) multiMediaData.end;
                    }
                    arrayList.add(new d.a.y0.h.a(new AudioPlayData("", i4, multiMediaDataRealEnd, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
                } else if (i3 == 1) {
                    if (multiMediaData.volume > 0.0f) {
                        z = false;
                    }
                    int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (((float) multiMediaData.start) + (((float) MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) h.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i2)) * multiMediaData.mSpeed)) : 0;
                    String str = multiMediaData.path;
                    int i5 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd2 == 0) {
                        multiMediaDataRealEnd2 = (int) multiMediaData.end;
                    }
                    arrayList.add(new d.a.y0.h.a(new AudioPlayData(str, i5, multiMediaDataRealEnd2, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
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
            if (h.e(list)) {
                return null;
            }
            VideoMuxerData videoMuxerData = this.mMuxerData;
            if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                videoMuxerData.setCachePath(d.a.y0.b.d().a() + "/tempaudio");
                c.e("VideoMuxer", "have not set audioCachePath");
            }
            File file = new File(videoMuxerData.getCachePath());
            if (!file.exists()) {
                file.mkdirs();
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                MultiMediaData multiMediaData = list.get(i2);
                int i3 = multiMediaData.type;
                if (i3 == 0) {
                    int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) h.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i2)) : 0;
                    int i4 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd == 0) {
                        multiMediaDataRealEnd = (int) multiMediaData.end;
                    }
                    arrayList.add(new AudioPlayData("", i4, multiMediaDataRealEnd, multiMediaData.volume));
                } else if (i3 == 1) {
                    File file2 = new File(videoMuxerData.getCachePath(), l.b(multiMediaData.path));
                    if (!file2.exists()) {
                        x.c(multiMediaData.path, file2.getPath());
                    }
                    int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) h.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i2)) : 0;
                    String path = file2.getPath();
                    int i5 = (int) multiMediaData.start;
                    if (multiMediaDataRealEnd2 == 0) {
                        multiMediaDataRealEnd2 = (int) multiMediaData.end;
                    }
                    arrayList.add(new AudioPlayData(path, i5, multiMediaDataRealEnd2, multiMediaData.volume));
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
            d.a.y0.m.b.b("combineAudio", "音频拼接混合处理");
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                            List buildAudioPlayDataList = !h.e(this.val$videoList) ? this.this$0.buildAudioPlayDataList(this.val$videoList) : this.val$audioList;
                            if (!h.e(buildAudioPlayDataList)) {
                                String str2 = videoMuxerData.getCachePath() + "/" + l.b(videoMuxerData.toString()) + System.currentTimeMillis() + ".aac";
                                try {
                                    File file = new File(new File(str2).getParent());
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                } catch (Exception e2) {
                                    c.g(e2);
                                }
                                d.a.y0.m.a aVar = new d.a.y0.m.a();
                                boolean startCombineAudio = this.this$0.startCombineAudio(buildAudioPlayDataList, str2, aVar);
                                d.a.y0.m.b.b("combineAudio", "音频拼接混合处理-结果" + startCombineAudio);
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
                                    d.a.y0.a.a("v_log_audio_mixer_error", aVar.f71285e, null);
                                    sb = new StringBuilder();
                                    sb.append("mixtureAACFileList fail");
                                    sb.append(aVar.f71285e);
                                }
                                str = sb.toString();
                            }
                            this.this$0.combineAudioFinish();
                        }
                        str = "origin data fomat error";
                        c.e("VideoMuxer", str);
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
            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.4
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
        d.a.y0.m.b.b("onGenFilterVideoFail", "视频处理-失败重试-combineAudioFinish：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        this.mIsAudioCombineDone = true;
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineVA(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            d.a.y0.m.b.b("combineVA", "音视频混合");
            if (this.mNeedAbort) {
                onGenFilterVideoAbort();
                str2 = "muxerMusic:abort";
            } else if (this.mMuxerData != null) {
                c.e("VideoMuxer", "combineVA:" + str);
                if (this.mMuxerData != null && !FileUtils.checkFile(this.mMuxerData.getFinalAudioPath()) && this.mMuxerData.getMuteAudioData() != null) {
                    this.mMuxerData.setFinalAudioPath(this.mMuxerData.getMuteAudioData().audioPath);
                }
                if (!FileUtils.checkFile(this.mMuxerData.getFinalAudioPath())) {
                    c.e("VideoMuxer", "combineVADone");
                    notifyMuxerEnd(str);
                    return;
                }
                if (this.mAuidoVideoMuxer == null) {
                    a aVar = new a();
                    this.mAuidoVideoMuxer = aVar;
                    aVar.a(this);
                }
                c.e("VideoMuxer", "muxmusic:vp:" + this.mMuxerData.getVideoPath() + ",ap:" + this.mMuxerData.getFinalAudioPath());
                this.mAuidoVideoMuxer.a(this.mMuxerData);
                return;
            } else {
                str2 = "muxerMusic:mMuxerData == null";
            }
            c.e("VideoMuxer", str2);
        }
    }

    private void doChangeAuidoSpeed(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, this, list) == null) || h.e(list)) {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    for (int i2 = 0; i2 < this.val$videoList.size(); i2++) {
                        MultiMediaData multiMediaData = (MultiMediaData) this.val$videoList.get(i2);
                        int i3 = multiMediaData.type;
                        if (i3 == 0) {
                            int multiMediaDataRealEnd = this.this$0.mMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) h.c(this.this$0.mMuxerData.getCurrThemeEffect().mediaTracks, 0), i2)) : 0;
                            if (multiMediaDataRealEnd == 0) {
                                multiMediaDataRealEnd = (int) multiMediaData.end;
                            }
                            arrayList.add(new AudioPlayData("", (int) multiMediaData.start, multiMediaDataRealEnd, multiMediaData.volume));
                        } else if (i3 == 1) {
                            File file = new File(FileUtils.removeExtention(multiMediaData.path) + "_audio.aac");
                            if (!file.exists()) {
                                x.c(multiMediaData.path, file.getPath());
                            }
                            arrayList.add(new AudioPlayData(file.getPath(), (int) multiMediaData.start, (int) multiMediaData.end, multiMediaData.volume, multiMediaData.getCurrentSpeed()));
                        }
                    }
                    d.a.y0.i.b bVar = new d.a.y0.i.b();
                    bVar.h(arrayList);
                    bVar.g(new b.InterfaceC1969b(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1.1
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
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
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

                        @Override // d.a.y0.i.b.InterfaceC1969b
                        public void onFailed(String str) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                d.a.y0.m.a aVar = new d.a.y0.m.a();
                                aVar.f71285e = "audioeditorerror:" + str;
                                this.this$1.this$0.notifyMuxerFail(aVar);
                            }
                        }

                        public void onProgress(int i4) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) {
                            }
                        }

                        @Override // d.a.y0.i.b.InterfaceC1969b
                        public void onSuccess(List<AudioPlayData> list2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048579, this, list2) == null) {
                                if (d.a.y0.i.c.k(this.this$1.this$0.mMuxerData.getFakeVoiceTypes())) {
                                    this.this$1.this$0.processFakeVoice(null, list2);
                                } else {
                                    this.this$1.this$0.combineAudio(null, list2);
                                }
                            }
                        }
                    });
                    bVar.i();
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
                ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(d.a.y0.b.d().b(), this.mMuxerData.getVideoPath(), new File(this.mMuxerData.getVideoPath()).getParent() + File.separator + FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + ".mp4");
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

    private d.a.y0.h.c getAudioMixDataFormMuxerData(VideoMuxerData videoMuxerData, List<MultiMediaDataTrack> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, videoMuxerData, list)) == null) {
            if (videoMuxerData == null || h.e(list)) {
                return null;
            }
            CheckUtils.syncMusicData(videoMuxerData);
            List<d.a.y0.h.a> buildAudioDataList = buildAudioDataList(list.get(0).multiMediaDataList);
            ArrayList arrayList = new ArrayList();
            if (!h.e(buildAudioDataList)) {
                e eVar = new e(buildAudioDataList);
                eVar.c(videoMuxerData.getFakeVoiceTypes());
                arrayList.add(eVar);
            }
            if (!h.e(videoMuxerData.getAudioPlayDataList())) {
                ArrayList arrayList2 = new ArrayList();
                for (AudioPlayData audioPlayData : videoMuxerData.getAudioPlayDataList()) {
                    arrayList2.add(new d.a.y0.h.a(audioPlayData));
                }
                arrayList.add(new e(arrayList2));
            }
            if (!h.e(videoMuxerData.getAudioPlayTrackDataList())) {
                CheckUtils.checkAudioPlayTrackDataList(videoMuxerData.getAudioPlayTrackDataList(), videoMuxerData);
                for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
                    if (audioPlayTrackData != null && !h.e(audioPlayTrackData.mAudioPlayDataList)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (AudioPlayData audioPlayData2 : audioPlayTrackData.mAudioPlayDataList) {
                            arrayList3.add(new d.a.y0.h.a(audioPlayData2));
                        }
                        arrayList.add(new e(arrayList3));
                    }
                }
            }
            d.a.y0.h.c cVar = new d.a.y0.h.c(arrayList);
            if (!TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                cVar.d(videoMuxerData.getCachePath() + "/");
            }
            cVar.e(new d.a.y0.h.a(videoMuxerData.getMuteAudioData()));
            return cVar;
        }
        return (d.a.y0.h.c) invokeLL.objValue;
    }

    private boolean isMute(List<MultiMediaData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, list)) == null) {
            if (h.e(list)) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00a9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00be */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00c1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x003d */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
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
            d.a.y0.m.b.b("notifyMuxerEnd", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime));
            if (this.mNeedAbort) {
                onGenFilterVideoAbort();
                return;
            }
            if (this.mListener != null) {
                File file = new File(str);
                int i2 = -1;
                String str2 = "no exception";
                if (file.exists()) {
                    FileInputStream fileInputStream2 = 0;
                    try {
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                fileInputStream = new FileInputStream(file);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        mediaMetadataRetriever = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaMetadataRetriever = null;
                    }
                    try {
                        mediaMetadataRetriever.setDataSource(fileInputStream.getFD());
                        i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                        fileInputStream2 = "muxer_publish_log";
                        d.a.y0.m.b.a("muxer_publish_log", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime) + ", duration : " + i2 + ", bitrate : " + mediaMetadataRetriever.extractMetadata(20) + ", hevc : " + this.mMuxerData.isCurrentEncodeHevcVideo());
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream2 = fileInputStream;
                        str2 = e.toString();
                        if (fileInputStream2 != 0) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                    mediaMetadataRetriever.release();
                }
                if (!FileUtils.checkFile(str) || i2 <= 0) {
                    d.a.y0.m.a aVar = new d.a.y0.m.a();
                    aVar.f71282b = true;
                    aVar.f71281a = 24;
                    aVar.f71283c = "error_mixtrue";
                    StringBuilder sb = new StringBuilder();
                    sb.append("视频预处理合成失败,视频文件丢失 FinalVideoPath=");
                    sb.append(str);
                    sb.append(" , 时长=");
                    sb.append(i2);
                    sb.append(" , size=");
                    sb.append(FileUtils.getFileSize(str));
                    sb.append(" , eMsg=");
                    sb.append(str2);
                    if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getVideoPath())) {
                        sb.append(" , video path=");
                        sb.append(this.mMuxerData.getVideoPath());
                        sb.append(" , video 时长=");
                        sb.append(n.f(this.mMuxerData.getVideoPath()));
                        sb.append(" , video size=");
                        sb.append(FileUtils.getFileSize(this.mMuxerData.getVideoPath()));
                    }
                    if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getFinalAudioPath())) {
                        sb.append(" , audio path=");
                        sb.append(this.mMuxerData.getFinalAudioPath());
                        sb.append(" , audio 时长=");
                        sb.append(n.f(this.mMuxerData.getFinalAudioPath()));
                        sb.append(" , audio size=");
                        sb.append(FileUtils.getFileSize(this.mMuxerData.getFinalAudioPath()));
                    }
                    sb.append(" , needAbort=");
                    sb.append(this.mNeedAbort);
                    sb.append(" , trace=");
                    sb.append(m.g(new RuntimeException()));
                    aVar.f71285e = sb.toString();
                    this.mListener.e(aVar.a().toString());
                } else {
                    onProgress(2, 100);
                    this.mListener.d(str);
                }
            }
            resetProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMuxerFail(d.a.y0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, aVar) == null) {
            resetProgress();
            if (this.mListener != null) {
                String str = null;
                if (aVar != null) {
                    if (this.mMuxerData != null && this.mMuxerData.getCurrThemeEffect() != null && !TextUtils.isEmpty(aVar.f71285e)) {
                        aVar.f71285e += ",themeName : " + this.mMuxerData.getCurrThemeEffect().name;
                    }
                    aVar.f71285e += ",checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData);
                    aVar.f71285e += ",checkVideoDirectNext : " + CheckUtils.checkVideoDirectNext(this.mMuxerData);
                    aVar.f71285e += ",needAbort : " + this.mNeedAbort;
                    str = aVar.a().toString();
                }
                this.mListener.e(str);
            }
        }
    }

    private void notifyMuxerMusicEnd() {
        d.a.y0.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || (bVar = this.mListener) == null) {
            return;
        }
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65569, this, i2, i3) == null) || this.mListener == null) {
            return;
        }
        if (i2 == 0) {
            int i4 = (int) (i3 * 0.45f);
            if (this.mLastVideoPercent == i4) {
                return;
            }
            this.mLastVideoPercent = i4;
        } else if (i2 == 1) {
            int i5 = (int) (i3 * 0.45f);
            if (this.mLastAudioPercent == i5) {
                return;
            }
            this.mLastAudioPercent = i5;
        } else if (i2 == 2) {
            int i6 = (int) (i3 * 0.1f);
            if (this.mLastAudioVideoPercent == i6) {
                return;
            }
            this.mLastAudioVideoPercent = i6;
        }
        int i7 = this.mLastVideoPercent + this.mLastAudioPercent + this.mLastAudioVideoPercent;
        this.mListener.b(i7);
        StringBuilder sb = new StringBuilder();
        sb.append("progressType : ");
        sb.append(i2 == 0 ? "video" : "audio");
        sb.append(" percent : ");
        sb.append(i3);
        sb.append(" progress : ");
        sb.append(i7);
        d.a.y0.m.b.b("onProgress", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAuidoMuxProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i2) == null) {
            u.a().post(new Runnable(this, i2) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoMuxer this$0;
                public final /* synthetic */ int val$audioProgress;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$audioProgress = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mListener == null) {
                        return;
                    }
                    c.j("VideoMuxer", "audioProgress:" + this.val$audioProgress);
                    int i3 = this.val$audioProgress;
                    if (i3 <= 100) {
                        this.this$0.onProgress(1, i3);
                    }
                }
            });
        }
    }

    private void preMuxKSongRepair(String str) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65571, this, str) == null) && (multiMediaData = (MultiMediaData) h.c(this.mMuxerData.getPhotoDataList(), 0)) != null && FileUtils.isExists(multiMediaData.path)) {
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                            c.e("VideoMuxer: ", "K歌修音处理， out_put_path = " + str2);
                            boolean j = x.j(sb, this.val$repairAudioPath, this.val$multiMediaData.path, str2, 0L, -1L);
                            if (j) {
                                this.val$multiMediaData.path = str2;
                            }
                            c.e("VideoMuxer: ", "K歌修音处理合成结果：" + j);
                            if (!this.this$0.mNeedAbort || this.this$0.mListener == null) {
                                u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2.1
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
            d.a.y0.m.b.b("processFakeVoice", "变声处理");
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                            List buildAudioPlayDataList = !h.e(this.val$videoList) ? this.this$0.buildAudioPlayDataList(this.val$videoList) : this.val$audioList;
                            if (h.e(buildAudioPlayDataList)) {
                                this.this$0.combineAudioFinish();
                                return;
                            }
                            File file = new File(videoMuxerData.getCachePath());
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            String str2 = videoMuxerData.getCachePath() + "/" + l.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_for_fake_voice.aac";
                            d.a.y0.m.a aVar = new d.a.y0.m.a();
                            if (videoMuxerData.isKSongHuaTongMode()) {
                                if (buildAudioPlayDataList == null) {
                                    buildAudioPlayDataList = new ArrayList();
                                }
                                buildAudioPlayDataList.clear();
                                buildAudioPlayDataList.add(new AudioPlayData(this.this$0.mMuxerData.getKSongHuaTongRecordPath(), 0, n.f(this.this$0.mMuxerData.getKSongHuaTongRecordPath()), 1.0f));
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

                                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                                public void mixerProgress(int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                    }
                                }
                            }, aVar)) {
                                String str3 = videoMuxerData.getCachePath() + "/" + l.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_fake_voice.aac";
                                try {
                                    this.this$0.mSoundStreamFileWriter = new d.a.y0.i.g.a(str2, str3, videoMuxerData.getFakeVoiceTypes());
                                    this.this$0.mSoundStreamFileWriter.M(new d.a.y0.l.d.j.c.a(this, videoMuxerData, str3) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.2
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
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$videoMuxerData = videoMuxerData;
                                            this.val$fakeVoiceOutputPath = str3;
                                        }

                                        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
                                        public void onExceptionThrown(String str4) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, str4) == null) {
                                                c.e("VideoMuxer: ", "onExceptionThrown: " + str4);
                                                if (this.this$1.this$0.mNeedAbort) {
                                                    return;
                                                }
                                                this.this$1.this$0.combineAudioFinish();
                                            }
                                        }

                                        @Override // d.a.y0.l.d.j.c.a
                                        public void onFinishedWriting(boolean z) {
                                            String str4;
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.this$1.this$0.mNeedAbort) {
                                                return;
                                            }
                                            c.e("VideoMuxer: ", "变声处理：end_time" + System.currentTimeMillis());
                                            String str5 = this.val$videoMuxerData.getCachePath() + "/" + l.b(this.val$videoMuxerData.toString()) + System.currentTimeMillis() + "_mix_fake_voice.aac";
                                            try {
                                                File file2 = new File(new File(str5).getParent());
                                                if (!file2.exists()) {
                                                    file2.mkdirs();
                                                }
                                            } catch (Exception e2) {
                                                c.g(e2);
                                            }
                                            d.a.y0.m.a aVar2 = new d.a.y0.m.a();
                                            int b2 = (int) x.b(this.val$fakeVoiceOutputPath);
                                            ArrayList arrayList = new ArrayList();
                                            if (b2 > 0) {
                                                arrayList.add(new AudioPlayData(this.val$fakeVoiceOutputPath, 0, b2, 1.0f));
                                            }
                                            boolean startCombineAudio = this.this$1.this$0.startCombineAudio(arrayList, str5, aVar2);
                                            if (startCombineAudio) {
                                                this.val$videoMuxerData.setFinalAudioPath(str5);
                                                str4 = "audiocombineresult:" + startCombineAudio + "audiopath:" + str5 + ",isVideoDone:" + this.this$1.this$0.misVideoCombineDone;
                                            } else {
                                                d.a.y0.a.a("v_log_audio_mixer_error", aVar2.f71285e, null);
                                                str4 = "mixtureAACFileList fail" + aVar2.f71285e;
                                            }
                                            c.e("VideoMuxer", str4);
                                            this.this$1.this$0.combineAudioFinish();
                                        }

                                        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
                                        public void onProgressChanged(int i2, double d2, long j) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
                                            }
                                        }

                                        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
                                        public void onTrackEnd(int i2) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeI(1048579, this, i2) == null) {
                                            }
                                        }
                                    });
                                    if (this.this$0.mNeedAbort) {
                                        return;
                                    }
                                    this.this$0.mSoundStreamFileWriter.y(videoMuxerData.getFakeVoiceTypes());
                                    this.this$0.mSoundStreamFileWriter.C();
                                    c.e("VideoMuxer: ", "变声处理：start_time" + System.currentTimeMillis());
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    c.e("VideoMuxer: ", "onExceptionThrown: " + m.g(e2));
                                }
                            } else {
                                d.a.y0.a.a("v_log_audio_mixer_error", aVar.f71285e, null);
                                str = "mixtureAACFileList fail" + aVar.f71285e;
                            }
                        }
                        c.e("VideoMuxer", str);
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
                if (h.b(videoMuxerData.getPhotoDataList()) == 1) {
                    MultiMediaData multiMediaData = (MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0);
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
                d.a.y0.m.b.b("startMuxer", "checkVideoDirectNext");
                if (h.b(videoMuxerData.getPhotoDataList()) == 1) {
                    onProgress(0, 100);
                    onGenFilterVideoSuccess(((MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
                    } else if (!d.a.y0.i.c.k(this.mMuxerData.getFakeVoiceTypes()) || isMute(buildTracks.get(0).multiMediaDataList)) {
                        combineAudio(buildTracks.get(0).multiMediaDataList, null);
                        return;
                    } else {
                        processFakeVoice(buildTracks.get(0).multiMediaDataList, null);
                        return;
                    }
                }
                d.a.y0.h.c audioMixDataFormMuxerData = getAudioMixDataFormMuxerData(this.mMuxerData, buildTracks);
                if (audioMixDataFormMuxerData != null && !h.e(audioMixDataFormMuxerData.c())) {
                    d dVar = new d(audioMixDataFormMuxerData);
                    this.mAudioMixtureManager = dVar;
                    dVar.q(this);
                    this.mAudioMixtureManager.r();
                    return;
                }
            } else if (h.b(videoMuxerData.getPhotoDataList()) != 1) {
                return;
            } else {
                videoMuxerData.setFinalAudioPath(((MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
    public boolean startCombineAudio(List<AudioPlayData> list, String str, d.a.y0.m.a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        boolean z2;
        List<AudioPlayData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65575, this, list, str, aVar)) == null) {
            d.a.y0.m.b.b("startCombineAudio", "拼接混合音频");
            VideoMuxerData videoMuxerData = this.mMuxerData;
            if (videoMuxerData == null) {
                return false;
            }
            boolean z3 = true;
            if (!h.e(list)) {
                for (AudioPlayData audioPlayData : list) {
                    if (FileUtils.isExists(audioPlayData.audioPath)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            CheckUtils.syncMusicData(videoMuxerData);
            if (videoMuxerData != null && !h.e(videoMuxerData.getAudioPlayDataList())) {
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
                    long f2 = n.f(videoMuxerData.getMuteAudioData().audioPath);
                    videoMuxerData.getMuteAudioData().start = 0;
                    videoMuxerData.getMuteAudioData().end = (int) f2;
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

                    @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                    public void mixerProgress(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.postAuidoMuxProgress(i2);
                        }
                    }
                }, aVar) : VLogMultiAudioMixer.mixtureAACFileList(list2, str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener(this) { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.7
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

                    @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                    public void mixerProgress(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.postAuidoMuxProgress(i2);
                        }
                    }
                }, aVar);
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

                    @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                    public void mixerProgress(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.postAuidoMuxProgress(i2);
                        }
                    }
                }, aVar);
            } else {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x016a, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0173, code lost:
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0175, code lost:
        r1.release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void themeVideo(List<MultiMediaDataTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, list) == null) {
            d.a.y0.m.b.b("themeVideo", "视频处理开始");
            MediaExtractor mediaExtractor = null;
            if (h.e(this.mMuxerData.getPhotoDataList()) || this.mMuxerData.getCurrThemeEffect() == null) {
                notifyMuxerEnd(null);
                return;
            }
            ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(d.a.y0.b.d().b(), list, null, d.a.y0.b.d().g() + "/video_" + System.currentTimeMillis() + ".mp4");
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
            if (h.b(this.mMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(this.mMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1) {
                    int frameRate = this.mMuxerData.getFrameRate();
                    if (frameRate == 0) {
                        frameRate = 30;
                    }
                    try {
                        try {
                            mediaExtractor = m.b(multiMediaData.path);
                            int integer = mediaExtractor.getTrackFormat(m.f(mediaExtractor)).getInteger("frame-rate");
                            if (integer < frameRate) {
                                frameRate = integer;
                            }
                            this.mComposeThemeVideoModel.setFrameRate(frameRate);
                            c.j("startMuxer", "videoFrameRate : " + integer + " frameRate : " + frameRate);
                        } catch (Exception e2) {
                            e2.printStackTrace();
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
            d dVar = this.mAudioMixtureManager;
            if (dVar != null) {
                dVar.i();
                this.mAudioMixtureManager.p();
            }
            a aVar = this.mAuidoVideoMuxer;
            if (aVar != null) {
                aVar.a();
            }
            d.a.y0.i.g.a aVar2 = this.mSoundStreamFileWriter;
            if (aVar2 != null) {
                aVar2.D();
            }
        }
    }

    @Override // d.a.y0.h.d.b
    public void onAudioMixtureCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.j("VideoMuxer", "onAudioMixtureCancel");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    @Override // d.a.y0.h.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAudioMixtureFail(String str) {
        String json;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.mNeedAbort) {
            return;
        }
        c.j("VideoMuxer", "onAudioMixtureFail:" + str);
        StringBuilder sb = new StringBuilder();
        if (this.mMuxerData != null) {
            if (h.e(this.mMuxerData.getAudioPlayDataList())) {
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
                if (h.e(this.mMuxerData.getPhotoDataList())) {
                    sb.append("videopaths:");
                    for (MultiMediaData multiMediaData : this.mMuxerData.getPhotoDataList()) {
                        sb.append(multiMediaData.path);
                    }
                } else {
                    sb.append("no video info");
                }
            }
            sb.append(json);
            if (h.e(this.mMuxerData.getPhotoDataList())) {
            }
        }
        d.a.y0.a.a("v_log_audio_mixer_error", "onAudioMixtureFail:" + str + ",inputinfo:" + sb.toString(), null);
        combineAudioFinish();
    }

    @Override // d.a.y0.h.d.b
    public void onAudioMixtureProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.mNeedAbort) {
            return;
        }
        postAuidoMuxProgress(i2);
    }

    @Override // d.a.y0.h.d.b
    public void onAudioMixtureSuccess(d.a.y0.h.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.mNeedAbort) {
            return;
        }
        if (bVar == null || !FileUtils.checkFile(bVar.h())) {
            c.j("VideoMuxer", "onAudioMixtureSuccess file not exit");
            d.a.y0.a.a("v_log_audio_mixer_error", "onAudioMixtureSuccess file not exit", null);
        } else {
            c.j("VideoMuxer", "onAudioMixtureSuccess path:" + bVar.h() + "audioduration:" + n.c(bVar.h(), 0));
            this.mMuxerData.setFinalAudioPath(bVar.h());
        }
        combineAudioFinish();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0251a
    public void onAudioVideoMuxerCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            onGenFilterVideoAbort();
            c.e("VideoMuxer", "onMuxerCancel");
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0251a
    public void onAudioVideoMuxerFail(d.a.y0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            notifyMuxerFail(aVar);
            if (aVar != null) {
                c.e("VideoMuxer", "onMuxerMusicFail:" + aVar.f71285e);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0251a
    public void onAudioVideoMuxerFinish(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.e("VideoMuxer", "onMuxerMusicFinish:" + str);
            if (FileUtils.checkFile(str)) {
                c.e("VideoMuxer", "notifyMuxerMusicEnd+notifyMuxerEnd:" + str);
                notifyMuxerMusicEnd();
            } else {
                str = this.mMuxerData.getVideoPath();
            }
            notifyMuxerEnd(str);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoAbort() {
        d.a.y0.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.mListener) == null) {
            return;
        }
        bVar.c();
        resetProgress();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoFail(int i2, String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) || this.mNeedAbort) {
            return;
        }
        if (i2 != -100 || (i3 = this.mRetryCount) >= MAX_RETRY_COUNT) {
            d.a.y0.m.b.b("onGenFilterVideoFail", "视频处理-失败");
            d.a.y0.m.a aVar = new d.a.y0.m.a();
            aVar.f71281a = 24;
            aVar.f71283c = "error_mixtrue";
            aVar.f71282b = true;
            aVar.f71285e = "视频预处理合成处理视频特效合成失败 checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData) + " --- " + str;
            d dVar = this.mAudioMixtureManager;
            if (dVar != null) {
                dVar.i();
            }
            notifyMuxerFail(aVar);
            return;
        }
        this.mRetryCount = i3 + 1;
        d.a.y0.m.b.b("onGenFilterVideoFail", "视频处理-失败重试 ：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        if (this.mRetryCount == 1 && !this.mIsAudioCombineDone && this.mIsUseNewAudioMixture) {
            return;
        }
        if (this.mRetryCount == MAX_RETRY_COUNT) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.mNeedAbort) {
                return;
            }
        }
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        this.mMuxerData.setCurrentEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
        try {
            d.a.y0.a.a("v_log_retry_inner_multimedia_processor", str + ",视频处理-失败重试 ：" + this.mRetryCount, null);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            onProgress(0, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoRecordError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            notifyMuxerEnd(null);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            d.a.y0.m.b.b("onGenFilterVideoSuccess", "视频处理-成功");
            this.misVideoCombineDone = true;
            if (this.mNeedAbort) {
                onGenFilterVideoAbort();
                return;
            }
            this.mMuxerData.setVideoPath(str);
            c.j("VideoMuxer", "videocombinedone" + this.mIsAudioCombineDone + ",videopath:" + str + "videoduration:" + n.c(str, 1) + "," + n.b(str) + "," + x.f(str));
            if (this.mIsAudioCombineDone) {
                combineVA(str);
            }
        }
    }

    public void setListener(d.a.y0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.mListener = bVar;
        }
    }

    public void startMuxer(VideoMuxerData videoMuxerData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoMuxerData) == null) {
            StringBuilder sb = new StringBuilder();
            if (videoMuxerData != null && (FileUtils.isExists(videoMuxerData.getVideoPath()) || CheckUtils.checkAllFileExist(videoMuxerData, sb))) {
                this.mStartTime = System.currentTimeMillis();
                d.a.y0.e.b bVar = this.mListener;
                if (bVar != null) {
                    bVar.f();
                }
                this.mMuxerData = videoMuxerData;
                this.mIsUseNewAudioMixture = this.mMuxerData.isUserNewAudioMixture();
                try {
                    d.a.y0.a.a("v_log_codec_h265_support", m.m("video/hevc") != null ? "yes" : "no", null);
                } catch (Exception e2) {
                    e2.printStackTrace();
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
            d.a.y0.m.a aVar = new d.a.y0.m.a();
            aVar.f71281a = 24;
            aVar.f71283c = "error_mixtrue";
            aVar.f71282b = true;
            StringBuilder sb2 = new StringBuilder();
            if (videoMuxerData == null) {
                str = "开始合成，合成信息丢失:muxerData为空";
            } else {
                sb2.append("开始合成，合成信息丢失,videopath:" + videoMuxerData.getVideoPath());
                sb2.append(",photoDataList size:" + h.b(videoMuxerData.getPhotoDataList()));
                sb2.append(",draftName:" + videoMuxerData.getDraftName());
                sb2.append(",muxerFrom:" + videoMuxerData.getMuxerFrom());
                str = ",checkerror:" + sb.toString();
            }
            sb2.append(str);
            aVar.f71285e = sb2.toString();
            notifyMuxerFail(aVar);
        }
    }

    public void startMuxerForJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                startMuxer((VideoMuxerData) new Gson().fromJson(str, (Class<Object>) VideoMuxerData.class));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
