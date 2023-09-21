package com.baidu.ugc.editvideo.muxer;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tieba.akb;
import com.baidu.tieba.cgb;
import com.baidu.tieba.dgb;
import com.baidu.tieba.fkb;
import com.baidu.tieba.ghb;
import com.baidu.tieba.hgb;
import com.baidu.tieba.jkb;
import com.baidu.tieba.kkb;
import com.baidu.tieba.lkb;
import com.baidu.tieba.pgb;
import com.baidu.tieba.qgb;
import com.baidu.tieba.rgb;
import com.baidu.tieba.sgb;
import com.baidu.tieba.skb;
import com.baidu.tieba.tgb;
import com.baidu.tieba.vib;
import com.baidu.tieba.vkb;
import com.baidu.tieba.wib;
import com.baidu.tieba.xib;
import com.baidu.tieba.ygb;
import com.baidu.tieba.zgb;
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
public class VideoMuxer implements sgb.b, OnGenFilterVideoListener, a.InterfaceC0547a {
    public static final String FILTER_TEMP_DIR_PREFIX = "video_addfilter_";
    public static int MAX_RETRY_COUNT = 2;
    public sgb mAudioMixtureManager;
    public long mAudioStartTime;
    public a mAuidoVideoMuxer;
    public ComposeThemeVideoModel mComposeThemeVideoModel;
    public volatile boolean mIsAudioCombineDone;
    public boolean mIsUseNewAudioMixture;
    public int mLastAudioPercent;
    public int mLastAudioVideoPercent;
    public int mLastVideoPercent;
    public hgb mListener;
    public volatile VideoMuxerData mMuxerData;
    public volatile boolean mNeedAbort = false;
    public int mRetryCount;
    public ghb mSoundStreamFileWriter;
    public long mStartTime;
    public volatile boolean misVideoCombineDone;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface MuxerProgressType {
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_AUDIO_VIDEO = 2;
        public static final int TYPE_VIDEO = 0;
    }

