package com.baidu.ugc.editvideo.editvideo.muxer;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.ah9;
import com.baidu.tieba.bh9;
import com.baidu.tieba.ff9;
import com.baidu.tieba.gf9;
import com.baidu.tieba.lh9;
import com.baidu.tieba.mf9;
import com.baidu.tieba.ng9;
import com.baidu.tieba.qg9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class VLogMultiAudioMixer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PROGRESS_APPEND = 70;
    public static final int PROGRESS_BLANK = 10;
    public static final int PROGRESS_CALCULATE = 5;
    public static final int PROGRESS_ERROR = 100;
    public static final int PROGRESS_SUCCESS = 100;
    public static final int PROGRESS_UNIFY = 60;
    public static final String TAG = "VLogMultiAudioMixerTag";
    public static boolean isDebug;
    public static Object lockObject;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface MultiAudioMixerListener {
        void mixerProgress(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1002118999, "Lcom/baidu/ugc/editvideo/editvideo/muxer/VLogMultiAudioMixer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1002118999, "Lcom/baidu/ugc/editvideo/editvideo/muxer/VLogMultiAudioMixer;");
                return;
            }
        }
        lockObject = new Object();
    }

    public VLogMultiAudioMixer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean appendAacList(List<AudioPlayData> list, String str, mf9 mf9Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, list, str, mf9Var)) == null) {
            Movie movie = new Movie();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                AudioPlayData audioPlayData = list.get(i);
                if (audioPlayData == null || !jointAACList(linkedList, audioPlayData.audioPath, audioPlayData.start, audioPlayData.end, mf9Var)) {
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
                    mf9Var.e += e.getMessage();
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
        return invokeLLL.booleanValue;
    }

    public static void changeAACListBlankAudioPath(List<AudioPlayData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str) == null) {
            for (int i = 0; i < list.size(); i++) {
                AudioPlayData audioPlayData = list.get(i);
                if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath)) {
                    audioPlayData.audioPath = str;
                    audioPlayData.volume = 1.0f;
                }
            }
        }
    }

    public static void changeAACListBlankAudioPath(List<AudioPlayData> list, List<AudioPlayData> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, list, list2, str) == null) {
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
    }

    public static boolean checkAACList(List<AudioPlayData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean checkAACList(List<AudioPlayData> list, List<AudioPlayData> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, list2)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static boolean checkListVolumeAllZero(List<AudioPlayData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: Exception -> 0x024e, TryCatch #0 {Exception -> 0x024e, blocks: (B:19:0x0044, B:21:0x004a, B:28:0x0064, B:33:0x00af, B:35:0x00c2, B:36:0x00df, B:47:0x0112, B:10:0x0018, B:11:0x0025, B:13:0x002b), top: B:85:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean clipAacFile(String str, String str2, long j, long j2, StringBuilder sb) {
        InterceptResult invokeCommon;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), sb})) == null) {
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
                            sb2.append(ah9.g(e));
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
            long d = lh9.d(track);
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
                    long e2 = lh9.e(track, (j5 * 1.0d) / 1000.0d);
                    long e3 = lh9.e(track, ((j5 + j) * 1.0d) / 1000.0d);
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
                                arrayList.add(new AppendTrack(new CroppedTrack(track, lh9.e(track, (j5 * 1.0d) / 1000.0d), lh9.e(track, (d * 1.0d) / 1000.0d))));
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
                            long e4 = lh9.e(track, (j5 * 1.0d) / 1000.0d);
                            long e5 = lh9.e(track, ((j5 + j10) * 1.0d) / 1000.0d);
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
                long a = bh9.a(str2);
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
        return invokeCommon.booleanValue;
    }

    public static int getBlankAudioDuration(List<AudioPlayData> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
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
        return invokeL.intValue;
    }

    public static int getBlankAudioDuration(List<AudioPlayData> list, List<AudioPlayData> list2) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, list, list2)) == null) {
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
        return invokeLL.intValue;
    }

    public static boolean getNearestBlankAudioPath(List<List<AudioPlayData>> list, int i, String str, mf9 mf9Var) {
        InterceptResult invokeLILL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65548, null, list, i, str, mf9Var)) == null) {
            if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
                sb = new StringBuilder();
                sb.append(mf9Var.e);
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
                                int f = bh9.f(audioPlayData2.audioPath);
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
                    qg9.e(TAG, "blank 音频路径" + audioPlayData.audioPath);
                    ff9.f e = ff9.e(audioPlayData.audioPath);
                    if (e == null) {
                        e = new ff9.f();
                    }
                    boolean[] zArr = {false};
                    try {
                        ff9.l(audioPlayData.audioPath, str, e.a, e.b, 0.0f, e.c, 0.0f, (i * 1.0f) / 1000.0f, MimeTypes.AUDIO_MPEG.equals(e.d), new ng9.a(mf9Var, zArr) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ mf9 val$errorLogInfo;
                            public final /* synthetic */ boolean[] val$isSuccess;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {mf9Var, zArr};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$errorLogInfo = mf9Var;
                                this.val$isSuccess = zArr;
                            }

                            @Override // com.baidu.tieba.ng9.a
                            public void onCompletion() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$isSuccess[0] = true;
                                    synchronized (VLogMultiAudioMixer.lockObject) {
                                        VLogMultiAudioMixer.lockObject.notifyAll();
                                    }
                                }
                            }

                            @Override // com.baidu.tieba.ng9.a
                            public boolean onError(int i4, int i5, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5, obj)) == null) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(",ffmpegerror:");
                                    sb2.append(i4);
                                    sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                    sb2.append(i5);
                                    sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                    sb2.append(obj != null ? obj.toString() : "");
                                    String sb3 = sb2.toString();
                                    mf9 mf9Var2 = this.val$errorLogInfo;
                                    if (mf9Var2 != null) {
                                        mf9Var2.e = this.val$errorLogInfo.e + sb3;
                                    }
                                    synchronized (VLogMultiAudioMixer.lockObject) {
                                        VLogMultiAudioMixer.lockObject.notifyAll();
                                    }
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }

                            @Override // com.baidu.tieba.ng9.a
                            public boolean onInfo(int i4, int i5, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i4, i5, obj)) == null) {
                                    qg9.e(VLogMultiAudioMixer.TAG, " 进行blank 音量文件生成 进度i1 = " + i5);
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }
                        });
                        qg9.e("VideoMuxer", "resampledone");
                        try {
                            synchronized (lockObject) {
                                lockObject.wait();
                            }
                            if (zArr[0] && FileUtils.isExists(str)) {
                                qg9.e(TAG, "blank volume 生成成功");
                                return true;
                            }
                            mf9Var.e += " ffmpeg 调整音量失败了-2 ";
                            return false;
                        } catch (InterruptedException e2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(mf9Var.e);
                            sb2.append(e2);
                            mf9Var.e = sb2.toString() != null ? e2.getMessage() : " ffmpeg 调整音量失败了-1 ";
                            return false;
                        }
                    } catch (Throwable th) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(mf9Var.e);
                        sb3.append(th);
                        mf9Var.e = sb3.toString() != null ? th.getMessage() : " ffmpeg 调整音量失败了-3 ";
                        return false;
                    }
                }
                sb = new StringBuilder();
                sb.append(mf9Var.e);
                sb.append("音频源筛选为null or realDuration==0, closeTarget=");
                sb.append(audioPlayData);
            }
            mf9Var.e = sb.toString();
            return false;
        }
        return invokeLILL.booleanValue;
    }

    public static boolean jointAACList(List<Track> list, String str, long j, long j2, mf9 mf9Var) {
        InterceptResult invokeCommon;
        Track track;
        long j3;
        long j4;
        long j5;
        long j6;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{list, str, Long.valueOf(j), Long.valueOf(j2), mf9Var})) == null) {
            qg9.e("VideoMuxer", "jointAACList" + str);
            StringBuilder sb = new StringBuilder();
            char c = 0;
            if (list == null || TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            try {
                if (j > j2) {
                    return false;
                }
                try {
                    long f = bh9.f(str);
                    ff9.f e = ff9.e(str);
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
                    sb.append(ah9.g(e2));
                }
                Track track2 = null;
                long j7 = j2 - j;
                try {
                    track = new AACTrackImpl(new FileDataSourceImpl(str));
                } catch (Exception e3) {
                    sb.append(" ,aacTrack error ");
                    sb.append(ah9.g(e3));
                    for (Track track3 : MovieCreator.build(str).getTracks()) {
                        if (track3 != null && "soun".equals(track3.getHandler())) {
                            track2 = track3;
                        }
                    }
                    track = track2;
                }
                if (track == null) {
                    if (mf9Var != null) {
                        mf9Var.e += " mp4parser 音频合成没有找到aac音频-2  " + sb.toString();
                    }
                    return false;
                }
                long d = lh9.d(track);
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
                    list.add(new AppendTrack(new CroppedTrack(track, lh9.e(track, (j * 1.0d) / 1000.0d), lh9.e(track, ((j + j7) * 1.0d) / 1000.0d))));
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
                                list.add(new AppendTrack(new CroppedTrack(track, lh9.e(track, (j * 1.0d) / 1000.0d), lh9.e(track, (d * 1.0d) / 1000.0d))));
                            }
                            j6 = j11 + j4;
                            str3 = str2;
                        } else {
                            long j12 = j9;
                            String str4 = str3;
                            j3 = j7;
                            j4 = j8;
                            j5 = d;
                            long e4 = lh9.e(track, (j * 1.0d) / 1000.0d);
                            long e5 = lh9.e(track, ((j + j10) * 1.0d) / 1000.0d);
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
                if (mf9Var != null) {
                    mf9Var.e += sb.toString() + " mp4parser 音频合成过程中发生异常-2:" + e6.getMessage() + " 详细信息：" + ah9.g(e6);
                }
                e6.printStackTrace();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean mixtureAACFileList(List<AudioPlayData> list, String str, String str2, MultiAudioMixerListener multiAudioMixerListener, mf9 mf9Var) {
        InterceptResult invokeLLLLL;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65550, null, list, str, str2, multiAudioMixerListener, mf9Var)) == null) {
            removeAndCorrectErrorData(list);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.addAll(list);
            if (!checkAACList(arrayList)) {
                mf9Var.e += "数据源错误-1";
                return false;
            }
            if (isDebug) {
                Log.d(TAG, "checkAACList ok");
            }
            int blankAudioDuration = getBlankAudioDuration(arrayList);
            qg9.e("AudioMuxCostTime", "getBlankAudioDuration:" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (multiAudioMixerListener != null) {
                qg9.e(TAG, "UPROGRESS_CALCULATE 阶段，当前进度：5");
                multiAudioMixerListener.mixerProgress(5);
            }
            if (blankAudioDuration < 0) {
                mf9Var.e += "数据源错误-2";
                if (multiAudioMixerListener != null) {
                    qg9.e(TAG, "PROGRESS_ERROR 阶段 1，当前进度：100" + mf9Var.e);
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            }
            if (blankAudioDuration == 0) {
                if (multiAudioMixerListener != null) {
                    qg9.e(TAG, "PROGRESS_BLANK 阶段--单list--blank 0，当前进度：10");
                    multiAudioMixerListener.mixerProgress(10);
                }
                boolean updateAACListVolume = updateAACListVolume(arrayList, null, "", str2, 5, 60, multiAudioMixerListener, new StringBuilder());
                qg9.e("AudioMuxCostTime", "updateAACListVolume:" + (System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                if (!updateAACListVolume) {
                    mf9Var.e += sb2.toString();
                    if (multiAudioMixerListener != null) {
                        qg9.e(TAG, "PROGRESS_ERROR 阶段 2，当前进度：100" + mf9Var.e);
                        multiAudioMixerListener.mixerProgress(100);
                        return false;
                    }
                    return false;
                }
                if (multiAudioMixerListener != null) {
                    qg9.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                    multiAudioMixerListener.mixerProgress(60);
                }
                if (isDebug) {
                    Log.d(TAG, "updateAACListVolume pass");
                }
                try {
                    boolean appendAacList = appendAacList(arrayList, str, mf9Var);
                    qg9.e("AudioMuxCostTime", "appendAacList:" + (System.currentTimeMillis() - currentTimeMillis3));
                    if (multiAudioMixerListener != null) {
                        qg9.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
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
                            qg9.e(TAG, "PROGRESS_SUCCESS 阶段，当前进度：100");
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return true;
                    }
                    mf9Var.e += "拼接文件不存在-1";
                    if (isDebug) {
                        Log.d(TAG, "appendAacList is not exists ");
                    }
                    if (multiAudioMixerListener != null) {
                        qg9.e(TAG, "PROGRESS_ERROR 阶段 4，当前进度：100" + mf9Var.e);
                        multiAudioMixerListener.mixerProgress(100);
                        return false;
                    }
                    return false;
                } catch (IOException e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(mf9Var.e);
                    sb3.append(e);
                    mf9Var.e = sb3.toString() != null ? e.getMessage() : "";
                    if (multiAudioMixerListener != null) {
                        qg9.e(TAG, "PROGRESS_ERROR 阶段 3，当前进度：100" + mf9Var.e);
                        multiAudioMixerListener.mixerProgress(100);
                        return false;
                    }
                    return false;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(list);
            String str3 = str2 + "/blank_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
            boolean nearestBlankAudioPath = getNearestBlankAudioPath(arrayList2, blankAudioDuration, str3, mf9Var);
            qg9.c(TAG, "getNearestBlankAudioPath - 返回 " + nearestBlankAudioPath + " maxBlankDuration =" + blankAudioDuration);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("getNearestBlankAudioPath1:");
            sb4.append(System.currentTimeMillis() - currentTimeMillis2);
            qg9.e("AudioMuxCostTime", sb4.toString());
            long currentTimeMillis4 = System.currentTimeMillis();
            File file2 = new File(str3);
            if (!nearestBlankAudioPath || !file2.exists()) {
                if (multiAudioMixerListener != null) {
                    Log.d(TAG, "当前进度 ：100错误信息" + mf9Var.e);
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
            if (multiAudioMixerListener != null) {
                qg9.e(TAG, "PROGRESS_BLANK 阶段单list--blank >0，当前进度：10");
                multiAudioMixerListener.mixerProgress(10);
            }
            changeAACListBlankAudioPath(arrayList, str3);
            boolean updateAACListVolume2 = updateAACListVolume(arrayList, null, str3, str2, 5, 60, multiAudioMixerListener, new StringBuilder());
            if (isDebug) {
                Log.d(TAG, "changeVolumeSuccess ：" + updateAACListVolume2);
            }
            qg9.e("AudioMuxCostTime", "updateAACListVolume1:" + (System.currentTimeMillis() - currentTimeMillis4));
            long currentTimeMillis5 = System.currentTimeMillis();
            if (!updateAACListVolume2) {
                mf9Var.e += sb.toString();
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
            if (multiAudioMixerListener != null) {
                qg9.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                multiAudioMixerListener.mixerProgress(60);
            }
            try {
                appendAacList(arrayList, str, mf9Var);
                qg9.e("AudioMuxCostTime", "appendAacList1:" + (System.currentTimeMillis() - currentTimeMillis5));
                if (new File(str).exists()) {
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return true;
                }
                mf9Var.e += "拼接文件不存在-2";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            } catch (IOException e2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(mf9Var.e);
                sb5.append(e2);
                mf9Var.e = sb5.toString() != null ? e2.getMessage() : "";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean mixtureAACFileList(List<AudioPlayData> list, List<AudioPlayData> list2, String str, String str2, MultiAudioMixerListener multiAudioMixerListener, mf9 mf9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{list, list2, str, str2, multiAudioMixerListener, mf9Var})) == null) {
            removeAndCorrectErrorData(list, list2);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.clear();
            arrayList2.clear();
            arrayList.addAll(list);
            arrayList2.addAll(list2);
            if (checkListVolumeAllZero(arrayList)) {
                qg9.e(TAG, " video 音频数据全为zero , 直接走 audio 单集合方法  ");
                return mixtureAACFileList(arrayList2, str, str2, multiAudioMixerListener, mf9Var);
            } else if (checkListVolumeAllZero(arrayList2)) {
                qg9.e(TAG, " audio 音频数据全为zero , 直接走 video 单集合方法  ");
                return mixtureAACFileList(arrayList, str, str2, multiAudioMixerListener, mf9Var);
            } else if (!checkAACList(arrayList, arrayList2)) {
                mf9Var.e += "数据源错误-3";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            } else {
                int blankAudioDuration = getBlankAudioDuration(arrayList, arrayList2);
                if (multiAudioMixerListener != null) {
                    qg9.e(TAG, "PROGRESS_CALCULATE 阶段，当前进度：5");
                    multiAudioMixerListener.mixerProgress(5);
                }
                if (blankAudioDuration < 0) {
                    mf9Var.e += "数据源错误-4";
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                if (blankAudioDuration == 0) {
                    if (multiAudioMixerListener != null) {
                        qg9.e(TAG, "PROGRESS_BLANK 阶段--双 list--blank=0，当前进度：10");
                        multiAudioMixerListener.mixerProgress(10);
                    }
                    StringBuilder sb = new StringBuilder();
                    if (!updateAACListVolume(arrayList, arrayList2, "", str2, 5, 60, multiAudioMixerListener, sb)) {
                        mf9Var.e += sb.toString();
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                    qg9.e("AudioMuxCostTime", "updateAACListVolume2:" + (System.currentTimeMillis() - currentTimeMillis));
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (multiAudioMixerListener != null) {
                        qg9.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                        multiAudioMixerListener.mixerProgress(60);
                    }
                    String str3 = str2 + "/video_joint_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                    String str4 = str2 + "/audio_joint_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                    try {
                        appendAacList(arrayList, str3, mf9Var);
                        qg9.e("AudioMuxCostTime", "videoTempListappendAacList2:" + (System.currentTimeMillis() - currentTimeMillis2));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        try {
                            appendAacList(arrayList2, str4, mf9Var);
                            qg9.e("AudioMuxCostTime", "audioTempListappendAacList2:" + (System.currentTimeMillis() - currentTimeMillis3));
                            long currentTimeMillis4 = System.currentTimeMillis();
                            File file = new File(str3);
                            File file2 = new File(str4);
                            if (!file.exists() || !file2.exists()) {
                                mf9Var.e += "拼接文件不存在-3";
                                if (multiAudioMixerListener != null) {
                                    multiAudioMixerListener.mixerProgress(100);
                                }
                                return false;
                            }
                            if (multiAudioMixerListener != null) {
                                qg9.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                                multiAudioMixerListener.mixerProgress(70);
                            }
                            boolean h = gf9.h(str, new String[]{str4, str3}, sb, new ng9.a(multiAudioMixerListener) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MultiAudioMixerListener val$listener;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {multiAudioMixerListener};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$listener = multiAudioMixerListener;
                                }

                                @Override // com.baidu.tieba.ng9.a
                                public void onCompletion() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    }
                                }

                                @Override // com.baidu.tieba.ng9.a
                                public boolean onError(int i, int i2, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }

                                @Override // com.baidu.tieba.ng9.a
                                public boolean onInfo(int i, int i2, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                                        MultiAudioMixerListener multiAudioMixerListener2 = this.val$listener;
                                        if (multiAudioMixerListener2 == null || i != 1001) {
                                            return false;
                                        }
                                        int i3 = (int) ((((i2 * 30) * 1.0f) / 100.0f) + 70.0f);
                                        multiAudioMixerListener2.mixerProgress(i3);
                                        qg9.e(VLogMultiAudioMixer.TAG, "mixAudioByFFmpeg 处理进度：" + i2 + "整体进度" + i3);
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }
                            });
                            qg9.e("AudioMuxCostTime", "mixAudioByFFmpeg2:" + (System.currentTimeMillis() - currentTimeMillis4));
                            long currentTimeMillis5 = System.currentTimeMillis();
                            if (!h) {
                                h = gf9.i(str, new float[]{1.0f, 1.0f}, new long[]{0, 0}, new long[]{-1, -1}, new String[]{str4, str3}, sb);
                            }
                            qg9.e("AudioMuxCostTime", "mixingAudio2:" + (System.currentTimeMillis() - currentTimeMillis5));
                            System.currentTimeMillis();
                            if (h) {
                                if (multiAudioMixerListener != null) {
                                    multiAudioMixerListener.mixerProgress(100);
                                }
                                return true;
                            }
                            mf9Var.e += sb.toString();
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        } catch (IOException e) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(mf9Var.e);
                            sb2.append(e);
                            mf9Var.e = sb2.toString() != null ? e.getMessage() : "";
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        }
                    } catch (IOException e2) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(mf9Var.e);
                        sb3.append(e2);
                        mf9Var.e = sb3.toString() != null ? e2.getMessage() : "";
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
                boolean nearestBlankAudioPath = getNearestBlankAudioPath(arrayList3, blankAudioDuration, str5, mf9Var);
                qg9.e("AudioMuxCostTime", "getNearestBlankAudioPath3:" + (System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis6 = System.currentTimeMillis();
                File file3 = new File(str5);
                if (!nearestBlankAudioPath || !file3.exists()) {
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                if (multiAudioMixerListener != null) {
                    qg9.e(TAG, "PROGRESS_BLANK 阶段--双 list--blank > 0，当前进度：10");
                    multiAudioMixerListener.mixerProgress(10);
                }
                changeAACListBlankAudioPath(arrayList, arrayList2, str5);
                StringBuilder sb4 = new StringBuilder();
                if (!updateAACListVolume(arrayList, arrayList2, str5, str2, 5, 60, multiAudioMixerListener, sb4)) {
                    mf9Var.e += sb4.toString();
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                qg9.e("AudioMuxCostTime", "updateAACListVolume3:" + (System.currentTimeMillis() - currentTimeMillis6));
                long currentTimeMillis7 = System.currentTimeMillis();
                if (multiAudioMixerListener != null) {
                    qg9.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                    multiAudioMixerListener.mixerProgress(60);
                }
                try {
                    appendAacList(arrayList, str6, mf9Var);
                    qg9.e("AudioMuxCostTime", "videoTempListappendAacList3:" + (System.currentTimeMillis() - currentTimeMillis7));
                    long currentTimeMillis8 = System.currentTimeMillis();
                    try {
                        appendAacList(arrayList2, str7, mf9Var);
                        qg9.e("AudioMuxCostTime", "audioTempListappendAacList3:" + (System.currentTimeMillis() - currentTimeMillis8));
                        long currentTimeMillis9 = System.currentTimeMillis();
                        File file4 = new File(str6);
                        File file5 = new File(str7);
                        if (!file4.exists() || !file5.exists()) {
                            mf9Var.e += "拼接文件不存在-4";
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        }
                        if (multiAudioMixerListener != null) {
                            qg9.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                            multiAudioMixerListener.mixerProgress(70);
                        }
                        boolean h2 = gf9.h(str, new String[]{str7, str6}, sb4, new ng9.a(multiAudioMixerListener) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MultiAudioMixerListener val$listener;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {multiAudioMixerListener};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$listener = multiAudioMixerListener;
                            }

                            @Override // com.baidu.tieba.ng9.a
                            public void onCompletion() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                }
                            }

                            @Override // com.baidu.tieba.ng9.a
                            public boolean onError(int i, int i2, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }

                            @Override // com.baidu.tieba.ng9.a
                            public boolean onInfo(int i, int i2, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                                    MultiAudioMixerListener multiAudioMixerListener2 = this.val$listener;
                                    if (multiAudioMixerListener2 == null || i != 1001) {
                                        return false;
                                    }
                                    int i3 = (int) ((((i2 * 30) * 1.0f) / 100.0f) + 70.0f);
                                    multiAudioMixerListener2.mixerProgress(i3);
                                    qg9.e(VLogMultiAudioMixer.TAG, "mixAudioByFFmpeg 处理进度：" + i2 + "整体进度" + i3);
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }
                        });
                        qg9.e("AudioMuxCostTime", "mixAudioByFFmpeg3:" + (System.currentTimeMillis() - currentTimeMillis9));
                        long currentTimeMillis10 = System.currentTimeMillis();
                        if (!h2) {
                            h2 = gf9.i(str, new float[]{1.0f, 1.0f}, new long[]{0, 0}, new long[]{-1, -1}, new String[]{str7, str6}, sb4);
                        }
                        qg9.e("AudioMuxCostTime", "mixingAudio3:" + (System.currentTimeMillis() - currentTimeMillis10));
                        if (h2) {
                            if (multiAudioMixerListener != null) {
                                qg9.e(TAG, "混音 阶段，当前进度：100");
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return true;
                        }
                        mf9Var.e += sb4.toString();
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    } catch (IOException e3) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(mf9Var.e);
                        sb5.append(e3);
                        mf9Var.e = sb5.toString() != null ? e3.getMessage() : "";
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                } catch (IOException e4) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(mf9Var.e);
                    sb6.append(e4);
                    mf9Var.e = sb6.toString() != null ? e4.getMessage() : "";
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void removeAndCorrectErrorData(List<AudioPlayData> list) {
        Iterator<AudioPlayData> it;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, list) == null) || list == null || (it = list.iterator()) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, list, list2) == null) {
            removeAndCorrectErrorData(list);
            removeAndCorrectErrorData(list2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x031f, code lost:
        r9.append("updateAACListVolume- AudioPlayData 为 null or audioPath为空 ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0326, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean updateAACListVolume(List<AudioPlayData> list, List<AudioPlayData> list2, String str, String str2, int i, int i2, MultiAudioMixerListener multiAudioMixerListener, StringBuilder sb) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        StringBuilder sb2;
        int i3;
        int i4;
        ff9.f fVar;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{list, list2, str, str2, Integer.valueOf(i), Integer.valueOf(i2), multiAudioMixerListener, sb})) != null) {
            return invokeCommon.booleanValue;
        }
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
        qg9.e(TAG, "defaultFormatAudioPath = " + str3);
        if (isDebug) {
            Log.d(TAG, "updateAACListVolume-检验数据通过");
        }
        ff9.f e = ff9.e(str3);
        if (e == null) {
            e = new ff9.f();
        }
        ff9.f fVar2 = e;
        int size = arrayList2.size();
        int i5 = (i2 - i) / size;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                return true;
            }
            AudioPlayData audioPlayData2 = (AudioPlayData) arrayList2.get(i6);
            if (audioPlayData2 == null || !FileUtils.isExists(audioPlayData2.audioPath)) {
                break;
            }
            ff9.f e2 = ff9.e(((AudioPlayData) arrayList2.get(i6)).audioPath);
            if (e2 == null) {
                e2 = new ff9.f();
                z = true;
            } else {
                z = false;
            }
            ff9.f[] fVarArr = new ff9.f[2];
            fVarArr[c] = fVar2;
            fVarArr[1] = e2;
            boolean i7 = ff9.i(fVarArr);
            boolean z2 = !i7 && e2.c();
            boolean z3 = !i7 && e2.a();
            boolean z4 = !i7 && e2.b();
            boolean z5 = audioPlayData2.volume != 1.0f;
            boolean equals = MimeTypes.AUDIO_MPEG.equals(e2.d);
            int i8 = (z3 && (z2 || z4 || z5 || z || equals)) ? i5 / 2 : i5;
            qg9.e(TAG, "data.audioPath" + audioPlayData2.audioPath + "--audioformat:" + e2.a + "," + e2.b + "," + e2.c + "targetaudioformat:" + fVar2.a + "," + fVar2.b + "," + fVar2.c + "," + e2.c() + "," + e2.a() + "," + e2.b() + "," + z5);
            int i9 = i + (i6 * i5);
            if (z2 || z3 || z4 || z5 || z || equals) {
                if (z3) {
                    String str5 = str4 + "/change_bit_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                    if (!gf9.p(str5, audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, sb, audioPlayData2.volume, fVar2, e2) || !FileUtils.isExists(str5)) {
                        return false;
                    }
                    if (multiAudioMixerListener != null) {
                        int i10 = i9 + i8;
                        multiAudioMixerListener.mixerProgress(i10);
                        qg9.e(TAG, "PROGRESS_UNIFY - ConvertBit -阶段，当前进度：" + i10);
                        i9 = i10;
                    }
                    audioPlayData2.audioPath = str5;
                }
                if (z2 || z4 || z5 || z || equals) {
                    try {
                        qg9.e("VideoMuxer", "startresample,src:" + e2.a + "dest:" + fVar2.a);
                        String str6 = str2 + "/unify_property_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                        i3 = i6;
                        i4 = size;
                        fVar = fVar2;
                        arrayList = arrayList2;
                        sb2 = sb3;
                        try {
                            ff9.l(audioPlayData2.audioPath, str6, fVar2.a, fVar2.b, audioPlayData2.volume, fVar2.c, (audioPlayData2.start * 1.0f) / 1000.0f, ((audioPlayData2.end - audioPlayData2.start) * 1.0f) / 1000.0f, equals, new ng9.a(multiAudioMixerListener, i8, i9, sb, audioPlayData2, str6) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int val$currentProAfterBit;
                                public final /* synthetic */ AudioPlayData val$data;
                                public final /* synthetic */ StringBuilder val$errorMsg;
                                public final /* synthetic */ int val$finalItemProgress;
                                public final /* synthetic */ MultiAudioMixerListener val$listener;
                                public final /* synthetic */ String val$unifyPropertyAACPath;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {multiAudioMixerListener, Integer.valueOf(i8), Integer.valueOf(i9), sb, audioPlayData2, str6};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i11 = newInitContext.flag;
                                        if ((i11 & 1) != 0) {
                                            int i12 = i11 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$listener = multiAudioMixerListener;
                                    this.val$finalItemProgress = i8;
                                    this.val$currentProAfterBit = i9;
                                    this.val$errorMsg = sb;
                                    this.val$data = audioPlayData2;
                                    this.val$unifyPropertyAACPath = str6;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
                                /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
                                /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                @Override // com.baidu.tieba.ng9.a
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void onCompletion() {
                                    long j;
                                    MediaMetadataRetriever mediaMetadataRetriever;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        AudioPlayData audioPlayData3 = this.val$data;
                                        String str7 = this.val$unifyPropertyAACPath;
                                        audioPlayData3.audioPath = str7;
                                        try {
                                            j = lh9.b(str7);
                                            try {
                                                qg9.e("VideoMuxer", "after ffmpege duration1 = " + j);
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
                                                mediaMetadataRetriever.setDataSource(this.val$data.audioPath);
                                                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                                                j = Long.parseLong(extractMetadata);
                                                qg9.e("VideoMuxer", "after ffmpege duration2 = " + extractMetadata);
                                                mediaMetadataRetriever.release();
                                            } catch (Exception unused4) {
                                                mediaMetadataRetriever2 = mediaMetadataRetriever;
                                                if (mediaMetadataRetriever2 != null) {
                                                    mediaMetadataRetriever2.release();
                                                }
                                                if (j > 0) {
                                                }
                                                this.val$data.start = 0;
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
                                            AudioPlayData audioPlayData4 = this.val$data;
                                            audioPlayData4.end -= audioPlayData4.start;
                                        } else {
                                            this.val$data.end = (int) j;
                                        }
                                        this.val$data.start = 0;
                                        synchronized (VLogMultiAudioMixer.lockObject) {
                                            VLogMultiAudioMixer.lockObject.notifyAll();
                                        }
                                    }
                                }

                                @Override // com.baidu.tieba.ng9.a
                                public boolean onError(int i11, int i12, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i11, i12, obj)) == null) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(",ffmpegerror:");
                                        sb4.append(i11);
                                        sb4.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                        sb4.append(i12);
                                        sb4.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                        sb4.append(obj != null ? obj.toString() : "");
                                        String sb5 = sb4.toString();
                                        StringBuilder sb6 = this.val$errorMsg;
                                        if (sb6 != null) {
                                            sb6.append(sb5);
                                        }
                                        synchronized (VLogMultiAudioMixer.lockObject) {
                                            VLogMultiAudioMixer.lockObject.notifyAll();
                                        }
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }

                                @Override // com.baidu.tieba.ng9.a
                                public boolean onInfo(int i11, int i12, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i11, i12, obj)) == null) {
                                        MultiAudioMixerListener multiAudioMixerListener2 = this.val$listener;
                                        if (multiAudioMixerListener2 == null || i11 != 1001) {
                                            return false;
                                        }
                                        int i13 = this.val$currentProAfterBit + ((int) (((i12 * 1.0f) / 100.0f) * this.val$finalItemProgress));
                                        multiAudioMixerListener2.mixerProgress(i13);
                                        qg9.e(VLogMultiAudioMixer.TAG, "PROGRESS_UNIFY - other property - 阶段， finalItemProgress = " + this.val$finalItemProgress + " i1 = " + i12 + "当前进度：" + i13);
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }
                            });
                            qg9.e("VideoMuxer", "resampledone");
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
                            qg9.e("VideoMuxer", "resampledone-nextstep");
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
                    int i11 = i9 + i8;
                    multiAudioMixerListener.mixerProgress(i11);
                    qg9.e(TAG, "PROGRESS_UNIFY - 阶段，当前进度：" + i11);
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
