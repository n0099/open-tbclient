package com.baidu.ugc.editvideo.muxer;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tieba.a6b;
import com.baidu.tieba.b6b;
import com.baidu.tieba.bab;
import com.baidu.tieba.c6b;
import com.baidu.tieba.e8b;
import com.baidu.tieba.eab;
import com.baidu.tieba.f8b;
import com.baidu.tieba.g8b;
import com.baidu.tieba.h6b;
import com.baidu.tieba.i6b;
import com.baidu.tieba.j9b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.o9b;
import com.baidu.tieba.p6b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.t9b;
import com.baidu.tieba.u9b;
import com.baidu.tieba.y5b;
import com.baidu.tieba.z5b;
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
/* loaded from: classes9.dex */
public class VideoMuxer implements b6b.b, OnGenFilterVideoListener, a.InterfaceC0561a {
    public static final String FILTER_TEMP_DIR_PREFIX = "video_addfilter_";
    public static int MAX_RETRY_COUNT = 2;
    public b6b mAudioMixtureManager;
    public long mAudioStartTime;
    public a mAuidoVideoMuxer;
    public ComposeThemeVideoModel mComposeThemeVideoModel;
    public volatile boolean mIsAudioCombineDone;
    public boolean mIsUseNewAudioMixture;
    public int mLastAudioPercent;
    public int mLastAudioVideoPercent;
    public int mLastVideoPercent;
    public q5b mListener;
    public volatile VideoMuxerData mMuxerData;
    public volatile boolean mNeedAbort = false;
    public int mRetryCount;
    public p6b mSoundStreamFileWriter;
    public long mStartTime;
    public volatile boolean misVideoCombineDone;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface MuxerProgressType {
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_AUDIO_VIDEO = 2;
        public static final int TYPE_VIDEO = 0;
    }

