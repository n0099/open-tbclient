package com.baidu.ugc.editvideo.muxer;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tieba.a0a;
import com.baidu.tieba.by9;
import com.baidu.tieba.cy9;
import com.baidu.tieba.d1a;
import com.baidu.tieba.fx9;
import com.baidu.tieba.gx9;
import com.baidu.tieba.i1a;
import com.baidu.tieba.jy9;
import com.baidu.tieba.kx9;
import com.baidu.tieba.m1a;
import com.baidu.tieba.n1a;
import com.baidu.tieba.o1a;
import com.baidu.tieba.sx9;
import com.baidu.tieba.tx9;
import com.baidu.tieba.ux9;
import com.baidu.tieba.v1a;
import com.baidu.tieba.vx9;
import com.baidu.tieba.wx9;
import com.baidu.tieba.y1a;
import com.baidu.tieba.yz9;
import com.baidu.tieba.zz9;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoMuxer implements vx9.b, OnGenFilterVideoListener, a.InterfaceC0503a {
    public static final String FILTER_TEMP_DIR_PREFIX = "video_addfilter_";
    public static int MAX_RETRY_COUNT = 2;
    public vx9 mAudioMixtureManager;
    public long mAudioStartTime;
    public a mAuidoVideoMuxer;
    public ComposeThemeVideoModel mComposeThemeVideoModel;
    public volatile boolean mIsAudioCombineDone;
    public boolean mIsUseNewAudioMixture;
    public int mLastAudioPercent;
    public int mLastAudioVideoPercent;
    public int mLastVideoPercent;
    public kx9 mListener;
    public volatile VideoMuxerData mMuxerData;
    public volatile boolean mNeedAbort = false;
    public int mRetryCount;
    public jy9 mSoundStreamFileWriter;
    public long mStartTime;
    public volatile boolean misVideoCombineDone;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface MuxerProgressType {
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_AUDIO_VIDEO = 2;
        public static final int TYPE_VIDEO = 0;
    }

    private List<sx9> buildAudioDataList(List<MultiMediaData> list) {
        if (i1a.e(list)) {
            return null;
        }
        VideoMuxerData videoMuxerData = this.mMuxerData;
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = 0; i < list.size(); i++) {
            MultiMediaData multiMediaData = list.get(i);
            int i2 = multiMediaData.type;
            if (i2 == 0) {
                int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) i1a.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                int i3 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd == 0) {
                    multiMediaDataRealEnd = (int) multiMediaData.end;
                }
                arrayList.add(new sx9(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
            } else if (i2 == 1) {
                if (multiMediaData.volume > 0.0f) {
                    z = false;
                }
                int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (((float) multiMediaData.start) + (((float) MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) i1a.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) * multiMediaData.mSpeed)) : 0;
                String str = multiMediaData.path;
                int i4 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd2 == 0) {
                    multiMediaDataRealEnd2 = (int) multiMediaData.end;
                }
                arrayList.add(new sx9(new AudioPlayData(str, i4, multiMediaDataRealEnd2, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
            }
        }
        if (z) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AudioPlayData> buildAudioPlayDataList(List<MultiMediaData> list) {
        if (i1a.e(list)) {
            return null;
        }
        VideoMuxerData videoMuxerData = this.mMuxerData;
        if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
            videoMuxerData.setCachePath(gx9.c().a() + "/tempaudio");
            d1a.e("VideoMuxer", "have not set audioCachePath");
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
                int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) i1a.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                int i3 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd == 0) {
                    multiMediaDataRealEnd = (int) multiMediaData.end;
                }
                arrayList.add(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume));
            } else if (i2 == 1) {
                File file2 = new File(videoMuxerData.getCachePath(), m1a.b(multiMediaData.path));
                if (!file2.exists()) {
                    y1a.c(multiMediaData.path, file2.getPath());
                }
                int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) i1a.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
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

    private List<MultiMediaDataTrack> buildTracks(VideoMuxerData videoMuxerData) {
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

    private boolean checkMuxerData() {
        return (this.mMuxerData == null || TextUtils.isEmpty(this.mMuxerData.getVideoPath())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineAudio(final List<MultiMediaData> list, final List<AudioPlayData> list2) {
        a0a.b("combineAudio", "音频拼接混合处理");
        this.mIsAudioCombineDone = false;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                StringBuilder sb;
                VideoMuxerData videoMuxerData = VideoMuxer.this.mMuxerData;
                if (videoMuxerData != null && videoMuxerData.getPhotoDataList() != null && videoMuxerData.getPhotoDataList().get(0) != null) {
                    List buildAudioPlayDataList = !i1a.e(list) ? VideoMuxer.this.buildAudioPlayDataList(list) : list2;
                    if (!i1a.e(buildAudioPlayDataList)) {
                        String str2 = videoMuxerData.getCachePath() + "/" + m1a.b(videoMuxerData.toString()) + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                        try {
                            File file = new File(new File(str2).getParent());
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                        } catch (Exception e) {
                            d1a.g(e);
                        }
                        zz9 zz9Var = new zz9();
                        boolean startCombineAudio = VideoMuxer.this.startCombineAudio(buildAudioPlayDataList, str2, zz9Var);
                        a0a.b("combineAudio", "音频拼接混合处理-结果" + startCombineAudio);
                        if (startCombineAudio) {
                            videoMuxerData.setFinalAudioPath(str2);
                            sb = new StringBuilder();
                            sb.append("audiocombineresult:");
                            sb.append(startCombineAudio);
                            sb.append("audiopath:");
                            sb.append(str2);
                            sb.append(",isVideoDone:");
                            sb.append(VideoMuxer.this.misVideoCombineDone);
                        } else {
                            fx9.a("v_log_audio_mixer_error", zz9Var.e, null);
                            sb = new StringBuilder();
                            sb.append("mixtureAACFileList fail");
                            sb.append(zz9Var.e);
                        }
                        str = sb.toString();
                    }
                    VideoMuxer.this.combineAudioFinish();
                }
                str = "origin data fomat error";
                d1a.e("VideoMuxer", str);
                VideoMuxer.this.combineAudioFinish();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineAudioFinish() {
        if (this.mNeedAbort) {
            return;
        }
        if (!this.mIsUseNewAudioMixture || this.mRetryCount != 1) {
            v1a.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.4
                @Override // java.lang.Runnable
                public void run() {
                    VideoMuxer.this.mIsAudioCombineDone = true;
                    if (VideoMuxer.this.misVideoCombineDone) {
                        VideoMuxer.this.onProgress(1, 100);
                        VideoMuxer videoMuxer = VideoMuxer.this;
                        videoMuxer.combineVA(videoMuxer.mMuxerData.getVideoPath());
                    }
                }
            });
            return;
        }
        a0a.b("onGenFilterVideoFail", "视频处理-失败重试-combineAudioFinish：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        this.mIsAudioCombineDone = true;
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineVA(String str) {
        String str2;
        a0a.b("combineVA", "音视频混合");
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            str2 = "muxerMusic:abort";
        } else if (this.mMuxerData != null) {
            d1a.e("VideoMuxer", "combineVA:" + str);
            if (this.mMuxerData != null && !FileUtils.checkFile(this.mMuxerData.getFinalAudioPath()) && this.mMuxerData.getMuteAudioData() != null) {
                this.mMuxerData.setFinalAudioPath(this.mMuxerData.getMuteAudioData().audioPath);
            }
            if (!FileUtils.checkFile(this.mMuxerData.getFinalAudioPath())) {
                d1a.e("VideoMuxer", "combineVADone");
                notifyMuxerEnd(str);
                return;
            }
            if (this.mAuidoVideoMuxer == null) {
                a aVar = new a();
                this.mAuidoVideoMuxer = aVar;
                aVar.a(this);
            }
            d1a.e("VideoMuxer", "muxmusic:vp:" + this.mMuxerData.getVideoPath() + ",ap:" + this.mMuxerData.getFinalAudioPath());
            this.mAuidoVideoMuxer.a(this.mMuxerData);
            return;
        } else {
            str2 = "muxerMusic:mMuxerData == null";
        }
        d1a.e("VideoMuxer", str2);
    }

    private void doChangeAuidoSpeed(final List<MultiMediaData> list) {
        if (i1a.e(list)) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    MultiMediaData multiMediaData = (MultiMediaData) list.get(i);
                    int i2 = multiMediaData.type;
                    if (i2 == 0) {
                        int multiMediaDataRealEnd = VideoMuxer.this.mMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) i1a.c(VideoMuxer.this.mMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                        if (multiMediaDataRealEnd == 0) {
                            multiMediaDataRealEnd = (int) multiMediaData.end;
                        }
                        arrayList.add(new AudioPlayData("", (int) multiMediaData.start, multiMediaDataRealEnd, multiMediaData.volume));
                    } else if (i2 == 1) {
                        File file = new File(FileUtils.removeExtention(multiMediaData.path) + "_audio.aac");
                        if (!file.exists()) {
                            y1a.c(multiMediaData.path, file.getPath());
                        }
                        arrayList.add(new AudioPlayData(file.getPath(), (int) multiMediaData.start, (int) multiMediaData.end, multiMediaData.volume, multiMediaData.getCurrentSpeed()));
                    }
                }
                by9 by9Var = new by9();
                by9Var.h(arrayList);
                by9Var.g(new by9.b() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1.1
                    public void onCancel() {
                        VideoMuxer.this.onGenFilterVideoAbort();
                    }

                    @Override // com.baidu.tieba.by9.b
                    public void onFailed(String str) {
                        zz9 zz9Var = new zz9();
                        zz9Var.e = "audioeditorerror:" + str;
                        VideoMuxer.this.notifyMuxerFail(zz9Var);
                    }

                    public void onProgress(int i3) {
                    }

                    @Override // com.baidu.tieba.by9.b
                    public void onSuccess(List<AudioPlayData> list2) {
                        if (cy9.o(VideoMuxer.this.mMuxerData.getFakeVoiceTypes())) {
                            VideoMuxer.this.processFakeVoice(null, list2);
                        } else {
                            VideoMuxer.this.combineAudio(null, list2);
                        }
                    }
                });
                by9Var.i();
            }
        }).start();
    }

    private void filterVideo() {
        if (!checkMuxerData()) {
            notifyMuxerEnd(this.mMuxerData.getVideoPath());
        } else if (!CheckUtils.checkEffect(this.mMuxerData)) {
            onGenFilterVideoSuccess(this.mMuxerData.getVideoPath());
        } else if (TextUtils.isEmpty(this.mMuxerData.getVideoPath()) || !new File(this.mMuxerData.getVideoPath()).exists()) {
            onGenFilterVideoFail(-1, "inputPath invalid or no file");
        } else {
            ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(gx9.c().getContext(), this.mMuxerData.getVideoPath(), new File(this.mMuxerData.getVideoPath()).getParent() + File.separator + FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
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

    private ux9 getAudioMixDataFormMuxerData(VideoMuxerData videoMuxerData, List<MultiMediaDataTrack> list) {
        if (videoMuxerData == null || i1a.e(list)) {
            return null;
        }
        CheckUtils.syncMusicData(videoMuxerData);
        List<sx9> buildAudioDataList = buildAudioDataList(list.get(0).multiMediaDataList);
        ArrayList arrayList = new ArrayList();
        if (!i1a.e(buildAudioDataList)) {
            wx9 wx9Var = new wx9(buildAudioDataList);
            wx9Var.c(videoMuxerData.getFakeVoiceTypes());
            arrayList.add(wx9Var);
        }
        if (!i1a.e(videoMuxerData.getAudioPlayDataList())) {
            ArrayList arrayList2 = new ArrayList();
            for (AudioPlayData audioPlayData : videoMuxerData.getAudioPlayDataList()) {
                arrayList2.add(new sx9(audioPlayData));
            }
            arrayList.add(new wx9(arrayList2));
        }
        if (!i1a.e(videoMuxerData.getAudioPlayTrackDataList())) {
            CheckUtils.checkAudioPlayTrackDataList(videoMuxerData.getAudioPlayTrackDataList(), videoMuxerData);
            for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
                if (audioPlayTrackData != null && !i1a.e(audioPlayTrackData.mAudioPlayDataList)) {
                    ArrayList arrayList3 = new ArrayList();
                    for (AudioPlayData audioPlayData2 : audioPlayTrackData.mAudioPlayDataList) {
                        arrayList3.add(new sx9(audioPlayData2));
                    }
                    arrayList.add(new wx9(arrayList3));
                }
            }
        }
        ux9 ux9Var = new ux9(arrayList);
        if (!TextUtils.isEmpty(videoMuxerData.getCachePath())) {
            ux9Var.d(videoMuxerData.getCachePath() + "/");
        }
        ux9Var.e(new sx9(videoMuxerData.getMuteAudioData()));
        return ux9Var;
    }

    private boolean isMute(List<MultiMediaData> list) {
        if (i1a.e(list)) {
            return false;
        }
        for (MultiMediaData multiMediaData : list) {
            if (multiMediaData != null && multiMediaData.volume != 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
        if (r5 == null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void notifyMuxerEnd(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        FileInputStream fileInputStream;
        a0a.b("notifyMuxerEnd", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime));
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            return;
        }
        if (this.mListener != null) {
            File file = new File(str);
            int i = -1;
            String str2 = "no exception";
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    mediaMetadataRetriever = null;
                } catch (Throwable th2) {
                    th = th2;
                    mediaMetadataRetriever = null;
                }
                try {
                    mediaMetadataRetriever.setDataSource(fileInputStream.getFD());
                    i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                    a0a.a("muxer_publish_log", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime) + ", duration : " + i + ", bitrate : " + mediaMetadataRetriever.extractMetadata(20) + ", hevc : " + this.mMuxerData.isCurrentEncodeHevcVideo());
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    str2 = e.toString();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
                mediaMetadataRetriever.release();
            }
            if (!FileUtils.checkFile(str) || i <= 0) {
                zz9 zz9Var = new zz9();
                zz9Var.b = true;
                zz9Var.a = 24;
                zz9Var.c = "error_mixtrue";
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
                    sb.append(o1a.f(this.mMuxerData.getVideoPath()));
                    sb.append(" , video size=");
                    sb.append(FileUtils.getFileSize(this.mMuxerData.getVideoPath()));
                }
                if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getFinalAudioPath())) {
                    sb.append(" , audio path=");
                    sb.append(this.mMuxerData.getFinalAudioPath());
                    sb.append(" , audio 时长=");
                    sb.append(o1a.f(this.mMuxerData.getFinalAudioPath()));
                    sb.append(" , audio size=");
                    sb.append(FileUtils.getFileSize(this.mMuxerData.getFinalAudioPath()));
                }
                sb.append(" , needAbort=");
                sb.append(this.mNeedAbort);
                sb.append(" , trace=");
                sb.append(n1a.g(new RuntimeException()));
                zz9Var.e = sb.toString();
                this.mListener.f(zz9Var.a().toString());
            } else {
                onProgress(2, 100);
                this.mListener.e(str);
            }
        }
        resetProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMuxerFail(zz9 zz9Var) {
        resetProgress();
        if (this.mListener != null) {
            String str = null;
            if (zz9Var != null) {
                if (this.mMuxerData != null && this.mMuxerData.getCurrThemeEffect() != null && !TextUtils.isEmpty(zz9Var.e)) {
                    zz9Var.e += ",themeName : " + this.mMuxerData.getCurrThemeEffect().name;
                }
                zz9Var.e += ",checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData);
                zz9Var.e += ",checkVideoDirectNext : " + CheckUtils.checkVideoDirectNext(this.mMuxerData);
                zz9Var.e += ",needAbort : " + this.mNeedAbort;
                str = zz9Var.a().toString();
            }
            this.mListener.f(str);
        }
    }

    private void notifyMuxerMusicEnd() {
        kx9 kx9Var = this.mListener;
        if (kx9Var != null) {
            kx9Var.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(int i, int i2) {
        if (this.mListener == null) {
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
        this.mListener.a(i6);
        StringBuilder sb = new StringBuilder();
        sb.append("progressType : ");
        sb.append(i == 0 ? "video" : "audio");
        sb.append(" percent : ");
        sb.append(i2);
        sb.append(" progress : ");
        sb.append(i6);
        a0a.b("onProgress", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAuidoMuxProgress(final int i) {
        v1a.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.9
            @Override // java.lang.Runnable
            public void run() {
                if (VideoMuxer.this.mListener != null) {
                    d1a.j("VideoMuxer", "audioProgress:" + i);
                    int i2 = i;
                    if (i2 <= 100) {
                        VideoMuxer.this.onProgress(1, i2);
                    }
                }
            }
        });
    }

    private void preMuxKSongRepair(final String str) {
        final MultiMediaData multiMediaData = (MultiMediaData) i1a.c(this.mMuxerData.getPhotoDataList(), 0);
        if (multiMediaData == null || !FileUtils.isExists(multiMediaData.path)) {
            return;
        }
        if (!this.mMuxerData.isKSongHuaTongMode()) {
            new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    String str2 = new File(multiMediaData.path).getParentFile().getAbsoluteFile() + File.separator + System.currentTimeMillis() + "_audio_repair.mp4";
                    d1a.e("VideoMuxer: ", "K歌修音处理， out_put_path = " + str2);
                    boolean j = y1a.j(sb, str, multiMediaData.path, str2, 0L, -1L);
                    if (j) {
                        multiMediaData.path = str2;
                    }
                    d1a.e("VideoMuxer: ", "K歌修音处理合成结果：" + j);
                    if (!VideoMuxer.this.mNeedAbort || VideoMuxer.this.mListener == null) {
                        v1a.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                VideoMuxer videoMuxer = VideoMuxer.this;
                                videoMuxer.realStartMux(videoMuxer.mMuxerData);
                            }
                        });
                    } else {
                        VideoMuxer.this.mListener.d();
                    }
                }
            }).start();
            return;
        }
        multiMediaData.path = str;
        realStartMux(this.mMuxerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processFakeVoice(final List<MultiMediaData> list, final List<AudioPlayData> list2) {
        a0a.b("processFakeVoice", "变声处理");
        this.mIsAudioCombineDone = false;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                final VideoMuxerData videoMuxerData = VideoMuxer.this.mMuxerData;
                if (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || videoMuxerData.getPhotoDataList().get(0) == null) {
                    str = "origin data fomat error";
                } else {
                    List buildAudioPlayDataList = !i1a.e(list) ? VideoMuxer.this.buildAudioPlayDataList(list) : list2;
                    if (i1a.e(buildAudioPlayDataList)) {
                        VideoMuxer.this.combineAudioFinish();
                        return;
                    }
                    if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                        videoMuxerData.setCachePath(gx9.c().a() + "/tempaudio");
                        d1a.e("VideoMuxer", "have not set audioCachePath");
                    }
                    File file = new File(videoMuxerData.getCachePath());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str2 = videoMuxerData.getCachePath() + "/" + m1a.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_for_fake_voice.aac";
                    zz9 zz9Var = new zz9();
                    if (videoMuxerData.isKSongHuaTongMode()) {
                        if (buildAudioPlayDataList == null) {
                            buildAudioPlayDataList = new ArrayList();
                        }
                        buildAudioPlayDataList.clear();
                        buildAudioPlayDataList.add(new AudioPlayData(VideoMuxer.this.mMuxerData.getKSongHuaTongRecordPath(), 0, o1a.f(VideoMuxer.this.mMuxerData.getKSongHuaTongRecordPath()), 1.0f));
                    }
                    if (VLogMultiAudioMixer.mixtureAACFileList(buildAudioPlayDataList, str2, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.1
                        @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                        public void mixerProgress(int i) {
                        }
                    }, zz9Var)) {
                        final String str3 = videoMuxerData.getCachePath() + "/" + m1a.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_fake_voice.aac";
                        try {
                            VideoMuxer.this.mSoundStreamFileWriter = new jy9(str2, str3, videoMuxerData.getFakeVoiceTypes());
                            VideoMuxer.this.mSoundStreamFileWriter.S(new yz9() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.2
                                @Override // com.baidu.tieba.yz9, com.baidu.tieba.xz9
                                public void onExceptionThrown(String str4) {
                                    d1a.e("VideoMuxer: ", "onExceptionThrown: " + str4);
                                    if (VideoMuxer.this.mNeedAbort) {
                                        return;
                                    }
                                    VideoMuxer.this.combineAudioFinish();
                                }

                                @Override // com.baidu.tieba.yz9
                                public void onFinishedWriting(boolean z) {
                                    String str4;
                                    if (VideoMuxer.this.mNeedAbort) {
                                        return;
                                    }
                                    d1a.e("VideoMuxer: ", "变声处理：end_time" + System.currentTimeMillis());
                                    String str5 = videoMuxerData.getCachePath() + "/" + m1a.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_mix_fake_voice.aac";
                                    try {
                                        File file2 = new File(new File(str5).getParent());
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                    } catch (Exception e) {
                                        d1a.g(e);
                                    }
                                    zz9 zz9Var2 = new zz9();
                                    int b = (int) y1a.b(str3);
                                    ArrayList arrayList = new ArrayList();
                                    if (b > 0) {
                                        arrayList.add(new AudioPlayData(str3, 0, b, 1.0f));
                                    }
                                    boolean startCombineAudio = VideoMuxer.this.startCombineAudio(arrayList, str5, zz9Var2);
                                    if (startCombineAudio) {
                                        videoMuxerData.setFinalAudioPath(str5);
                                        str4 = "audiocombineresult:" + startCombineAudio + "audiopath:" + str5 + ",isVideoDone:" + VideoMuxer.this.misVideoCombineDone;
                                    } else {
                                        fx9.a("v_log_audio_mixer_error", zz9Var2.e, null);
                                        str4 = "mixtureAACFileList fail" + zz9Var2.e;
                                    }
                                    d1a.e("VideoMuxer", str4);
                                    VideoMuxer.this.combineAudioFinish();
                                }

                                @Override // com.baidu.tieba.yz9, com.baidu.tieba.xz9
                                public void onProgressChanged(int i, double d, long j) {
                                }

                                @Override // com.baidu.tieba.yz9, com.baidu.tieba.xz9
                                public void onTrackEnd(int i) {
                                }
                            });
                            if (VideoMuxer.this.mNeedAbort) {
                                return;
                            }
                            VideoMuxer.this.mSoundStreamFileWriter.D(videoMuxerData.getFakeVoiceTypes());
                            VideoMuxer.this.mSoundStreamFileWriter.I();
                            d1a.e("VideoMuxer: ", "变声处理：start_time" + System.currentTimeMillis());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            d1a.e("VideoMuxer: ", "onExceptionThrown: " + n1a.g(e));
                        }
                    } else {
                        fx9.a("v_log_audio_mixer_error", zz9Var.e, null);
                        str = "mixtureAACFileList fail" + zz9Var.e;
                    }
                }
                d1a.e("VideoMuxer", str);
                VideoMuxer.this.combineAudioFinish();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStartMux(VideoMuxerData videoMuxerData) {
        if (CheckUtils.checkDirectNext(videoMuxerData)) {
            if (i1a.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) i1a.c(videoMuxerData.getPhotoDataList(), 0);
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
            a0a.b("startMuxer", "checkVideoDirectNext");
            if (i1a.b(videoMuxerData.getPhotoDataList()) == 1) {
                onProgress(0, 100);
                onGenFilterVideoSuccess(((MultiMediaData) i1a.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
                } else if (!cy9.o(this.mMuxerData.getFakeVoiceTypes()) || isMute(buildTracks.get(0).multiMediaDataList)) {
                    combineAudio(buildTracks.get(0).multiMediaDataList, null);
                    return;
                } else {
                    processFakeVoice(buildTracks.get(0).multiMediaDataList, null);
                    return;
                }
            }
            ux9 audioMixDataFormMuxerData = getAudioMixDataFormMuxerData(this.mMuxerData, buildTracks);
            if (audioMixDataFormMuxerData != null && !i1a.e(audioMixDataFormMuxerData.c())) {
                vx9 vx9Var = new vx9(audioMixDataFormMuxerData);
                this.mAudioMixtureManager = vx9Var;
                vx9Var.q(this);
                this.mAudioMixtureManager.r();
                return;
            }
        } else if (i1a.b(videoMuxerData.getPhotoDataList()) != 1) {
            return;
        } else {
            videoMuxerData.setFinalAudioPath(((MultiMediaData) i1a.c(videoMuxerData.getPhotoDataList(), 0)).path);
            onProgress(1, 100);
        }
        combineAudioFinish();
    }

    private void resetProgress() {
        this.mLastVideoPercent = 0;
        this.mLastAudioPercent = 0;
        this.mLastAudioVideoPercent = 0;
        this.mRetryCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startCombineAudio(List<AudioPlayData> list, String str, zz9 zz9Var) {
        boolean z;
        boolean z2;
        List<AudioPlayData> list2;
        a0a.b("startCombineAudio", "拼接混合音频");
        VideoMuxerData videoMuxerData = this.mMuxerData;
        if (videoMuxerData == null) {
            return false;
        }
        boolean z3 = true;
        if (!i1a.e(list)) {
            for (AudioPlayData audioPlayData : list) {
                if (FileUtils.isExists(audioPlayData.audioPath)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        CheckUtils.syncMusicData(videoMuxerData);
        if (videoMuxerData != null && !i1a.e(videoMuxerData.getAudioPlayDataList())) {
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
                long f = o1a.f(videoMuxerData.getMuteAudioData().audioPath);
                videoMuxerData.getMuteAudioData().start = 0;
                videoMuxerData.getMuteAudioData().end = (int) f;
            }
            list.add(videoMuxerData.getMuteAudioData());
            list2 = list;
        }
        if (z3) {
            return z2 ? VLogMultiAudioMixer.mixtureAACFileList(list2, videoMuxerData.getAudioPlayDataList(), str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.6
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, zz9Var) : VLogMultiAudioMixer.mixtureAACFileList(list2, str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.7
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, zz9Var);
        } else if (z2) {
            return VLogMultiAudioMixer.mixtureAACFileList(videoMuxerData.getAudioPlayDataList(), str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.8
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, zz9Var);
        } else {
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0166, code lost:
        if (r1 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x016f, code lost:
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0171, code lost:
        r1.release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void themeVideo(List<MultiMediaDataTrack> list) {
        a0a.b("themeVideo", "视频处理开始");
        MediaExtractor mediaExtractor = null;
        if (i1a.e(this.mMuxerData.getPhotoDataList()) || this.mMuxerData.getCurrThemeEffect() == null) {
            notifyMuxerEnd(null);
            return;
        }
        ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(gx9.c().getContext(), list, null, gx9.c().f() + "/video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
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
        if (i1a.b(this.mMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) i1a.c(this.mMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1) {
                int frameRate = this.mMuxerData.getFrameRate();
                if (frameRate == 0) {
                    frameRate = 30;
                }
                try {
                    try {
                        mediaExtractor = n1a.b(multiMediaData.path);
                        int integer = mediaExtractor.getTrackFormat(n1a.f(mediaExtractor)).getInteger("frame-rate");
                        if (integer < frameRate) {
                            frameRate = integer;
                        }
                        this.mComposeThemeVideoModel.setFrameRate(frameRate);
                        d1a.j("startMuxer", "videoFrameRate : " + integer + " frameRate : " + frameRate);
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

    public void interruptProcess() {
        this.mNeedAbort = true;
        resetProgress();
        ComposeThemeVideoModel composeThemeVideoModel = this.mComposeThemeVideoModel;
        if (composeThemeVideoModel != null) {
            composeThemeVideoModel.interruptGenVideo();
        }
        vx9 vx9Var = this.mAudioMixtureManager;
        if (vx9Var != null) {
            vx9Var.i();
            this.mAudioMixtureManager.p();
        }
        a aVar = this.mAuidoVideoMuxer;
        if (aVar != null) {
            aVar.a();
        }
        jy9 jy9Var = this.mSoundStreamFileWriter;
        if (jy9Var != null) {
            jy9Var.J();
        }
    }

    @Override // com.baidu.tieba.vx9.b
    public void onAudioMixtureCancel() {
        d1a.j("VideoMuxer", "onAudioMixtureCancel");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    @Override // com.baidu.tieba.vx9.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAudioMixtureFail(String str) {
        String json;
        if (this.mNeedAbort) {
            return;
        }
        d1a.j("VideoMuxer", "onAudioMixtureFail:" + str);
        StringBuilder sb = new StringBuilder();
        if (this.mMuxerData != null) {
            if (i1a.e(this.mMuxerData.getAudioPlayDataList())) {
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
                if (i1a.e(this.mMuxerData.getPhotoDataList())) {
                    sb.append("videopaths:");
                    for (MultiMediaData multiMediaData : this.mMuxerData.getPhotoDataList()) {
                        sb.append(multiMediaData.path);
                    }
                } else {
                    sb.append("no video info");
                }
            }
            sb.append(json);
            if (i1a.e(this.mMuxerData.getPhotoDataList())) {
            }
        }
        fx9.a("v_log_audio_mixer_error", "onAudioMixtureFail:" + str + ",inputinfo:" + sb.toString(), null);
        combineAudioFinish();
    }

    @Override // com.baidu.tieba.vx9.b
    public void onAudioMixtureProgress(int i) {
        if (this.mNeedAbort) {
            return;
        }
        postAuidoMuxProgress(i);
    }

    @Override // com.baidu.tieba.vx9.b
    public void onAudioMixtureSuccess(tx9 tx9Var) {
        if (this.mNeedAbort) {
            return;
        }
        if (tx9Var == null || !FileUtils.checkFile(tx9Var.h())) {
            d1a.j("VideoMuxer", "onAudioMixtureSuccess file not exit");
            fx9.a("v_log_audio_mixer_error", "onAudioMixtureSuccess file not exit", null);
        } else {
            d1a.j("VideoMuxer", "onAudioMixtureSuccess path:" + tx9Var.h() + "audioduration:" + o1a.c(tx9Var.h(), 0));
            this.mMuxerData.setFinalAudioPath(tx9Var.h());
        }
        combineAudioFinish();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0503a
    public void onAudioVideoMuxerCancel() {
        onGenFilterVideoAbort();
        d1a.e("VideoMuxer", "onMuxerCancel");
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0503a
    public void onAudioVideoMuxerFail(zz9 zz9Var) {
        notifyMuxerFail(zz9Var);
        if (zz9Var != null) {
            d1a.e("VideoMuxer", "onMuxerMusicFail:" + zz9Var.e);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0503a
    public void onAudioVideoMuxerFinish(String str) {
        d1a.e("VideoMuxer", "onMuxerMusicFinish:" + str);
        if (FileUtils.checkFile(str)) {
            d1a.e("VideoMuxer", "notifyMuxerMusicEnd+notifyMuxerEnd:" + str);
            notifyMuxerMusicEnd();
        } else {
            str = this.mMuxerData.getVideoPath();
        }
        notifyMuxerEnd(str);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoAbort() {
        kx9 kx9Var = this.mListener;
        if (kx9Var != null) {
            kx9Var.d();
            resetProgress();
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoFail(int i, String str) {
        int i2;
        if (this.mNeedAbort) {
            return;
        }
        if (i != -100 || (i2 = this.mRetryCount) >= MAX_RETRY_COUNT) {
            a0a.b("onGenFilterVideoFail", "视频处理-失败");
            zz9 zz9Var = new zz9();
            zz9Var.a = 24;
            zz9Var.c = "error_mixtrue";
            zz9Var.b = true;
            zz9Var.e = "视频预处理合成处理视频特效合成失败 checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData) + " --- " + str;
            vx9 vx9Var = this.mAudioMixtureManager;
            if (vx9Var != null) {
                vx9Var.i();
            }
            notifyMuxerFail(zz9Var);
            return;
        }
        this.mRetryCount = i2 + 1;
        a0a.b("onGenFilterVideoFail", "视频处理-失败重试 ：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
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
            fx9.a("v_log_retry_inner_multimedia_processor", str + ",视频处理-失败重试 ：" + this.mRetryCount, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoProgress(int i) {
        onProgress(0, i);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoRecordError(int i, String str) {
        notifyMuxerEnd(null);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoSuccess(String str) {
        a0a.b("onGenFilterVideoSuccess", "视频处理-成功");
        this.misVideoCombineDone = true;
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            return;
        }
        this.mMuxerData.setVideoPath(str);
        d1a.j("VideoMuxer", "videocombinedone" + this.mIsAudioCombineDone + ",videopath:" + str + "videoduration:" + o1a.c(str, 1) + "," + o1a.b(str) + "," + y1a.f(str));
        if (this.mIsAudioCombineDone) {
            combineVA(str);
        }
    }

    public void setListener(kx9 kx9Var) {
        this.mListener = kx9Var;
    }

    public void startMuxer(VideoMuxerData videoMuxerData) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (videoMuxerData != null && (FileUtils.isExists(videoMuxerData.getVideoPath()) || CheckUtils.checkAllFileExist(videoMuxerData, sb))) {
            this.mStartTime = System.currentTimeMillis();
            kx9 kx9Var = this.mListener;
            if (kx9Var != null) {
                kx9Var.b();
            }
            this.mMuxerData = videoMuxerData;
            this.mIsUseNewAudioMixture = this.mMuxerData.isUserNewAudioMixture();
            try {
                fx9.a("v_log_codec_h265_support", n1a.m(MimeTypes.VIDEO_H265) != null ? "yes" : "no", null);
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
        zz9 zz9Var = new zz9();
        zz9Var.a = 24;
        zz9Var.c = "error_mixtrue";
        zz9Var.b = true;
        StringBuilder sb2 = new StringBuilder();
        if (videoMuxerData == null) {
            str = "开始合成，合成信息丢失:muxerData为空";
        } else {
            sb2.append("开始合成，合成信息丢失,videopath:" + videoMuxerData.getVideoPath());
            sb2.append(",photoDataList size:" + i1a.b(videoMuxerData.getPhotoDataList()));
            sb2.append(",draftName:" + videoMuxerData.getDraftName());
            sb2.append(",muxerFrom:" + videoMuxerData.getMuxerFrom());
            str = ",checkerror:" + sb.toString();
        }
        sb2.append(str);
        zz9Var.e = sb2.toString();
        notifyMuxerFail(zz9Var);
    }

    public void startMuxerForJson(String str) {
        try {
            startMuxer((VideoMuxerData) new Gson().fromJson(str, (Class<Object>) VideoMuxerData.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
