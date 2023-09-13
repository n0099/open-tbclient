package com.baidu.ugc.editvideo.editvideo.muxer;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.djb;
import com.baidu.tieba.ehb;
import com.baidu.tieba.fib;
import com.baidu.tieba.iib;
import com.baidu.tieba.sib;
import com.baidu.tieba.tib;
import com.baidu.tieba.xgb;
import com.baidu.tieba.ygb;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import com.coremedia.iso.boxes.Container;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.material.badge.BadgeDrawable;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AACTrackImpl;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class VLogMultiAudioMixer {
    public static final int PROGRESS_APPEND = 70;
    public static final int PROGRESS_BLANK = 10;
    public static final int PROGRESS_CALCULATE = 5;
    public static final int PROGRESS_ERROR = 100;
    public static final int PROGRESS_SUCCESS = 100;
    public static final int PROGRESS_UNIFY = 60;
    public static final String TAG = "VLogMultiAudioMixerTag";
    public static boolean isDebug;
    public static Object lockObject = new Object();

    /* loaded from: classes9.dex */
    public interface MultiAudioMixerListener {
        void mixerProgress(int i);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean appendAacList(List<AudioPlayData> list, String str, ehb ehbVar) throws IOException {
        Movie movie = new Movie();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            AudioPlayData audioPlayData = list.get(i);
            if (audioPlayData == null || !jointAACList(linkedList, audioPlayData.audioPath, audioPlayData.start, audioPlayData.end, ehbVar)) {
                return false;
            }
        }
        if (!linkedList.isEmpty()) {
            movie.addTrack(new AppendTrack((Track[]) linkedList.toArray(new Track[linkedList.size()])));
        }
        FileChannel fileChannel = null;
        File file = new File(str);
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            try {
                Container build = new DefaultMp4Builder().build(movie);
                fileChannel = new RandomAccessFile(String.format(str, new Object[0]), "rw").getChannel();
                build.writeContainer(fileChannel);
                if (fileChannel != null) {
                    fileChannel.close();
                }
                return true;
            } catch (Exception e) {
                ehbVar.e += e.getMessage();
                if (fileChannel != null) {
                    fileChannel.close();
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    public static void changeAACListBlankAudioPath(List<AudioPlayData> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            AudioPlayData audioPlayData = list.get(i);
            if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath)) {
                audioPlayData.audioPath = str;
                audioPlayData.volume = 1.0f;
            }
        }
    }

    public static void changeAACListBlankAudioPath(List<AudioPlayData> list, List<AudioPlayData> list2, String str) {
        for (int i = 0; i < list.size(); i++) {
            AudioPlayData audioPlayData = list.get(i);
            if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath)) {
                audioPlayData.audioPath = str;
                audioPlayData.volume = 1.0f;
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            AudioPlayData audioPlayData2 = list2.get(i2);
            if (audioPlayData2 != null && !FileUtils.isExists(audioPlayData2.audioPath)) {
                audioPlayData2.audioPath = str;
                audioPlayData2.volume = 1.0f;
            }
        }
    }

    public static boolean checkAACList(List<AudioPlayData> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAACList(List<AudioPlayData> list, List<AudioPlayData> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                return false;
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            if (list2.get(i2) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkListVolumeAllZero(List<AudioPlayData> list) {
        boolean z = true;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                AudioPlayData audioPlayData = list.get(i);
                if (audioPlayData != null && !TextUtils.isEmpty(audioPlayData.audioPath) && audioPlayData.volume != 0.0f) {
                    z = false;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[Catch: Exception -> 0x024a, TryCatch #0 {Exception -> 0x024a, blocks: (B:17:0x0040, B:19:0x0046, B:26:0x0060, B:31:0x00ab, B:33:0x00be, B:34:0x00db, B:45:0x010e, B:8:0x0014, B:9:0x0021, B:11:0x0027), top: B:79:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean clipAacFile(String str, String str2, long j, long j2, StringBuilder sb) {
        StringBuilder sb2;
        Track track;
        Movie movie;
        Movie movie2;
        String str3;
        long j3;
        long j4;
        String str4;
        String str5;
        String str6;
        String str7;
        long j5 = j2;
        try {
            try {
                track = new AACTrackImpl(new FileDataSourceImpl(str));
            } catch (Exception unused) {
                try {
                    Track track2 = null;
                    for (Track track3 : MovieCreator.build(str).getTracks()) {
                        if ("soun".equals(track3.getHandler())) {
                            track2 = track3;
                        }
                    }
                    track = track2;
                    if (track != null) {
                    }
                } catch (Exception e) {
                    e = e;
                    sb2 = sb;
                    if (sb2 != null) {
                        sb2.append(" mp4parser 音频合成过程中发生异常-1:");
                        sb2.append(e.getMessage());
                        sb2.append(" 详细信息-1 :");
                        sb2.append(sib.g(e));
                    }
                    e.printStackTrace();
                    return false;
                }
            }
        } catch (Exception unused2) {
        }
        if (track != null) {
            if (sb != null) {
                sb.append(" mp4parser 音频合成没有找到aac音频-1 ");
            }
            return false;
        }
        Movie movie3 = new Movie();
        long d = djb.d(track);
        long j6 = d - j5;
        long j7 = 0;
        long j8 = j6 <= 0 ? d : j6;
        if (j8 <= 0) {
            if (sb != null) {
                sb.append(" clipAacFile 音频合成过程中发生异常: ");
                sb.append(" 音频可用时长异常");
                sb.append(" 详细信息:");
                sb.append("canUseAacDuration:" + j8 + ",aacDuration" + d + ",audioStartTimeS" + j5);
            }
            return false;
        }
        String str8 = PreferencesUtil.RIGHT_MOUNT;
        String str9 = ",";
        String str10 = TAG;
        int i = 1;
        int i2 = (j > j8 ? 1 : (j == j8 ? 0 : -1));
        try {
            if (i2 < 0) {
                long e2 = djb.e(track, (j5 * 1.0d) / 1000.0d);
                long e3 = djb.e(track, ((j5 + j) * 1.0d) / 1000.0d);
                if (isDebug) {
                    Log.d(TAG, "muxAacMp4 videoDuration < aacDuration (aac from to)=[" + e2 + "," + e3 + PreferencesUtil.RIGHT_MOUNT);
                }
                movie3.addTrack(new AppendTrack(new CroppedTrack(track, e2, e3)));
                movie = movie3;
            } else if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                long j9 = 0;
                while (j9 < j) {
                    long j10 = j - j9;
                    if (j10 >= j8) {
                        if (j5 == j7) {
                            Track[] trackArr = new Track[i];
                            trackArr[0] = track;
                            arrayList.add(new AppendTrack(trackArr));
                            movie2 = movie3;
                            str6 = str10;
                            str7 = str8;
                            str3 = str9;
                            j3 = j8;
                            j4 = d;
                        } else {
                            j4 = d;
                            movie2 = movie3;
                            str6 = str10;
                            str7 = str8;
                            str3 = str9;
                            j3 = j8;
                            arrayList.add(new AppendTrack(new CroppedTrack(track, djb.e(track, (j5 * 1.0d) / 1000.0d), djb.e(track, (d * 1.0d) / 1000.0d))));
                        }
                        j9 += j3;
                        str4 = str6;
                        str5 = str7;
                    } else {
                        movie2 = movie3;
                        String str11 = str10;
                        String str12 = str8;
                        str3 = str9;
                        j3 = j8;
                        j4 = d;
                        long e4 = djb.e(track, (j5 * 1.0d) / 1000.0d);
                        long e5 = djb.e(track, ((j5 + j10) * 1.0d) / 1000.0d);
                        arrayList.add(new AppendTrack(new CroppedTrack(track, e4, e5)));
                        if (isDebug) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("muxAacMp4 videoDuration > aacDuration (audio from to)=[");
                            sb3.append(e4);
                            sb3.append(str3);
                            sb3.append(e5);
                            str5 = str12;
                            sb3.append(str5);
                            str4 = str11;
                            Log.d(str4, sb3.toString());
                        } else {
                            str4 = str11;
                            str5 = str12;
                        }
                        j9 += j10;
                    }
                    j5 = j2;
                    str8 = str5;
                    str9 = str3;
                    str10 = str4;
                    j8 = j3;
                    d = j4;
                    i = 1;
                    j7 = 0;
                    movie3 = movie2;
                }
                movie = movie3;
                movie.addTrack(new AppendTrack((Track[]) arrayList.toArray(new Track[arrayList.size()])));
            } else {
                movie = movie3;
                movie.addTrack(track);
                if (isDebug) {
                    Log.d(TAG, "muxAacMp4 videoDuration = aacDuration perfect！：）");
                }
            }
            Container build = new DefaultMp4Builder().build(movie);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            build.writeContainer(fileOutputStream.getChannel());
            fileOutputStream.close();
            long a = tib.a(str2);
            if (a <= 0) {
                if (sb != null) {
                    sb.append(", mp4parser afterDuration:");
                    sb.append(a);
                    return false;
                }
                return false;
            }
            return true;
        } catch (Exception e6) {
            e = e6;
            sb2 = sb;
            if (sb2 != null) {
            }
            e.printStackTrace();
            return false;
        }
    }

    public static int getBlankAudioDuration(List<AudioPlayData> list) {
        int i;
        if (list == null || list.size() == 0) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            AudioPlayData audioPlayData = list.get(i3);
            if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath) && (i = audioPlayData.end - audioPlayData.start) > i2) {
                i2 = i;
            }
        }
        return i2;
    }

    public static int getBlankAudioDuration(List<AudioPlayData> list, List<AudioPlayData> list2) {
        int i;
        int i2;
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            AudioPlayData audioPlayData = list.get(i4);
            if (audioPlayData != null && TextUtils.isEmpty(audioPlayData.audioPath) && (i2 = audioPlayData.end - audioPlayData.start) > i3) {
                i3 = i2;
            }
        }
        for (int i5 = 0; i5 < list2.size(); i5++) {
            AudioPlayData audioPlayData2 = list2.get(i5);
            if (audioPlayData2 != null && TextUtils.isEmpty(audioPlayData2.audioPath) && (i = audioPlayData2.end - audioPlayData2.start) > i3) {
                i3 = i;
            }
        }
        return i3;
    }

    public static boolean getNearestBlankAudioPath(List<List<AudioPlayData>> list, int i, String str, final ehb ehbVar) {
        StringBuilder sb;
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            sb = new StringBuilder();
            sb.append(ehbVar.e);
            sb.append("list 为空, or outPath 为空");
        } else {
            AudioPlayData audioPlayData = null;
            for (int i2 = 0; i2 < list.size(); i2++) {
                List<AudioPlayData> list2 = list.get(i2);
                if (list2 != null && list2.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list2.size()) {
                            break;
                        }
                        AudioPlayData audioPlayData2 = list2.get(i3);
                        if (audioPlayData2 != null && !TextUtils.isEmpty(audioPlayData2.audioPath)) {
                            int f = tib.f(audioPlayData2.audioPath);
                            audioPlayData2.realDuration = f;
                            if (f <= 0) {
                                continue;
                            } else if (f == i) {
                                audioPlayData = audioPlayData2;
                                break;
                            } else if (audioPlayData == null || Math.abs(audioPlayData.realDuration - i) > Math.abs(audioPlayData2.realDuration - i)) {
                                audioPlayData = audioPlayData2;
                            }
                        }
                        i3++;
                    }
                }
            }
            if (audioPlayData != null && audioPlayData.realDuration != 0) {
                iib.e(TAG, "blank 音频路径" + audioPlayData.audioPath);
                xgb.f e = xgb.e(audioPlayData.audioPath);
                if (e == null) {
                    e = new xgb.f();
                }
                final boolean[] zArr = {false};
                try {
                    xgb.l(audioPlayData.audioPath, str, e.a, e.b, 0.0f, e.c, 0.0f, (i * 1.0f) / 1000.0f, MimeTypes.AUDIO_MPEG.equals(e.d), new fib.a() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.4
                        @Override // com.baidu.tieba.fib.a
                        public void onCompletion() {
                            zArr[0] = true;
                            synchronized (VLogMultiAudioMixer.lockObject) {
                                VLogMultiAudioMixer.lockObject.notifyAll();
                            }
                        }

                        @Override // com.baidu.tieba.fib.a
                        public boolean onError(int i4, int i5, Object obj) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(",ffmpegerror:");
                            sb2.append(i4);
                            sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                            sb2.append(i5);
                            sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                            sb2.append(obj != null ? obj.toString() : "");
                            String sb3 = sb2.toString();
                            ehb ehbVar2 = ehb.this;
                            if (ehbVar2 != null) {
                                ehbVar2.e = ehb.this.e + sb3;
                            }
                            synchronized (VLogMultiAudioMixer.lockObject) {
                                VLogMultiAudioMixer.lockObject.notifyAll();
                            }
                            return false;
                        }

                        @Override // com.baidu.tieba.fib.a
                        public boolean onInfo(int i4, int i5, Object obj) {
                            iib.e(VLogMultiAudioMixer.TAG, " 进行blank 音量文件生成 进度i1 = " + i5);
                            return false;
                        }
                    });
                    iib.e("VideoMuxer", "resampledone");
                    try {
                        synchronized (lockObject) {
                            lockObject.wait();
                        }
                        if (zArr[0] && FileUtils.isExists(str)) {
                            iib.e(TAG, "blank volume 生成成功");
                            return true;
                        }
                        ehbVar.e += " ffmpeg 调整音量失败了-2 ";
                        return false;
                    } catch (InterruptedException e2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ehbVar.e);
                        sb2.append(e2);
                        ehbVar.e = sb2.toString() != null ? e2.getMessage() : " ffmpeg 调整音量失败了-1 ";
                        return false;
                    }
                } catch (Throwable th) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(ehbVar.e);
                    sb3.append(th);
                    ehbVar.e = sb3.toString() != null ? th.getMessage() : " ffmpeg 调整音量失败了-3 ";
                    return false;
                }
            }
            sb = new StringBuilder();
            sb.append(ehbVar.e);
            sb.append("音频源筛选为null or realDuration==0, closeTarget=");
            sb.append(audioPlayData);
        }
        ehbVar.e = sb.toString();
        return false;
    }

    public static boolean jointAACList(List<Track> list, String str, long j, long j2, ehb ehbVar) {
        Track track;
        long j3;
        long j4;
        long j5;
        long j6;
        String str2;
        iib.e("VideoMuxer", "jointAACList" + str);
        StringBuilder sb = new StringBuilder();
        char c = 0;
        if (list == null || TextUtils.isEmpty(str) || !new File(str).exists() || j > j2) {
            return false;
        }
        try {
            try {
                long f = tib.f(str);
                xgb.f e = xgb.e(str);
                sb.append(" , 音频duration=");
                sb.append(f);
                if (e != null) {
                    sb.append(" , 音频format : ");
                    sb.append(" , bitWidth=");
                    sb.append(e.c);
                    sb.append(" , channelCount=");
                    sb.append(e.b);
                    sb.append(" , mime=");
                    sb.append(e.d);
                    sb.append(" , sampleRate=");
                    sb.append(e.a);
                }
            } catch (Exception e2) {
                sb.append(sib.g(e2));
            }
            Track track2 = null;
            long j7 = j2 - j;
            try {
                track = new AACTrackImpl(new FileDataSourceImpl(str));
            } catch (Exception e3) {
                sb.append(" ,aacTrack error ");
                sb.append(sib.g(e3));
                for (Track track3 : MovieCreator.build(str).getTracks()) {
                    if (track3 != null && "soun".equals(track3.getHandler())) {
                        track2 = track3;
                    }
                }
                track = track2;
            }
            if (track == null) {
                if (ehbVar != null) {
                    ehbVar.e += " mp4parser 音频合成没有找到aac音频-2  " + sb.toString();
                }
                return false;
            }
            long d = djb.d(track);
            long j8 = d - j;
            if (j8 < 0) {
                j8 = d;
            }
            boolean z = isDebug;
            String str3 = TAG;
            if (z) {
                Log.d(TAG, "视频拼接- aacDuration" + d + " ,audioStartTimeS=" + j + " , canUseAacDuration" + j8);
            }
            int i = (j7 > j8 ? 1 : (j7 == j8 ? 0 : -1));
            if (i <= 0) {
                list.add(new AppendTrack(new CroppedTrack(track, djb.e(track, (j * 1.0d) / 1000.0d), djb.e(track, ((j + j7) * 1.0d) / 1000.0d))));
                return true;
            } else if (i <= 0) {
                list.add(new AppendTrack(track));
                if (isDebug) {
                    Log.d(TAG, "muxAacMp4 videoDuration = aacDuration perfect！：）");
                    return true;
                }
                return true;
            } else {
                long j9 = 0;
                while (j9 < j7) {
                    if (isDebug) {
                        Log.d(str3, "finalAudioDuration = " + j9 + " , targetDuration" + j7);
                    }
                    long j10 = j7 - j9;
                    if (j10 >= j8) {
                        long j11 = j9;
                        if (j == 0) {
                            j3 = j7;
                            Track[] trackArr = new Track[1];
                            trackArr[c] = track;
                            list.add(new AppendTrack(trackArr));
                            str2 = str3;
                            j4 = j8;
                            j5 = d;
                        } else {
                            j3 = j7;
                            str2 = str3;
                            j4 = j8;
                            j5 = d;
                            list.add(new AppendTrack(new CroppedTrack(track, djb.e(track, (j * 1.0d) / 1000.0d), djb.e(track, (d * 1.0d) / 1000.0d))));
                        }
                        j6 = j11 + j4;
                        str3 = str2;
                    } else {
                        long j12 = j9;
                        String str4 = str3;
                        j3 = j7;
                        j4 = j8;
                        j5 = d;
                        long e4 = djb.e(track, (j * 1.0d) / 1000.0d);
                        long e5 = djb.e(track, ((j + j10) * 1.0d) / 1000.0d);
                        list.add(new AppendTrack(new CroppedTrack(track, e4, e5)));
                        if (isDebug) {
                            str3 = str4;
                            Log.d(str3, "muxAacMp4 videoDuration > aacDuration (audio from to)=[" + e4 + "," + e5 + PreferencesUtil.RIGHT_MOUNT);
                        } else {
                            str3 = str4;
                        }
                        j6 = j12 + j10;
                    }
                    j9 = j6;
                    j8 = j4;
                    d = j5;
                    c = 0;
                    j7 = j3;
                }
                return true;
            }
        } catch (Exception e6) {
            if (ehbVar != null) {
                ehbVar.e += sb.toString() + " mp4parser 音频合成过程中发生异常-2:" + e6.getMessage() + " 详细信息：" + sib.g(e6);
            }
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean mixtureAACFileList(List<AudioPlayData> list, String str, String str2, MultiAudioMixerListener multiAudioMixerListener, ehb ehbVar) {
        StringBuilder sb;
        StringBuilder sb2;
        removeAndCorrectErrorData(list);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.addAll(list);
        if (!checkAACList(arrayList)) {
            ehbVar.e += "数据源错误-1";
            return false;
        }
        if (isDebug) {
            Log.d(TAG, "checkAACList ok");
        }
        int blankAudioDuration = getBlankAudioDuration(arrayList);
        iib.e("AudioMuxCostTime", "getBlankAudioDuration:" + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        if (multiAudioMixerListener != null) {
            iib.e(TAG, "UPROGRESS_CALCULATE 阶段，当前进度：5");
            multiAudioMixerListener.mixerProgress(5);
        }
        if (blankAudioDuration < 0) {
            ehbVar.e += "数据源错误-2";
            if (multiAudioMixerListener != null) {
                iib.e(TAG, "PROGRESS_ERROR 阶段 1，当前进度：100" + ehbVar.e);
                multiAudioMixerListener.mixerProgress(100);
            }
            return false;
        }
        if (blankAudioDuration == 0) {
            if (multiAudioMixerListener != null) {
                iib.e(TAG, "PROGRESS_BLANK 阶段--单list--blank 0，当前进度：10");
                multiAudioMixerListener.mixerProgress(10);
            }
            boolean updateAACListVolume = updateAACListVolume(arrayList, null, "", str2, 5, 60, multiAudioMixerListener, new StringBuilder());
            iib.e("AudioMuxCostTime", "updateAACListVolume:" + (System.currentTimeMillis() - currentTimeMillis2));
            long currentTimeMillis3 = System.currentTimeMillis();
            if (!updateAACListVolume) {
                ehbVar.e += sb2.toString();
                if (multiAudioMixerListener != null) {
                    iib.e(TAG, "PROGRESS_ERROR 阶段 2，当前进度：100" + ehbVar.e);
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
            if (multiAudioMixerListener != null) {
                iib.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                multiAudioMixerListener.mixerProgress(60);
            }
            if (isDebug) {
                Log.d(TAG, "updateAACListVolume pass");
            }
            try {
                boolean appendAacList = appendAacList(arrayList, str, ehbVar);
                iib.e("AudioMuxCostTime", "appendAacList:" + (System.currentTimeMillis() - currentTimeMillis3));
                if (multiAudioMixerListener != null) {
                    iib.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                    multiAudioMixerListener.mixerProgress(70);
                }
                if (isDebug) {
                    Log.d(TAG, "appendAacList " + appendAacList);
                }
                File file = new File(str);
                if (appendAacList && file.exists()) {
                    if (isDebug) {
                        Log.d(TAG, "appendAacList 拼接成功-文件路径：" + str + " , file size = " + file.length());
                    }
                    if (multiAudioMixerListener != null) {
                        iib.e(TAG, "PROGRESS_SUCCESS 阶段，当前进度：100");
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return true;
                }
                ehbVar.e += "拼接文件不存在-1";
                if (isDebug) {
                    Log.d(TAG, "appendAacList is not exists ");
                }
                if (multiAudioMixerListener != null) {
                    iib.e(TAG, "PROGRESS_ERROR 阶段 4，当前进度：100" + ehbVar.e);
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            } catch (IOException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(ehbVar.e);
                sb3.append(e);
                ehbVar.e = sb3.toString() != null ? e.getMessage() : "";
                if (multiAudioMixerListener != null) {
                    iib.e(TAG, "PROGRESS_ERROR 阶段 3，当前进度：100" + ehbVar.e);
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(list);
        String str3 = str2 + "/blank_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
        boolean nearestBlankAudioPath = getNearestBlankAudioPath(arrayList2, blankAudioDuration, str3, ehbVar);
        iib.c(TAG, "getNearestBlankAudioPath - 返回 " + nearestBlankAudioPath + " maxBlankDuration =" + blankAudioDuration);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("getNearestBlankAudioPath1:");
        sb4.append(System.currentTimeMillis() - currentTimeMillis2);
        iib.e("AudioMuxCostTime", sb4.toString());
        long currentTimeMillis4 = System.currentTimeMillis();
        File file2 = new File(str3);
        if (!nearestBlankAudioPath || !file2.exists()) {
            if (multiAudioMixerListener != null) {
                Log.d(TAG, "当前进度 ：100错误信息" + ehbVar.e);
                multiAudioMixerListener.mixerProgress(100);
                return false;
            }
            return false;
        }
        if (multiAudioMixerListener != null) {
            iib.e(TAG, "PROGRESS_BLANK 阶段单list--blank >0，当前进度：10");
            multiAudioMixerListener.mixerProgress(10);
        }
        changeAACListBlankAudioPath(arrayList, str3);
        boolean updateAACListVolume2 = updateAACListVolume(arrayList, null, str3, str2, 5, 60, multiAudioMixerListener, new StringBuilder());
        if (isDebug) {
            Log.d(TAG, "changeVolumeSuccess ：" + updateAACListVolume2);
        }
        iib.e("AudioMuxCostTime", "updateAACListVolume1:" + (System.currentTimeMillis() - currentTimeMillis4));
        long currentTimeMillis5 = System.currentTimeMillis();
        if (!updateAACListVolume2) {
            ehbVar.e += sb.toString();
            if (multiAudioMixerListener != null) {
                multiAudioMixerListener.mixerProgress(100);
                return false;
            }
            return false;
        }
        if (multiAudioMixerListener != null) {
            iib.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
            multiAudioMixerListener.mixerProgress(60);
        }
        try {
            appendAacList(arrayList, str, ehbVar);
            iib.e("AudioMuxCostTime", "appendAacList1:" + (System.currentTimeMillis() - currentTimeMillis5));
            if (new File(str).exists()) {
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return true;
            }
            ehbVar.e += "拼接文件不存在-2";
            if (multiAudioMixerListener != null) {
                multiAudioMixerListener.mixerProgress(100);
                return false;
            }
            return false;
        } catch (IOException e2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(ehbVar.e);
            sb5.append(e2);
            ehbVar.e = sb5.toString() != null ? e2.getMessage() : "";
            if (multiAudioMixerListener != null) {
                multiAudioMixerListener.mixerProgress(100);
                return false;
            }
            return false;
        }
    }

    public static boolean mixtureAACFileList(List<AudioPlayData> list, List<AudioPlayData> list2, String str, String str2, final MultiAudioMixerListener multiAudioMixerListener, ehb ehbVar) {
        removeAndCorrectErrorData(list, list2);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.clear();
        arrayList2.clear();
        arrayList.addAll(list);
        arrayList2.addAll(list2);
        if (checkListVolumeAllZero(arrayList)) {
            iib.e(TAG, " video 音频数据全为zero , 直接走 audio 单集合方法  ");
            return mixtureAACFileList(arrayList2, str, str2, multiAudioMixerListener, ehbVar);
        } else if (checkListVolumeAllZero(arrayList2)) {
            iib.e(TAG, " audio 音频数据全为zero , 直接走 video 单集合方法  ");
            return mixtureAACFileList(arrayList, str, str2, multiAudioMixerListener, ehbVar);
        } else if (!checkAACList(arrayList, arrayList2)) {
            ehbVar.e += "数据源错误-3";
            if (multiAudioMixerListener != null) {
                multiAudioMixerListener.mixerProgress(100);
            }
            return false;
        } else {
            int blankAudioDuration = getBlankAudioDuration(arrayList, arrayList2);
            if (multiAudioMixerListener != null) {
                iib.e(TAG, "PROGRESS_CALCULATE 阶段，当前进度：5");
                multiAudioMixerListener.mixerProgress(5);
            }
            if (blankAudioDuration < 0) {
                ehbVar.e += "数据源错误-4";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            }
            if (blankAudioDuration == 0) {
                if (multiAudioMixerListener != null) {
                    iib.e(TAG, "PROGRESS_BLANK 阶段--双 list--blank=0，当前进度：10");
                    multiAudioMixerListener.mixerProgress(10);
                }
                StringBuilder sb = new StringBuilder();
                if (!updateAACListVolume(arrayList, arrayList2, "", str2, 5, 60, multiAudioMixerListener, sb)) {
                    ehbVar.e += sb.toString();
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                iib.e("AudioMuxCostTime", "updateAACListVolume2:" + (System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis();
                if (multiAudioMixerListener != null) {
                    iib.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                    multiAudioMixerListener.mixerProgress(60);
                }
                String str3 = str2 + "/video_joint_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                String str4 = str2 + "/audio_joint_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                try {
                    appendAacList(arrayList, str3, ehbVar);
                    iib.e("AudioMuxCostTime", "videoTempListappendAacList2:" + (System.currentTimeMillis() - currentTimeMillis2));
                    long currentTimeMillis3 = System.currentTimeMillis();
                    try {
                        appendAacList(arrayList2, str4, ehbVar);
                        iib.e("AudioMuxCostTime", "audioTempListappendAacList2:" + (System.currentTimeMillis() - currentTimeMillis3));
                        long currentTimeMillis4 = System.currentTimeMillis();
                        File file = new File(str3);
                        File file2 = new File(str4);
                        if (!file.exists() || !file2.exists()) {
                            ehbVar.e += "拼接文件不存在-3";
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        }
                        if (multiAudioMixerListener != null) {
                            iib.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                            multiAudioMixerListener.mixerProgress(70);
                        }
                        boolean h = ygb.h(str, new String[]{str4, str3}, sb, new fib.a() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.1
                            @Override // com.baidu.tieba.fib.a
                            public void onCompletion() {
                            }

                            @Override // com.baidu.tieba.fib.a
                            public boolean onError(int i, int i2, Object obj) {
                                return false;
                            }

                            @Override // com.baidu.tieba.fib.a
                            public boolean onInfo(int i, int i2, Object obj) {
                                MultiAudioMixerListener multiAudioMixerListener2 = MultiAudioMixerListener.this;
                                if (multiAudioMixerListener2 == null || i != 1001) {
                                    return false;
                                }
                                int i3 = (int) ((((i2 * 30) * 1.0f) / 100.0f) + 70.0f);
                                multiAudioMixerListener2.mixerProgress(i3);
                                iib.e(VLogMultiAudioMixer.TAG, "mixAudioByFFmpeg 处理进度：" + i2 + "整体进度" + i3);
                                return false;
                            }
                        });
                        iib.e("AudioMuxCostTime", "mixAudioByFFmpeg2:" + (System.currentTimeMillis() - currentTimeMillis4));
                        long currentTimeMillis5 = System.currentTimeMillis();
                        if (!h) {
                            h = ygb.i(str, new float[]{1.0f, 1.0f}, new long[]{0, 0}, new long[]{-1, -1}, new String[]{str4, str3}, sb);
                        }
                        iib.e("AudioMuxCostTime", "mixingAudio2:" + (System.currentTimeMillis() - currentTimeMillis5));
                        System.currentTimeMillis();
                        if (h) {
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return true;
                        }
                        ehbVar.e += sb.toString();
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    } catch (IOException e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ehbVar.e);
                        sb2.append(e);
                        ehbVar.e = sb2.toString() != null ? e.getMessage() : "";
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                } catch (IOException e2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(ehbVar.e);
                    sb3.append(e2);
                    ehbVar.e = sb3.toString() != null ? e2.getMessage() : "";
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(arrayList);
            arrayList3.add(arrayList2);
            String str5 = str2 + "/blank_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            String str6 = str2 + "/video_joint_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            String str7 = str2 + "/audio_joint_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            boolean nearestBlankAudioPath = getNearestBlankAudioPath(arrayList3, blankAudioDuration, str5, ehbVar);
            iib.e("AudioMuxCostTime", "getNearestBlankAudioPath3:" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis6 = System.currentTimeMillis();
            File file3 = new File(str5);
            if (!nearestBlankAudioPath || !file3.exists()) {
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            }
            if (multiAudioMixerListener != null) {
                iib.e(TAG, "PROGRESS_BLANK 阶段--双 list--blank > 0，当前进度：10");
                multiAudioMixerListener.mixerProgress(10);
            }
            changeAACListBlankAudioPath(arrayList, arrayList2, str5);
            StringBuilder sb4 = new StringBuilder();
            if (!updateAACListVolume(arrayList, arrayList2, str5, str2, 5, 60, multiAudioMixerListener, sb4)) {
                ehbVar.e += sb4.toString();
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            }
            iib.e("AudioMuxCostTime", "updateAACListVolume3:" + (System.currentTimeMillis() - currentTimeMillis6));
            long currentTimeMillis7 = System.currentTimeMillis();
            if (multiAudioMixerListener != null) {
                iib.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                multiAudioMixerListener.mixerProgress(60);
            }
            try {
                appendAacList(arrayList, str6, ehbVar);
                iib.e("AudioMuxCostTime", "videoTempListappendAacList3:" + (System.currentTimeMillis() - currentTimeMillis7));
                long currentTimeMillis8 = System.currentTimeMillis();
                try {
                    appendAacList(arrayList2, str7, ehbVar);
                    iib.e("AudioMuxCostTime", "audioTempListappendAacList3:" + (System.currentTimeMillis() - currentTimeMillis8));
                    long currentTimeMillis9 = System.currentTimeMillis();
                    File file4 = new File(str6);
                    File file5 = new File(str7);
                    if (!file4.exists() || !file5.exists()) {
                        ehbVar.e += "拼接文件不存在-4";
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                    if (multiAudioMixerListener != null) {
                        iib.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                        multiAudioMixerListener.mixerProgress(70);
                    }
                    boolean h2 = ygb.h(str, new String[]{str7, str6}, sb4, new fib.a() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.2
                        @Override // com.baidu.tieba.fib.a
                        public void onCompletion() {
                        }

                        @Override // com.baidu.tieba.fib.a
                        public boolean onError(int i, int i2, Object obj) {
                            return false;
                        }

                        @Override // com.baidu.tieba.fib.a
                        public boolean onInfo(int i, int i2, Object obj) {
                            MultiAudioMixerListener multiAudioMixerListener2 = MultiAudioMixerListener.this;
                            if (multiAudioMixerListener2 == null || i != 1001) {
                                return false;
                            }
                            int i3 = (int) ((((i2 * 30) * 1.0f) / 100.0f) + 70.0f);
                            multiAudioMixerListener2.mixerProgress(i3);
                            iib.e(VLogMultiAudioMixer.TAG, "mixAudioByFFmpeg 处理进度：" + i2 + "整体进度" + i3);
                            return false;
                        }
                    });
                    iib.e("AudioMuxCostTime", "mixAudioByFFmpeg3:" + (System.currentTimeMillis() - currentTimeMillis9));
                    long currentTimeMillis10 = System.currentTimeMillis();
                    if (!h2) {
                        h2 = ygb.i(str, new float[]{1.0f, 1.0f}, new long[]{0, 0}, new long[]{-1, -1}, new String[]{str7, str6}, sb4);
                    }
                    iib.e("AudioMuxCostTime", "mixingAudio3:" + (System.currentTimeMillis() - currentTimeMillis10));
                    if (h2) {
                        if (multiAudioMixerListener != null) {
                            iib.e(TAG, "混音 阶段，当前进度：100");
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return true;
                    }
                    ehbVar.e += sb4.toString();
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                } catch (IOException e3) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(ehbVar.e);
                    sb5.append(e3);
                    ehbVar.e = sb5.toString() != null ? e3.getMessage() : "";
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
            } catch (IOException e4) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(ehbVar.e);
                sb6.append(e4);
                ehbVar.e = sb6.toString() != null ? e4.getMessage() : "";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            }
        }
    }

    public static void removeAndCorrectErrorData(List<AudioPlayData> list) {
        Iterator<AudioPlayData> it;
        if (list == null || (it = list.iterator()) == null) {
            return;
        }
        while (it.hasNext()) {
            AudioPlayData next = it.next();
            if (next != null) {
                if (next.start < 0) {
                    next.start = 0;
                }
                if (next.end <= next.start) {
                }
            }
            it.remove();
        }
    }

    public static void removeAndCorrectErrorData(List<AudioPlayData> list, List<AudioPlayData> list2) {
        removeAndCorrectErrorData(list);
        removeAndCorrectErrorData(list2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x031e, code lost:
        r9.append("updateAACListVolume- AudioPlayData 为 null or audioPath为空 ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0326, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean updateAACListVolume(List<AudioPlayData> list, List<AudioPlayData> list2, String str, String str2, int i, int i2, final MultiAudioMixerListener multiAudioMixerListener, final StringBuilder sb) {
        String str3;
        boolean z;
        StringBuilder sb2;
        int i3;
        int i4;
        xgb.f fVar;
        ArrayList arrayList;
        String str4 = str2;
        StringBuilder sb3 = sb;
        ArrayList arrayList2 = new ArrayList();
        if (list2 != null && list2.size() > 0) {
            arrayList2.addAll(list2);
        }
        if (list != null && list.size() > 0) {
            arrayList2.addAll(list);
        }
        char c = 0;
        if (arrayList2.size() == 0) {
            sb3.append("updateAACListVolume-数据为空");
            return false;
        }
        if (FileUtils.isExists(str)) {
            str3 = str;
        } else {
            AudioPlayData audioPlayData = (AudioPlayData) arrayList2.get(0);
            if (audioPlayData == null || !FileUtils.isExists(audioPlayData.audioPath)) {
                sb3.append("updateAACListVolume-第一个数据check 不过");
                return false;
            }
            str3 = audioPlayData.audioPath;
        }
        iib.e(TAG, "defaultFormatAudioPath = " + str3);
        if (isDebug) {
            Log.d(TAG, "updateAACListVolume-检验数据通过");
        }
        xgb.f e = xgb.e(str3);
        if (e == null) {
            e = new xgb.f();
        }
        xgb.f fVar2 = e;
        int size = arrayList2.size();
        int i5 = (i2 - i) / size;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                return true;
            }
            final AudioPlayData audioPlayData2 = (AudioPlayData) arrayList2.get(i6);
            if (audioPlayData2 == null || !FileUtils.isExists(audioPlayData2.audioPath)) {
                break;
            }
            xgb.f e2 = xgb.e(((AudioPlayData) arrayList2.get(i6)).audioPath);
            if (e2 == null) {
                e2 = new xgb.f();
                z = true;
            } else {
                z = false;
            }
            xgb.f[] fVarArr = new xgb.f[2];
            fVarArr[c] = fVar2;
            fVarArr[1] = e2;
            boolean i7 = xgb.i(fVarArr);
            boolean z2 = !i7 && e2.c();
            boolean z3 = !i7 && e2.a();
            boolean z4 = !i7 && e2.b();
            boolean z5 = audioPlayData2.volume != 1.0f;
            boolean equals = MimeTypes.AUDIO_MPEG.equals(e2.d);
            int i8 = (z3 && (z2 || z4 || z5 || z || equals)) ? i5 / 2 : i5;
            iib.e(TAG, "data.audioPath" + audioPlayData2.audioPath + "--audioformat:" + e2.a + "," + e2.b + "," + e2.c + "targetaudioformat:" + fVar2.a + "," + fVar2.b + "," + fVar2.c + "," + e2.c() + "," + e2.a() + "," + e2.b() + "," + z5);
            int i9 = i + (i6 * i5);
            if (z2 || z3 || z4 || z5 || z || equals) {
                if (z3) {
                    String str5 = str4 + "/change_bit_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                    if (!ygb.p(str5, audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, sb, audioPlayData2.volume, fVar2, e2) || !FileUtils.isExists(str5)) {
                        return false;
                    }
                    if (multiAudioMixerListener != null) {
                        int i10 = i9 + i8;
                        multiAudioMixerListener.mixerProgress(i10);
                        iib.e(TAG, "PROGRESS_UNIFY - ConvertBit -阶段，当前进度：" + i10);
                        i9 = i10;
                    }
                    audioPlayData2.audioPath = str5;
                }
                if (z2 || z4 || z5 || z || equals) {
                    try {
                        iib.e("VideoMuxer", "startresample,src:" + e2.a + "dest:" + fVar2.a);
                        final String str6 = str2 + "/unify_property_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                        i3 = i6;
                        final int i11 = i8;
                        i4 = size;
                        final int i12 = i9;
                        fVar = fVar2;
                        arrayList = arrayList2;
                        sb2 = sb3;
                        try {
                            xgb.l(audioPlayData2.audioPath, str6, fVar2.a, fVar2.b, audioPlayData2.volume, fVar2.c, (audioPlayData2.start * 1.0f) / 1000.0f, ((audioPlayData2.end - audioPlayData2.start) * 1.0f) / 1000.0f, equals, new fib.a() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.3
                                /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
                                /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
                                /* JADX WARN: Removed duplicated region for block: B:36:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                @Override // com.baidu.tieba.fib.a
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void onCompletion() {
                                    long j;
                                    MediaMetadataRetriever mediaMetadataRetriever;
                                    AudioPlayData audioPlayData3 = audioPlayData2;
                                    String str7 = str6;
                                    audioPlayData3.audioPath = str7;
                                    try {
                                        j = djb.b(str7);
                                        try {
                                            iib.e("VideoMuxer", "after ffmpege duration1 = " + j);
                                        } catch (Exception unused) {
                                        }
                                    } catch (Exception unused2) {
                                        j = 0;
                                    }
                                    if (j <= 0) {
                                        MediaMetadataRetriever mediaMetadataRetriever2 = null;
                                        try {
                                            mediaMetadataRetriever = new MediaMetadataRetriever();
                                        } catch (Exception unused3) {
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                        try {
                                            mediaMetadataRetriever.setDataSource(audioPlayData2.audioPath);
                                            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                                            j = Long.parseLong(extractMetadata);
                                            iib.e("VideoMuxer", "after ffmpege duration2 = " + extractMetadata);
                                            mediaMetadataRetriever.release();
                                        } catch (Exception unused4) {
                                            mediaMetadataRetriever2 = mediaMetadataRetriever;
                                            if (mediaMetadataRetriever2 != null) {
                                                mediaMetadataRetriever2.release();
                                            }
                                            if (j > 0) {
                                            }
                                            audioPlayData2.start = 0;
                                            synchronized (VLogMultiAudioMixer.lockObject) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mediaMetadataRetriever2 = mediaMetadataRetriever;
                                            if (mediaMetadataRetriever2 != null) {
                                                mediaMetadataRetriever2.release();
                                            }
                                            throw th;
                                        }
                                    }
                                    if (j > 0) {
                                        AudioPlayData audioPlayData4 = audioPlayData2;
                                        audioPlayData4.end -= audioPlayData4.start;
                                    } else {
                                        audioPlayData2.end = (int) j;
                                    }
                                    audioPlayData2.start = 0;
                                    synchronized (VLogMultiAudioMixer.lockObject) {
                                        VLogMultiAudioMixer.lockObject.notifyAll();
                                    }
                                }

                                @Override // com.baidu.tieba.fib.a
                                public boolean onError(int i13, int i14, Object obj) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(",ffmpegerror:");
                                    sb4.append(i13);
                                    sb4.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                    sb4.append(i14);
                                    sb4.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                    sb4.append(obj != null ? obj.toString() : "");
                                    String sb5 = sb4.toString();
                                    StringBuilder sb6 = sb;
                                    if (sb6 != null) {
                                        sb6.append(sb5);
                                    }
                                    synchronized (VLogMultiAudioMixer.lockObject) {
                                        VLogMultiAudioMixer.lockObject.notifyAll();
                                    }
                                    return false;
                                }

                                @Override // com.baidu.tieba.fib.a
                                public boolean onInfo(int i13, int i14, Object obj) {
                                    MultiAudioMixerListener multiAudioMixerListener2 = MultiAudioMixerListener.this;
                                    if (multiAudioMixerListener2 == null || i13 != 1001) {
                                        return false;
                                    }
                                    int i15 = i12 + ((int) (((i14 * 1.0f) / 100.0f) * i11));
                                    multiAudioMixerListener2.mixerProgress(i15);
                                    iib.e(VLogMultiAudioMixer.TAG, "PROGRESS_UNIFY - other property - 阶段， finalItemProgress = " + i11 + " i1 = " + i14 + "当前进度：" + i15);
                                    return false;
                                }
                            });
                            iib.e("VideoMuxer", "resampledone");
                            try {
                                synchronized (lockObject) {
                                    lockObject.wait();
                                }
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                            if (!TextUtils.equals(str6, audioPlayData2.audioPath)) {
                                sb2.append("ffmpeg 重采样失败了");
                                return false;
                            }
                            iib.e("VideoMuxer", "resampledone-nextstep");
                        } catch (Throwable th) {
                            th = th;
                            sb2.append(th.getMessage());
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sb2 = sb3;
                    }
                } else {
                    i3 = i6;
                    i4 = size;
                    fVar = fVar2;
                    arrayList = arrayList2;
                    sb2 = sb3;
                }
                if (isDebug) {
                    Log.d(TAG, "updateAACListVolume-开始执行 - transCodeFormat");
                }
            } else {
                if (multiAudioMixerListener != null) {
                    int i13 = i9 + i8;
                    multiAudioMixerListener.mixerProgress(i13);
                    iib.e(TAG, "PROGRESS_UNIFY - 阶段，当前进度：" + i13);
                }
                i3 = i6;
                i4 = size;
                fVar = fVar2;
                arrayList = arrayList2;
                sb2 = sb3;
            }
            i6 = i3 + 1;
            str4 = str2;
            sb3 = sb2;
            size = i4;
            fVar2 = fVar;
            arrayList2 = arrayList;
            c = 0;
        }
    }
}