    private List<y5b> buildAudioDataList(List<MultiMediaData> list) {
        if (o9b.e(list)) {
            return null;
        }
        VideoMuxerData videoMuxerData = this.mMuxerData;
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = 0; i < list.size(); i++) {
            MultiMediaData multiMediaData = list.get(i);
            int i2 = multiMediaData.type;
            if (i2 == 0) {
                int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) o9b.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                int i3 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd == 0) {
                    multiMediaDataRealEnd = (int) multiMediaData.end;
                }
                arrayList.add(new y5b(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
            } else if (i2 == 1) {
                if (multiMediaData.volume > 0.0f) {
                    z = false;
                }
                int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (((float) multiMediaData.start) + (((float) MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) o9b.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) * multiMediaData.mSpeed)) : 0;
                String str = multiMediaData.path;
                int i4 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd2 == 0) {
                    multiMediaDataRealEnd2 = (int) multiMediaData.end;
                }
                arrayList.add(new y5b(new AudioPlayData(str, i4, multiMediaDataRealEnd2, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
            }
        }
        if (z) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AudioPlayData> buildAudioPlayDataList(List<MultiMediaData> list) {
        if (o9b.e(list)) {
            return null;
        }
        VideoMuxerData videoMuxerData = this.mMuxerData;
        if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
            videoMuxerData.setCachePath(m5b.c().a() + "/tempaudio");
            j9b.e("VideoMuxer", "have not set audioCachePath");
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
                int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) o9b.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                int i3 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd == 0) {
                    multiMediaDataRealEnd = (int) multiMediaData.end;
                }
                arrayList.add(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume));
            } else if (i2 == 1) {
                File file2 = new File(videoMuxerData.getCachePath(), s9b.b(multiMediaData.path));
                if (!file2.exists()) {
                    eab.c(multiMediaData.path, file2.getPath());
                }
                int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) o9b.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
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
        g8b.b("combineAudio", "音频拼接混合处理");
        this.mIsAudioCombineDone = false;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                StringBuilder sb;
                VideoMuxerData videoMuxerData = VideoMuxer.this.mMuxerData;
                if (videoMuxerData != null && videoMuxerData.getPhotoDataList() != null && videoMuxerData.getPhotoDataList().get(0) != null) {
                    List buildAudioPlayDataList = !o9b.e(list) ? VideoMuxer.this.buildAudioPlayDataList(list) : list2;
                    if (!o9b.e(buildAudioPlayDataList)) {
                        String str2 = videoMuxerData.getCachePath() + "/" + s9b.b(videoMuxerData.toString()) + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                        try {
                            File file = new File(new File(str2).getParent());
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                        } catch (Exception e) {
                            j9b.g(e);
                        }
                        f8b f8bVar = new f8b();
                        boolean startCombineAudio = VideoMuxer.this.startCombineAudio(buildAudioPlayDataList, str2, f8bVar);
                        g8b.b("combineAudio", "音频拼接混合处理-结果" + startCombineAudio);
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
                            l5b.a("v_log_audio_mixer_error", f8bVar.e, null);
                            sb = new StringBuilder();
                            sb.append("mixtureAACFileList fail");
                            sb.append(f8bVar.e);
                        }
                        str = sb.toString();
                    }
                    VideoMuxer.this.combineAudioFinish();
                }
                str = "origin data fomat error";
                j9b.e("VideoMuxer", str);
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
            bab.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.4
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
        g8b.b("onGenFilterVideoFail", "视频处理-失败重试-combineAudioFinish：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        this.mIsAudioCombineDone = true;
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineVA(String str) {
        String str2;
        g8b.b("combineVA", "音视频混合");
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            str2 = "muxerMusic:abort";
        } else if (this.mMuxerData != null) {
            j9b.e("VideoMuxer", "combineVA:" + str);
            if (this.mMuxerData != null && !FileUtils.checkFile(this.mMuxerData.getFinalAudioPath()) && this.mMuxerData.getMuteAudioData() != null) {
                this.mMuxerData.setFinalAudioPath(this.mMuxerData.getMuteAudioData().audioPath);
            }
            if (!FileUtils.checkFile(this.mMuxerData.getFinalAudioPath())) {
                j9b.e("VideoMuxer", "combineVADone");
                notifyMuxerEnd(str);
                return;
            }
            if (this.mAuidoVideoMuxer == null) {
                a aVar = new a();
                this.mAuidoVideoMuxer = aVar;
                aVar.a(this);
            }
            j9b.e("VideoMuxer", "muxmusic:vp:" + this.mMuxerData.getVideoPath() + ",ap:" + this.mMuxerData.getFinalAudioPath());
            this.mAuidoVideoMuxer.a(this.mMuxerData);
            return;
        } else {
            str2 = "muxerMusic:mMuxerData == null";
        }
        j9b.e("VideoMuxer", str2);
    }

    private void doChangeAuidoSpeed(final List<MultiMediaData> list) {
        if (o9b.e(list)) {
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
                        int multiMediaDataRealEnd = VideoMuxer.this.mMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) o9b.c(VideoMuxer.this.mMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                        if (multiMediaDataRealEnd == 0) {
                            multiMediaDataRealEnd = (int) multiMediaData.end;
                        }
                        arrayList.add(new AudioPlayData("", (int) multiMediaData.start, multiMediaDataRealEnd, multiMediaData.volume));
                    } else if (i2 == 1) {
                        File file = new File(FileUtils.removeExtention(multiMediaData.path) + "_audio.aac");
                        if (!file.exists()) {
                            eab.c(multiMediaData.path, file.getPath());
                        }
                        arrayList.add(new AudioPlayData(file.getPath(), (int) multiMediaData.start, (int) multiMediaData.end, multiMediaData.volume, multiMediaData.getCurrentSpeed()));
                    }
                }
                h6b h6bVar = new h6b();
                h6bVar.h(arrayList);
                h6bVar.g(new h6b.b() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1.1
                    public void onCancel() {
                        VideoMuxer.this.onGenFilterVideoAbort();
                    }

                    @Override // com.baidu.tieba.h6b.b
                    public void onFailed(String str) {
                        f8b f8bVar = new f8b();
                        f8bVar.e = "audioeditorerror:" + str;
                        VideoMuxer.this.notifyMuxerFail(f8bVar);
                    }

                    public void onProgress(int i3) {
                    }

                    @Override // com.baidu.tieba.h6b.b
                    public void onSuccess(List<AudioPlayData> list2) {
                        if (i6b.o(VideoMuxer.this.mMuxerData.getFakeVoiceTypes())) {
                            VideoMuxer.this.processFakeVoice(null, list2);
                        } else {
                            VideoMuxer.this.combineAudio(null, list2);
                        }
                    }
                });
                h6bVar.i();
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
            ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(m5b.c().getContext(), this.mMuxerData.getVideoPath(), new File(this.mMuxerData.getVideoPath()).getParent() + File.separator + FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
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

    private a6b getAudioMixDataFormMuxerData(VideoMuxerData videoMuxerData, List<MultiMediaDataTrack> list) {
        if (videoMuxerData == null || o9b.e(list)) {
            return null;
        }
        CheckUtils.syncMusicData(videoMuxerData);
        List<y5b> buildAudioDataList = buildAudioDataList(list.get(0).multiMediaDataList);
        ArrayList arrayList = new ArrayList();
        if (!o9b.e(buildAudioDataList)) {
            c6b c6bVar = new c6b(buildAudioDataList);
            c6bVar.c(videoMuxerData.getFakeVoiceTypes());
            arrayList.add(c6bVar);
        }
        if (!o9b.e(videoMuxerData.getAudioPlayDataList())) {
            ArrayList arrayList2 = new ArrayList();
            for (AudioPlayData audioPlayData : videoMuxerData.getAudioPlayDataList()) {
                arrayList2.add(new y5b(audioPlayData));
            }
            arrayList.add(new c6b(arrayList2));
        }
        if (!o9b.e(videoMuxerData.getAudioPlayTrackDataList())) {
            CheckUtils.checkAudioPlayTrackDataList(videoMuxerData.getAudioPlayTrackDataList(), videoMuxerData);
            for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
                if (audioPlayTrackData != null && !o9b.e(audioPlayTrackData.mAudioPlayDataList)) {
                    ArrayList arrayList3 = new ArrayList();
                    for (AudioPlayData audioPlayData2 : audioPlayTrackData.mAudioPlayDataList) {
                        arrayList3.add(new y5b(audioPlayData2));
                    }
                    arrayList.add(new c6b(arrayList3));
                }
            }
        }
        a6b a6bVar = new a6b(arrayList);
        if (!TextUtils.isEmpty(videoMuxerData.getCachePath())) {
            a6bVar.d(videoMuxerData.getCachePath() + "/");
        }
        a6bVar.e(new y5b(videoMuxerData.getMuteAudioData()));
        return a6bVar;
    }

    private boolean isMute(List<MultiMediaData> list) {
        if (o9b.e(list)) {
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
        g8b.b("notifyMuxerEnd", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime));
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
                    g8b.a("muxer_publish_log", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime) + ", duration : " + i + ", bitrate : " + mediaMetadataRetriever.extractMetadata(20) + ", hevc : " + this.mMuxerData.isCurrentEncodeHevcVideo());
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
                f8b f8bVar = new f8b();
                f8bVar.b = true;
                f8bVar.a = 24;
                f8bVar.c = "error_mixtrue";
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
                    sb.append(u9b.f(this.mMuxerData.getVideoPath()));
                    sb.append(" , video size=");
                    sb.append(FileUtils.getFileSize(this.mMuxerData.getVideoPath()));
                }
                if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getFinalAudioPath())) {
                    sb.append(" , audio path=");
                    sb.append(this.mMuxerData.getFinalAudioPath());
                    sb.append(" , audio 时长=");
                    sb.append(u9b.f(this.mMuxerData.getFinalAudioPath()));
                    sb.append(" , audio size=");
                    sb.append(FileUtils.getFileSize(this.mMuxerData.getFinalAudioPath()));
                }
                sb.append(" , needAbort=");
                sb.append(this.mNeedAbort);
                sb.append(" , trace=");
                sb.append(t9b.g(new RuntimeException()));
                f8bVar.e = sb.toString();
                this.mListener.f(f8bVar.a().toString());
            } else {
                onProgress(2, 100);
                this.mListener.e(str);
            }
        }
        resetProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMuxerFail(f8b f8bVar) {
        resetProgress();
        if (this.mListener != null) {
            String str = null;
            if (f8bVar != null) {
                if (this.mMuxerData != null && this.mMuxerData.getCurrThemeEffect() != null && !TextUtils.isEmpty(f8bVar.e)) {
                    f8bVar.e += ",themeName : " + this.mMuxerData.getCurrThemeEffect().name;
                }
                f8bVar.e += ",checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData);
                f8bVar.e += ",checkVideoDirectNext : " + CheckUtils.checkVideoDirectNext(this.mMuxerData);
                f8bVar.e += ",needAbort : " + this.mNeedAbort;
                str = f8bVar.a().toString();
            }
            this.mListener.f(str);
        }
    }

    private void notifyMuxerMusicEnd() {
        q5b q5bVar = this.mListener;
        if (q5bVar != null) {
            q5bVar.c();
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
        g8b.b("onProgress", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAuidoMuxProgress(final int i) {
        bab.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.9
            @Override // java.lang.Runnable
            public void run() {
                if (VideoMuxer.this.mListener != null) {
                    j9b.j("VideoMuxer", "audioProgress:" + i);
                    int i2 = i;
                    if (i2 <= 100) {
                        VideoMuxer.this.onProgress(1, i2);
                    }
                }
            }
        });
    }

    private void preMuxKSongRepair(final String str) {
        final MultiMediaData multiMediaData = (MultiMediaData) o9b.c(this.mMuxerData.getPhotoDataList(), 0);
        if (multiMediaData == null || !FileUtils.isExists(multiMediaData.path)) {
            return;
        }
        if (!this.mMuxerData.isKSongHuaTongMode()) {
            new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    String str2 = new File(multiMediaData.path).getParentFile().getAbsoluteFile() + File.separator + System.currentTimeMillis() + "_audio_repair.mp4";
                    j9b.e("VideoMuxer: ", "K歌修音处理， out_put_path = " + str2);
                    boolean j = eab.j(sb, str, multiMediaData.path, str2, 0L, -1L);
                    if (j) {
                        multiMediaData.path = str2;
                    }
                    j9b.e("VideoMuxer: ", "K歌修音处理合成结果：" + j);
                    if (!VideoMuxer.this.mNeedAbort || VideoMuxer.this.mListener == null) {
                        bab.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2.1
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
        g8b.b("processFakeVoice", "变声处理");
        this.mIsAudioCombineDone = false;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                final VideoMuxerData videoMuxerData = VideoMuxer.this.mMuxerData;
                if (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || videoMuxerData.getPhotoDataList().get(0) == null) {
                    str = "origin data fomat error";
                } else {
                    List buildAudioPlayDataList = !o9b.e(list) ? VideoMuxer.this.buildAudioPlayDataList(list) : list2;
                    if (o9b.e(buildAudioPlayDataList)) {
                        VideoMuxer.this.combineAudioFinish();
                        return;
                    }
                    if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                        videoMuxerData.setCachePath(m5b.c().a() + "/tempaudio");
                        j9b.e("VideoMuxer", "have not set audioCachePath");
                    }
                    File file = new File(videoMuxerData.getCachePath());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str2 = videoMuxerData.getCachePath() + "/" + s9b.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_for_fake_voice.aac";
                    f8b f8bVar = new f8b();
                    if (videoMuxerData.isKSongHuaTongMode()) {
                        if (buildAudioPlayDataList == null) {
                            buildAudioPlayDataList = new ArrayList();
                        }
                        buildAudioPlayDataList.clear();
                        buildAudioPlayDataList.add(new AudioPlayData(VideoMuxer.this.mMuxerData.getKSongHuaTongRecordPath(), 0, u9b.f(VideoMuxer.this.mMuxerData.getKSongHuaTongRecordPath()), 1.0f));
                    }
                    if (VLogMultiAudioMixer.mixtureAACFileList(buildAudioPlayDataList, str2, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.1
                        @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                        public void mixerProgress(int i) {
                        }
                    }, f8bVar)) {
                        final String str3 = videoMuxerData.getCachePath() + "/" + s9b.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_fake_voice.aac";
                        try {
                            VideoMuxer.this.mSoundStreamFileWriter = new p6b(str2, str3, videoMuxerData.getFakeVoiceTypes());
                            VideoMuxer.this.mSoundStreamFileWriter.S(new e8b() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.2
                                @Override // com.baidu.tieba.e8b, com.baidu.tieba.d8b
                                public void onExceptionThrown(String str4) {
                                    j9b.e("VideoMuxer: ", "onExceptionThrown: " + str4);
                                    if (VideoMuxer.this.mNeedAbort) {
                                        return;
                                    }
                                    VideoMuxer.this.combineAudioFinish();
                                }

                                @Override // com.baidu.tieba.e8b
                                public void onFinishedWriting(boolean z) {
                                    String str4;
                                    if (VideoMuxer.this.mNeedAbort) {
                                        return;
                                    }
                                    j9b.e("VideoMuxer: ", "变声处理：end_time" + System.currentTimeMillis());
                                    String str5 = videoMuxerData.getCachePath() + "/" + s9b.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_mix_fake_voice.aac";
                                    try {
                                        File file2 = new File(new File(str5).getParent());
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                    } catch (Exception e) {
                                        j9b.g(e);
                                    }
                                    f8b f8bVar2 = new f8b();
                                    int b = (int) eab.b(str3);
                                    ArrayList arrayList = new ArrayList();
                                    if (b > 0) {
                                        arrayList.add(new AudioPlayData(str3, 0, b, 1.0f));
                                    }
                                    boolean startCombineAudio = VideoMuxer.this.startCombineAudio(arrayList, str5, f8bVar2);
                                    if (startCombineAudio) {
                                        videoMuxerData.setFinalAudioPath(str5);
                                        str4 = "audiocombineresult:" + startCombineAudio + "audiopath:" + str5 + ",isVideoDone:" + VideoMuxer.this.misVideoCombineDone;
                                    } else {
                                        l5b.a("v_log_audio_mixer_error", f8bVar2.e, null);
                                        str4 = "mixtureAACFileList fail" + f8bVar2.e;
                                    }
                                    j9b.e("VideoMuxer", str4);
                                    VideoMuxer.this.combineAudioFinish();
                                }

                                @Override // com.baidu.tieba.e8b, com.baidu.tieba.d8b
                                public void onProgressChanged(int i, double d, long j) {
                                }

                                @Override // com.baidu.tieba.e8b, com.baidu.tieba.d8b
                                public void onTrackEnd(int i) {
                                }
                            });
                            if (VideoMuxer.this.mNeedAbort) {
                                return;
                            }
                            VideoMuxer.this.mSoundStreamFileWriter.D(videoMuxerData.getFakeVoiceTypes());
                            VideoMuxer.this.mSoundStreamFileWriter.I();
                            j9b.e("VideoMuxer: ", "变声处理：start_time" + System.currentTimeMillis());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            j9b.e("VideoMuxer: ", "onExceptionThrown: " + t9b.g(e));
                        }
                    } else {
                        l5b.a("v_log_audio_mixer_error", f8bVar.e, null);
                        str = "mixtureAACFileList fail" + f8bVar.e;
                    }
                }
                j9b.e("VideoMuxer", str);
                VideoMuxer.this.combineAudioFinish();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStartMux(VideoMuxerData videoMuxerData) {
        if (CheckUtils.checkDirectNext(videoMuxerData)) {
            if (o9b.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) o9b.c(videoMuxerData.getPhotoDataList(), 0);
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
            g8b.b("startMuxer", "checkVideoDirectNext");
            if (o9b.b(videoMuxerData.getPhotoDataList()) == 1) {
                onProgress(0, 100);
                onGenFilterVideoSuccess(((MultiMediaData) o9b.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
                } else if (!i6b.o(this.mMuxerData.getFakeVoiceTypes()) || isMute(buildTracks.get(0).multiMediaDataList)) {
                    combineAudio(buildTracks.get(0).multiMediaDataList, null);
                    return;
                } else {
                    processFakeVoice(buildTracks.get(0).multiMediaDataList, null);
                    return;
                }
            }
            a6b audioMixDataFormMuxerData = getAudioMixDataFormMuxerData(this.mMuxerData, buildTracks);
            if (audioMixDataFormMuxerData != null && !o9b.e(audioMixDataFormMuxerData.c())) {
                b6b b6bVar = new b6b(audioMixDataFormMuxerData);
                this.mAudioMixtureManager = b6bVar;
                b6bVar.q(this);
                this.mAudioMixtureManager.r();
                return;
            }
        } else if (o9b.b(videoMuxerData.getPhotoDataList()) != 1) {
            return;
        } else {
            videoMuxerData.setFinalAudioPath(((MultiMediaData) o9b.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
    public boolean startCombineAudio(List<AudioPlayData> list, String str, f8b f8bVar) {
        boolean z;
        boolean z2;
        List<AudioPlayData> list2;
        g8b.b("startCombineAudio", "拼接混合音频");
        VideoMuxerData videoMuxerData = this.mMuxerData;
        if (videoMuxerData == null) {
            return false;
        }
        boolean z3 = true;
        if (!o9b.e(list)) {
            for (AudioPlayData audioPlayData : list) {
                if (FileUtils.isExists(audioPlayData.audioPath)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        CheckUtils.syncMusicData(videoMuxerData);
        if (videoMuxerData != null && !o9b.e(videoMuxerData.getAudioPlayDataList())) {
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
                long f = u9b.f(videoMuxerData.getMuteAudioData().audioPath);
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
            }, f8bVar) : VLogMultiAudioMixer.mixtureAACFileList(list2, str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.7
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, f8bVar);
        } else if (z2) {
            return VLogMultiAudioMixer.mixtureAACFileList(videoMuxerData.getAudioPlayDataList(), str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.8
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, f8bVar);
        } else {
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0169, code lost:
        if (r1 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0172, code lost:
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0174, code lost:
        r1.release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void themeVideo(List<MultiMediaDataTrack> list) {
        g8b.b("themeVideo", "视频处理开始");
        MediaExtractor mediaExtractor = null;
        if (o9b.e(this.mMuxerData.getPhotoDataList()) || this.mMuxerData.getCurrThemeEffect() == null) {
            notifyMuxerEnd(null);
            return;
        }
        ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(m5b.c().getContext(), list, null, m5b.c().f() + "/video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
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
        if (o9b.b(this.mMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) o9b.c(this.mMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1) {
                int frameRate = this.mMuxerData.getFrameRate();
                if (frameRate == 0) {
                    frameRate = 30;
                }
                try {
                    try {
                        mediaExtractor = t9b.b(multiMediaData.path);
                        int integer = mediaExtractor.getTrackFormat(t9b.f(mediaExtractor)).getInteger("frame-rate");
                        if (integer < frameRate) {
                            frameRate = integer;
                        }
                        this.mComposeThemeVideoModel.setFrameRate(frameRate);
                        j9b.j("startMuxer", "videoFrameRate : " + integer + " frameRate : " + frameRate);
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
        b6b b6bVar = this.mAudioMixtureManager;
        if (b6bVar != null) {
            b6bVar.i();
            this.mAudioMixtureManager.p();
        }
        a aVar = this.mAuidoVideoMuxer;
        if (aVar != null) {
            aVar.a();
        }
        p6b p6bVar = this.mSoundStreamFileWriter;
        if (p6bVar != null) {
            p6bVar.J();
        }
    }

    @Override // com.baidu.tieba.b6b.b
    public void onAudioMixtureCancel() {
        j9b.j("VideoMuxer", "onAudioMixtureCancel");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    @Override // com.baidu.tieba.b6b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAudioMixtureFail(String str) {
        String json;
        if (this.mNeedAbort) {
            return;
        }
        j9b.j("VideoMuxer", "onAudioMixtureFail:" + str);
        StringBuilder sb = new StringBuilder();
        if (this.mMuxerData != null) {
            if (o9b.e(this.mMuxerData.getAudioPlayDataList())) {
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
                if (o9b.e(this.mMuxerData.getPhotoDataList())) {
                    sb.append("videopaths:");
                    for (MultiMediaData multiMediaData : this.mMuxerData.getPhotoDataList()) {
                        sb.append(multiMediaData.path);
                    }
                } else {
                    sb.append("no video info");
                }
            }
            sb.append(json);
            if (o9b.e(this.mMuxerData.getPhotoDataList())) {
            }
        }
        l5b.a("v_log_audio_mixer_error", "onAudioMixtureFail:" + str + ",inputinfo:" + sb.toString(), null);
        combineAudioFinish();
    }

    @Override // com.baidu.tieba.b6b.b
    public void onAudioMixtureProgress(int i) {
        if (this.mNeedAbort) {
            return;
        }
        postAuidoMuxProgress(i);
    }

    @Override // com.baidu.tieba.b6b.b
    public void onAudioMixtureSuccess(z5b z5bVar) {
        if (this.mNeedAbort) {
            return;
        }
        if (z5bVar == null || !FileUtils.checkFile(z5bVar.h())) {
            j9b.j("VideoMuxer", "onAudioMixtureSuccess file not exit");
            l5b.a("v_log_audio_mixer_error", "onAudioMixtureSuccess file not exit", null);
        } else {
            j9b.j("VideoMuxer", "onAudioMixtureSuccess path:" + z5bVar.h() + "audioduration:" + u9b.c(z5bVar.h(), 0));
            this.mMuxerData.setFinalAudioPath(z5bVar.h());
        }
        combineAudioFinish();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0561a
    public void onAudioVideoMuxerCancel() {
        onGenFilterVideoAbort();
        j9b.e("VideoMuxer", "onMuxerCancel");
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0561a
    public void onAudioVideoMuxerFail(f8b f8bVar) {
        notifyMuxerFail(f8bVar);
        if (f8bVar != null) {
            j9b.e("VideoMuxer", "onMuxerMusicFail:" + f8bVar.e);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0561a
    public void onAudioVideoMuxerFinish(String str) {
        j9b.e("VideoMuxer", "onMuxerMusicFinish:" + str);
        if (FileUtils.checkFile(str)) {
            j9b.e("VideoMuxer", "notifyMuxerMusicEnd+notifyMuxerEnd:" + str);
            notifyMuxerMusicEnd();
        } else {
            str = this.mMuxerData.getVideoPath();
        }
        notifyMuxerEnd(str);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoAbort() {
        q5b q5bVar = this.mListener;
        if (q5bVar != null) {
            q5bVar.d();
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
            g8b.b("onGenFilterVideoFail", "视频处理-失败");
            f8b f8bVar = new f8b();
            f8bVar.a = 24;
            f8bVar.c = "error_mixtrue";
            f8bVar.b = true;
            f8bVar.e = "视频预处理合成处理视频特效合成失败 checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData) + " --- " + str;
            b6b b6bVar = this.mAudioMixtureManager;
            if (b6bVar != null) {
                b6bVar.i();
            }
            notifyMuxerFail(f8bVar);
            return;
        }
        this.mRetryCount = i2 + 1;
        g8b.b("onGenFilterVideoFail", "视频处理-失败重试 ：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
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
            l5b.a("v_log_retry_inner_multimedia_processor", str + ",视频处理-失败重试 ：" + this.mRetryCount, null);
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
        g8b.b("onGenFilterVideoSuccess", "视频处理-成功");
        this.misVideoCombineDone = true;
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            return;
        }
        this.mMuxerData.setVideoPath(str);
        j9b.j("VideoMuxer", "videocombinedone" + this.mIsAudioCombineDone + ",videopath:" + str + "videoduration:" + u9b.c(str, 1) + "," + u9b.b(str) + "," + eab.f(str));
        if (this.mIsAudioCombineDone) {
            combineVA(str);
        }
    }

    public void setListener(q5b q5bVar) {
        this.mListener = q5bVar;
    }

    public void startMuxer(VideoMuxerData videoMuxerData) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (videoMuxerData != null && (FileUtils.isExists(videoMuxerData.getVideoPath()) || CheckUtils.checkAllFileExist(videoMuxerData, sb))) {
            this.mStartTime = System.currentTimeMillis();
            q5b q5bVar = this.mListener;
            if (q5bVar != null) {
                q5bVar.b();
            }
            this.mMuxerData = videoMuxerData;
            this.mIsUseNewAudioMixture = this.mMuxerData.isUserNewAudioMixture();
            try {
                l5b.a("v_log_codec_h265_support", t9b.m(MimeTypes.VIDEO_H265) != null ? "yes" : "no", null);
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
        f8b f8bVar = new f8b();
        f8bVar.a = 24;
        f8bVar.c = "error_mixtrue";
        f8bVar.b = true;
        StringBuilder sb2 = new StringBuilder();
        if (videoMuxerData == null) {
            str = "开始合成，合成信息丢失:muxerData为空";
        } else {
            sb2.append("开始合成，合成信息丢失,videopath:" + videoMuxerData.getVideoPath());
            sb2.append(",photoDataList size:" + o9b.b(videoMuxerData.getPhotoDataList()));
            sb2.append(",draftName:" + videoMuxerData.getDraftName());
            sb2.append(",muxerFrom:" + videoMuxerData.getMuxerFrom());
            str = ",checkerror:" + sb.toString();
        }
        sb2.append(str);
        f8bVar.e = sb2.toString();
        notifyMuxerFail(f8bVar);
    }

    public void startMuxerForJson(String str) {
        try {
            startMuxer((VideoMuxerData) new Gson().fromJson(str, (Class<Object>) VideoMuxerData.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