    private List<pgb> buildAudioDataList(List<MultiMediaData> list) {
        if (fkb.e(list)) {
            return null;
        }
        VideoMuxerData videoMuxerData = this.mMuxerData;
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = 0; i < list.size(); i++) {
            MultiMediaData multiMediaData = list.get(i);
            int i2 = multiMediaData.type;
            if (i2 == 0) {
                int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) fkb.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                int i3 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd == 0) {
                    multiMediaDataRealEnd = (int) multiMediaData.end;
                }
                arrayList.add(new pgb(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
            } else if (i2 == 1) {
                if (multiMediaData.volume > 0.0f) {
                    z = false;
                }
                int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (((float) multiMediaData.start) + (((float) MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) fkb.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) * multiMediaData.mSpeed)) : 0;
                String str = multiMediaData.path;
                int i4 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd2 == 0) {
                    multiMediaDataRealEnd2 = (int) multiMediaData.end;
                }
                arrayList.add(new pgb(new AudioPlayData(str, i4, multiMediaDataRealEnd2, multiMediaData.volume, multiMediaData.getCurrentSpeed())));
            }
        }
        if (z) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AudioPlayData> buildAudioPlayDataList(List<MultiMediaData> list) {
        if (fkb.e(list)) {
            return null;
        }
        VideoMuxerData videoMuxerData = this.mMuxerData;
        if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
            videoMuxerData.setCachePath(dgb.c().a() + "/tempaudio");
            akb.e("VideoMuxer", "have not set audioCachePath");
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
                int multiMediaDataRealEnd = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) fkb.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                int i3 = (int) multiMediaData.start;
                if (multiMediaDataRealEnd == 0) {
                    multiMediaDataRealEnd = (int) multiMediaData.end;
                }
                arrayList.add(new AudioPlayData("", i3, multiMediaDataRealEnd, multiMediaData.volume));
            } else if (i2 == 1) {
                File file2 = new File(videoMuxerData.getCachePath(), jkb.b(multiMediaData.path));
                if (!file2.exists()) {
                    vkb.c(multiMediaData.path, file2.getPath());
                }
                int multiMediaDataRealEnd2 = videoMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) fkb.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
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
        xib.b("combineAudio", "音频拼接混合处理");
        this.mIsAudioCombineDone = false;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                StringBuilder sb;
                VideoMuxerData videoMuxerData = VideoMuxer.this.mMuxerData;
                if (videoMuxerData != null && videoMuxerData.getPhotoDataList() != null && videoMuxerData.getPhotoDataList().get(0) != null) {
                    List buildAudioPlayDataList = !fkb.e(list) ? VideoMuxer.this.buildAudioPlayDataList(list) : list2;
                    if (!fkb.e(buildAudioPlayDataList)) {
                        String str2 = videoMuxerData.getCachePath() + "/" + jkb.b(videoMuxerData.toString()) + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                        try {
                            File file = new File(new File(str2).getParent());
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                        } catch (Exception e) {
                            akb.g(e);
                        }
                        wib wibVar = new wib();
                        boolean startCombineAudio = VideoMuxer.this.startCombineAudio(buildAudioPlayDataList, str2, wibVar);
                        xib.b("combineAudio", "音频拼接混合处理-结果" + startCombineAudio);
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
                            cgb.a("v_log_audio_mixer_error", wibVar.e, null);
                            sb = new StringBuilder();
                            sb.append("mixtureAACFileList fail");
                            sb.append(wibVar.e);
                        }
                        str = sb.toString();
                    }
                    VideoMuxer.this.combineAudioFinish();
                }
                str = "origin data fomat error";
                akb.e("VideoMuxer", str);
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
            skb.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.4
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
        xib.b("onGenFilterVideoFail", "视频处理-失败重试-combineAudioFinish：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
        this.mIsAudioCombineDone = true;
        this.mMuxerData.setRecordConfigEncodeHevcVideo(false);
        themeVideo(buildTracks(this.mMuxerData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineVA(String str) {
        String str2;
        xib.b("combineVA", "音视频混合");
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            str2 = "muxerMusic:abort";
        } else if (this.mMuxerData != null) {
            akb.e("VideoMuxer", "combineVA:" + str);
            if (this.mMuxerData != null && !FileUtils.checkFile(this.mMuxerData.getFinalAudioPath()) && this.mMuxerData.getMuteAudioData() != null) {
                this.mMuxerData.setFinalAudioPath(this.mMuxerData.getMuteAudioData().audioPath);
            }
            if (!FileUtils.checkFile(this.mMuxerData.getFinalAudioPath())) {
                akb.e("VideoMuxer", "combineVADone");
                notifyMuxerEnd(str);
                return;
            }
            if (this.mAuidoVideoMuxer == null) {
                a aVar = new a();
                this.mAuidoVideoMuxer = aVar;
                aVar.a(this);
            }
            akb.e("VideoMuxer", "muxmusic:vp:" + this.mMuxerData.getVideoPath() + ",ap:" + this.mMuxerData.getFinalAudioPath());
            this.mAuidoVideoMuxer.a(this.mMuxerData);
            return;
        } else {
            str2 = "muxerMusic:mMuxerData == null";
        }
        akb.e("VideoMuxer", str2);
    }

    private void doChangeAuidoSpeed(final List<MultiMediaData> list) {
        if (fkb.e(list)) {
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
                        int multiMediaDataRealEnd = VideoMuxer.this.mMuxerData.getCurrThemeEffect() != null ? (int) (multiMediaData.start + MultiDataSourceUtil.getMultiMediaDataRealEnd((MediaTrack) fkb.c(VideoMuxer.this.mMuxerData.getCurrThemeEffect().mediaTracks, 0), i)) : 0;
                        if (multiMediaDataRealEnd == 0) {
                            multiMediaDataRealEnd = (int) multiMediaData.end;
                        }
                        arrayList.add(new AudioPlayData("", (int) multiMediaData.start, multiMediaDataRealEnd, multiMediaData.volume));
                    } else if (i2 == 1) {
                        File file = new File(FileUtils.removeExtention(multiMediaData.path) + "_audio.aac");
                        if (!file.exists()) {
                            vkb.c(multiMediaData.path, file.getPath());
                        }
                        arrayList.add(new AudioPlayData(file.getPath(), (int) multiMediaData.start, (int) multiMediaData.end, multiMediaData.volume, multiMediaData.getCurrentSpeed()));
                    }
                }
                ygb ygbVar = new ygb();
                ygbVar.h(arrayList);
                ygbVar.g(new ygb.b() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.1.1
                    public void onCancel() {
                        VideoMuxer.this.onGenFilterVideoAbort();
                    }

                    @Override // com.baidu.tieba.ygb.b
                    public void onFailed(String str) {
                        wib wibVar = new wib();
                        wibVar.e = "audioeditorerror:" + str;
                        VideoMuxer.this.notifyMuxerFail(wibVar);
                    }

                    public void onProgress(int i3) {
                    }

                    @Override // com.baidu.tieba.ygb.b
                    public void onSuccess(List<AudioPlayData> list2) {
                        if (zgb.o(VideoMuxer.this.mMuxerData.getFakeVoiceTypes())) {
                            VideoMuxer.this.processFakeVoice(null, list2);
                        } else {
                            VideoMuxer.this.combineAudio(null, list2);
                        }
                    }
                });
                ygbVar.i();
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
            ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(dgb.c().getContext(), this.mMuxerData.getVideoPath(), new File(this.mMuxerData.getVideoPath()).getParent() + File.separator + FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
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

    private rgb getAudioMixDataFormMuxerData(VideoMuxerData videoMuxerData, List<MultiMediaDataTrack> list) {
        if (videoMuxerData == null || fkb.e(list)) {
            return null;
        }
        CheckUtils.syncMusicData(videoMuxerData);
        List<pgb> buildAudioDataList = buildAudioDataList(list.get(0).multiMediaDataList);
        ArrayList arrayList = new ArrayList();
        if (!fkb.e(buildAudioDataList)) {
            tgb tgbVar = new tgb(buildAudioDataList);
            tgbVar.c(videoMuxerData.getFakeVoiceTypes());
            arrayList.add(tgbVar);
        }
        if (!fkb.e(videoMuxerData.getAudioPlayDataList())) {
            ArrayList arrayList2 = new ArrayList();
            for (AudioPlayData audioPlayData : videoMuxerData.getAudioPlayDataList()) {
                arrayList2.add(new pgb(audioPlayData));
            }
            arrayList.add(new tgb(arrayList2));
        }
        if (!fkb.e(videoMuxerData.getAudioPlayTrackDataList())) {
            CheckUtils.checkAudioPlayTrackDataList(videoMuxerData.getAudioPlayTrackDataList(), videoMuxerData);
            for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
                if (audioPlayTrackData != null && !fkb.e(audioPlayTrackData.mAudioPlayDataList)) {
                    ArrayList arrayList3 = new ArrayList();
                    for (AudioPlayData audioPlayData2 : audioPlayTrackData.mAudioPlayDataList) {
                        arrayList3.add(new pgb(audioPlayData2));
                    }
                    arrayList.add(new tgb(arrayList3));
                }
            }
        }
        rgb rgbVar = new rgb(arrayList);
        if (!TextUtils.isEmpty(videoMuxerData.getCachePath())) {
            rgbVar.d(videoMuxerData.getCachePath() + "/");
        }
        rgbVar.e(new pgb(videoMuxerData.getMuteAudioData()));
        return rgbVar;
    }

    private boolean isMute(List<MultiMediaData> list) {
        if (fkb.e(list)) {
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
        xib.b("notifyMuxerEnd", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime));
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
                    xib.a("muxer_publish_log", "视频合成结束 cost ：" + (System.currentTimeMillis() - this.mStartTime) + ", duration : " + i + ", bitrate : " + mediaMetadataRetriever.extractMetadata(20) + ", hevc : " + this.mMuxerData.isCurrentEncodeHevcVideo());
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
                wib wibVar = new wib();
                wibVar.b = true;
                wibVar.a = 24;
                wibVar.c = "error_mixtrue";
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
                    sb.append(lkb.f(this.mMuxerData.getVideoPath()));
                    sb.append(" , video size=");
                    sb.append(FileUtils.getFileSize(this.mMuxerData.getVideoPath()));
                }
                if (this.mMuxerData != null && !TextUtils.isEmpty(this.mMuxerData.getFinalAudioPath())) {
                    sb.append(" , audio path=");
                    sb.append(this.mMuxerData.getFinalAudioPath());
                    sb.append(" , audio 时长=");
                    sb.append(lkb.f(this.mMuxerData.getFinalAudioPath()));
                    sb.append(" , audio size=");
                    sb.append(FileUtils.getFileSize(this.mMuxerData.getFinalAudioPath()));
                }
                sb.append(" , needAbort=");
                sb.append(this.mNeedAbort);
                sb.append(" , trace=");
                sb.append(kkb.g(new RuntimeException()));
                wibVar.e = sb.toString();
                this.mListener.f(wibVar.a().toString());
            } else {
                onProgress(2, 100);
                this.mListener.e(str);
            }
        }
        resetProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMuxerFail(wib wibVar) {
        resetProgress();
        if (this.mListener != null) {
            String str = null;
            if (wibVar != null) {
                if (this.mMuxerData != null && this.mMuxerData.getCurrThemeEffect() != null && !TextUtils.isEmpty(wibVar.e)) {
                    wibVar.e += ",themeName : " + this.mMuxerData.getCurrThemeEffect().name;
                }
                wibVar.e += ",checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData);
                wibVar.e += ",checkVideoDirectNext : " + CheckUtils.checkVideoDirectNext(this.mMuxerData);
                wibVar.e += ",needAbort : " + this.mNeedAbort;
                str = wibVar.a().toString();
            }
            this.mListener.f(str);
        }
    }

    private void notifyMuxerMusicEnd() {
        hgb hgbVar = this.mListener;
        if (hgbVar != null) {
            hgbVar.c();
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
        xib.b("onProgress", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAuidoMuxProgress(final int i) {
        skb.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.9
            @Override // java.lang.Runnable
            public void run() {
                if (VideoMuxer.this.mListener != null) {
                    akb.j("VideoMuxer", "audioProgress:" + i);
                    int i2 = i;
                    if (i2 <= 100) {
                        VideoMuxer.this.onProgress(1, i2);
                    }
                }
            }
        });
    }

    private void preMuxKSongRepair(final String str) {
        final MultiMediaData multiMediaData = (MultiMediaData) fkb.c(this.mMuxerData.getPhotoDataList(), 0);
        if (multiMediaData == null || !FileUtils.isExists(multiMediaData.path)) {
            return;
        }
        if (!this.mMuxerData.isKSongHuaTongMode()) {
            new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    String str2 = new File(multiMediaData.path).getParentFile().getAbsoluteFile() + File.separator + System.currentTimeMillis() + "_audio_repair.mp4";
                    akb.e("VideoMuxer: ", "K歌修音处理， out_put_path = " + str2);
                    boolean j = vkb.j(sb, str, multiMediaData.path, str2, 0L, -1L);
                    if (j) {
                        multiMediaData.path = str2;
                    }
                    akb.e("VideoMuxer: ", "K歌修音处理合成结果：" + j);
                    if (!VideoMuxer.this.mNeedAbort || VideoMuxer.this.mListener == null) {
                        skb.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.2.1
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
        xib.b("processFakeVoice", "变声处理");
        this.mIsAudioCombineDone = false;
        new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                final VideoMuxerData videoMuxerData = VideoMuxer.this.mMuxerData;
                if (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || videoMuxerData.getPhotoDataList().get(0) == null) {
                    str = "origin data fomat error";
                } else {
                    List buildAudioPlayDataList = !fkb.e(list) ? VideoMuxer.this.buildAudioPlayDataList(list) : list2;
                    if (fkb.e(buildAudioPlayDataList)) {
                        VideoMuxer.this.combineAudioFinish();
                        return;
                    }
                    if (TextUtils.isEmpty(videoMuxerData.getCachePath())) {
                        videoMuxerData.setCachePath(dgb.c().a() + "/tempaudio");
                        akb.e("VideoMuxer", "have not set audioCachePath");
                    }
                    File file = new File(videoMuxerData.getCachePath());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str2 = videoMuxerData.getCachePath() + "/" + jkb.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_for_fake_voice.aac";
                    wib wibVar = new wib();
                    if (videoMuxerData.isKSongHuaTongMode()) {
                        if (buildAudioPlayDataList == null) {
                            buildAudioPlayDataList = new ArrayList();
                        }
                        buildAudioPlayDataList.clear();
                        buildAudioPlayDataList.add(new AudioPlayData(VideoMuxer.this.mMuxerData.getKSongHuaTongRecordPath(), 0, lkb.f(VideoMuxer.this.mMuxerData.getKSongHuaTongRecordPath()), 1.0f));
                    }
                    if (VLogMultiAudioMixer.mixtureAACFileList(buildAudioPlayDataList, str2, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.1
                        @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                        public void mixerProgress(int i) {
                        }
                    }, wibVar)) {
                        final String str3 = videoMuxerData.getCachePath() + "/" + jkb.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_fake_voice.aac";
                        try {
                            VideoMuxer.this.mSoundStreamFileWriter = new ghb(str2, str3, videoMuxerData.getFakeVoiceTypes());
                            VideoMuxer.this.mSoundStreamFileWriter.S(new vib() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.5.2
                                @Override // com.baidu.tieba.vib, com.baidu.tieba.uib
                                public void onExceptionThrown(String str4) {
                                    akb.e("VideoMuxer: ", "onExceptionThrown: " + str4);
                                    if (VideoMuxer.this.mNeedAbort) {
                                        return;
                                    }
                                    VideoMuxer.this.combineAudioFinish();
                                }

                                @Override // com.baidu.tieba.vib
                                public void onFinishedWriting(boolean z) {
                                    String str4;
                                    if (VideoMuxer.this.mNeedAbort) {
                                        return;
                                    }
                                    akb.e("VideoMuxer: ", "变声处理：end_time" + System.currentTimeMillis());
                                    String str5 = videoMuxerData.getCachePath() + "/" + jkb.b(videoMuxerData.toString()) + System.currentTimeMillis() + "_mix_fake_voice.aac";
                                    try {
                                        File file2 = new File(new File(str5).getParent());
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                    } catch (Exception e) {
                                        akb.g(e);
                                    }
                                    wib wibVar2 = new wib();
                                    int b = (int) vkb.b(str3);
                                    ArrayList arrayList = new ArrayList();
                                    if (b > 0) {
                                        arrayList.add(new AudioPlayData(str3, 0, b, 1.0f));
                                    }
                                    boolean startCombineAudio = VideoMuxer.this.startCombineAudio(arrayList, str5, wibVar2);
                                    if (startCombineAudio) {
                                        videoMuxerData.setFinalAudioPath(str5);
                                        str4 = "audiocombineresult:" + startCombineAudio + "audiopath:" + str5 + ",isVideoDone:" + VideoMuxer.this.misVideoCombineDone;
                                    } else {
                                        cgb.a("v_log_audio_mixer_error", wibVar2.e, null);
                                        str4 = "mixtureAACFileList fail" + wibVar2.e;
                                    }
                                    akb.e("VideoMuxer", str4);
                                    VideoMuxer.this.combineAudioFinish();
                                }

                                @Override // com.baidu.tieba.vib, com.baidu.tieba.uib
                                public void onProgressChanged(int i, double d, long j) {
                                }

                                @Override // com.baidu.tieba.vib, com.baidu.tieba.uib
                                public void onTrackEnd(int i) {
                                }
                            });
                            if (VideoMuxer.this.mNeedAbort) {
                                return;
                            }
                            VideoMuxer.this.mSoundStreamFileWriter.D(videoMuxerData.getFakeVoiceTypes());
                            VideoMuxer.this.mSoundStreamFileWriter.I();
                            akb.e("VideoMuxer: ", "变声处理：start_time" + System.currentTimeMillis());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            akb.e("VideoMuxer: ", "onExceptionThrown: " + kkb.g(e));
                        }
                    } else {
                        cgb.a("v_log_audio_mixer_error", wibVar.e, null);
                        str = "mixtureAACFileList fail" + wibVar.e;
                    }
                }
                akb.e("VideoMuxer", str);
                VideoMuxer.this.combineAudioFinish();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStartMux(VideoMuxerData videoMuxerData) {
        if (CheckUtils.checkDirectNext(videoMuxerData)) {
            if (fkb.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) fkb.c(videoMuxerData.getPhotoDataList(), 0);
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
            xib.b("startMuxer", "checkVideoDirectNext");
            if (fkb.b(videoMuxerData.getPhotoDataList()) == 1) {
                onProgress(0, 100);
                onGenFilterVideoSuccess(((MultiMediaData) fkb.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
                } else if (!zgb.o(this.mMuxerData.getFakeVoiceTypes()) || isMute(buildTracks.get(0).multiMediaDataList)) {
                    combineAudio(buildTracks.get(0).multiMediaDataList, null);
                    return;
                } else {
                    processFakeVoice(buildTracks.get(0).multiMediaDataList, null);
                    return;
                }
            }
            rgb audioMixDataFormMuxerData = getAudioMixDataFormMuxerData(this.mMuxerData, buildTracks);
            if (audioMixDataFormMuxerData != null && !fkb.e(audioMixDataFormMuxerData.c())) {
                sgb sgbVar = new sgb(audioMixDataFormMuxerData);
                this.mAudioMixtureManager = sgbVar;
                sgbVar.q(this);
                this.mAudioMixtureManager.r();
                return;
            }
        } else if (fkb.b(videoMuxerData.getPhotoDataList()) != 1) {
            return;
        } else {
            videoMuxerData.setFinalAudioPath(((MultiMediaData) fkb.c(videoMuxerData.getPhotoDataList(), 0)).path);
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
    public boolean startCombineAudio(List<AudioPlayData> list, String str, wib wibVar) {
        boolean z;
        boolean z2;
        List<AudioPlayData> list2;
        xib.b("startCombineAudio", "拼接混合音频");
        VideoMuxerData videoMuxerData = this.mMuxerData;
        if (videoMuxerData == null) {
            return false;
        }
        boolean z3 = true;
        if (!fkb.e(list)) {
            for (AudioPlayData audioPlayData : list) {
                if (FileUtils.isExists(audioPlayData.audioPath)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        CheckUtils.syncMusicData(videoMuxerData);
        if (videoMuxerData != null && !fkb.e(videoMuxerData.getAudioPlayDataList())) {
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
                long f = lkb.f(videoMuxerData.getMuteAudioData().audioPath);
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
            }, wibVar) : VLogMultiAudioMixer.mixtureAACFileList(list2, str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.7
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, wibVar);
        } else if (z2) {
            return VLogMultiAudioMixer.mixtureAACFileList(videoMuxerData.getAudioPlayDataList(), str, videoMuxerData.getCachePath(), new VLogMultiAudioMixer.MultiAudioMixerListener() { // from class: com.baidu.ugc.editvideo.muxer.VideoMuxer.8
                @Override // com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.MultiAudioMixerListener
                public void mixerProgress(int i) {
                    VideoMuxer.this.postAuidoMuxProgress(i);
                }
            }, wibVar);
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
        xib.b("themeVideo", "视频处理开始");
        MediaExtractor mediaExtractor = null;
        if (fkb.e(this.mMuxerData.getPhotoDataList()) || this.mMuxerData.getCurrThemeEffect() == null) {
            notifyMuxerEnd(null);
            return;
        }
        ComposeThemeVideoModel composeThemeVideoModel = new ComposeThemeVideoModel(dgb.c().getContext(), list, null, dgb.c().f() + "/video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
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
        if (fkb.b(this.mMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) fkb.c(this.mMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1) {
                int frameRate = this.mMuxerData.getFrameRate();
                if (frameRate == 0) {
                    frameRate = 30;
                }
                try {
                    try {
                        mediaExtractor = kkb.b(multiMediaData.path);
                        int integer = mediaExtractor.getTrackFormat(kkb.f(mediaExtractor)).getInteger("frame-rate");
                        if (integer < frameRate) {
                            frameRate = integer;
                        }
                        this.mComposeThemeVideoModel.setFrameRate(frameRate);
                        akb.j("startMuxer", "videoFrameRate : " + integer + " frameRate : " + frameRate);
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
        sgb sgbVar = this.mAudioMixtureManager;
        if (sgbVar != null) {
            sgbVar.i();
            this.mAudioMixtureManager.p();
        }
        a aVar = this.mAuidoVideoMuxer;
        if (aVar != null) {
            aVar.a();
        }
        ghb ghbVar = this.mSoundStreamFileWriter;
        if (ghbVar != null) {
            ghbVar.J();
        }
    }

    @Override // com.baidu.tieba.sgb.b
    public void onAudioMixtureCancel() {
        akb.j("VideoMuxer", "onAudioMixtureCancel");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    @Override // com.baidu.tieba.sgb.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAudioMixtureFail(String str) {
        String json;
        if (this.mNeedAbort) {
            return;
        }
        akb.j("VideoMuxer", "onAudioMixtureFail:" + str);
        StringBuilder sb = new StringBuilder();
        if (this.mMuxerData != null) {
            if (fkb.e(this.mMuxerData.getAudioPlayDataList())) {
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
                if (fkb.e(this.mMuxerData.getPhotoDataList())) {
                    sb.append("videopaths:");
                    for (MultiMediaData multiMediaData : this.mMuxerData.getPhotoDataList()) {
                        sb.append(multiMediaData.path);
                    }
                } else {
                    sb.append("no video info");
                }
            }
            sb.append(json);
            if (fkb.e(this.mMuxerData.getPhotoDataList())) {
            }
        }
        cgb.a("v_log_audio_mixer_error", "onAudioMixtureFail:" + str + ",inputinfo:" + sb.toString(), null);
        combineAudioFinish();
    }

    @Override // com.baidu.tieba.sgb.b
    public void onAudioMixtureProgress(int i) {
        if (this.mNeedAbort) {
            return;
        }
        postAuidoMuxProgress(i);
    }

    @Override // com.baidu.tieba.sgb.b
    public void onAudioMixtureSuccess(qgb qgbVar) {
        if (this.mNeedAbort) {
            return;
        }
        if (qgbVar == null || !FileUtils.checkFile(qgbVar.h())) {
            akb.j("VideoMuxer", "onAudioMixtureSuccess file not exit");
            cgb.a("v_log_audio_mixer_error", "onAudioMixtureSuccess file not exit", null);
        } else {
            akb.j("VideoMuxer", "onAudioMixtureSuccess path:" + qgbVar.h() + "audioduration:" + lkb.c(qgbVar.h(), 0));
            this.mMuxerData.setFinalAudioPath(qgbVar.h());
        }
        combineAudioFinish();
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0547a
    public void onAudioVideoMuxerCancel() {
        onGenFilterVideoAbort();
        akb.e("VideoMuxer", "onMuxerCancel");
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0547a
    public void onAudioVideoMuxerFail(wib wibVar) {
        notifyMuxerFail(wibVar);
        if (wibVar != null) {
            akb.e("VideoMuxer", "onMuxerMusicFail:" + wibVar.e);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.muxer.a.InterfaceC0547a
    public void onAudioVideoMuxerFinish(String str) {
        akb.e("VideoMuxer", "onMuxerMusicFinish:" + str);
        if (FileUtils.checkFile(str)) {
            akb.e("VideoMuxer", "notifyMuxerMusicEnd+notifyMuxerEnd:" + str);
            notifyMuxerMusicEnd();
        } else {
            str = this.mMuxerData.getVideoPath();
        }
        notifyMuxerEnd(str);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.OnGenFilterVideoListener
    public void onGenFilterVideoAbort() {
        hgb hgbVar = this.mListener;
        if (hgbVar != null) {
            hgbVar.d();
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
            xib.b("onGenFilterVideoFail", "视频处理-失败");
            wib wibVar = new wib();
            wibVar.a = 24;
            wibVar.c = "error_mixtrue";
            wibVar.b = true;
            wibVar.e = "视频预处理合成处理视频特效合成失败 checkAudioDirectNext : " + CheckUtils.checkAudioDirectNext(this.mMuxerData) + " --- " + str;
            sgb sgbVar = this.mAudioMixtureManager;
            if (sgbVar != null) {
                sgbVar.i();
            }
            notifyMuxerFail(wibVar);
            return;
        }
        this.mRetryCount = i2 + 1;
        xib.b("onGenFilterVideoFail", "视频处理-失败重试 ：retrycount:" + this.mRetryCount + ",mIsAudioCombineDone:" + this.misVideoCombineDone + ",mIsUseNewAudioMixture:" + this.mIsUseNewAudioMixture);
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
            cgb.a("v_log_retry_inner_multimedia_processor", str + ",视频处理-失败重试 ：" + this.mRetryCount, null);
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
        xib.b("onGenFilterVideoSuccess", "视频处理-成功");
        this.misVideoCombineDone = true;
        if (this.mNeedAbort) {
            onGenFilterVideoAbort();
            return;
        }
        this.mMuxerData.setVideoPath(str);
        akb.j("VideoMuxer", "videocombinedone" + this.mIsAudioCombineDone + ",videopath:" + str + "videoduration:" + lkb.c(str, 1) + "," + lkb.b(str) + "," + vkb.f(str));
        if (this.mIsAudioCombineDone) {
            combineVA(str);
        }
    }

    public void setListener(hgb hgbVar) {
        this.mListener = hgbVar;
    }

    public void startMuxer(VideoMuxerData videoMuxerData) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (videoMuxerData != null && (FileUtils.isExists(videoMuxerData.getVideoPath()) || CheckUtils.checkAllFileExist(videoMuxerData, sb))) {
            this.mStartTime = System.currentTimeMillis();
            hgb hgbVar = this.mListener;
            if (hgbVar != null) {
                hgbVar.b();
            }
            this.mMuxerData = videoMuxerData;
            this.mIsUseNewAudioMixture = this.mMuxerData.isUserNewAudioMixture();
            try {
                cgb.a("v_log_codec_h265_support", kkb.m(MimeTypes.VIDEO_H265) != null ? "yes" : "no", null);
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
        wib wibVar = new wib();
        wibVar.a = 24;
        wibVar.c = "error_mixtrue";
        wibVar.b = true;
        StringBuilder sb2 = new StringBuilder();
        if (videoMuxerData == null) {
            str = "开始合成，合成信息丢失:muxerData为空";
        } else {
            sb2.append("开始合成，合成信息丢失,videopath:" + videoMuxerData.getVideoPath());
            sb2.append(",photoDataList size:" + fkb.b(videoMuxerData.getPhotoDataList()));
            sb2.append(",draftName:" + videoMuxerData.getDraftName());
            sb2.append(",muxerFrom:" + videoMuxerData.getMuxerFrom());
            str = ",checkerror:" + sb.toString();
        }
        sb2.append(str);
        wibVar.e = sb2.toString();
        notifyMuxerFail(wibVar);
    }

    public void startMuxerForJson(String str) {
        try {
            startMuxer((VideoMuxerData) new Gson().fromJson(str, (Class<Object>) VideoMuxerData.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
