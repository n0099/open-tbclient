package com.baidu.ugc.editvideo.editvideo.muxer;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.l.d.f;
import c.a.x0.l.d.g;
import c.a.x0.s.a;
import c.a.x0.t.c;
import c.a.x0.t.m;
import c.a.x0.t.n;
import c.a.x0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public interface MultiAudioMixerListener {
        void mixerProgress(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean appendAacList(List<AudioPlayData> list, String str, c.a.x0.m.a aVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, list, str, aVar)) == null) {
            Movie movie = new Movie();
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                AudioPlayData audioPlayData = list.get(i2);
                if (audioPlayData == null || !jointAACList(linkedList, audioPlayData.audioPath, audioPlayData.start, audioPlayData.end, aVar)) {
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
                } catch (Exception e2) {
                    aVar.f31016e += e2.getMessage();
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
            for (int i2 = 0; i2 < list.size(); i2++) {
                AudioPlayData audioPlayData = list.get(i2);
                if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath)) {
                    audioPlayData.audioPath = str;
                    audioPlayData.volume = 1.0f;
                }
            }
        }
    }

    public static void changeAACListBlankAudioPath(List<AudioPlayData> list, List<AudioPlayData> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, list, list2, str) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AudioPlayData audioPlayData = list.get(i2);
                if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath)) {
                    audioPlayData.audioPath = str;
                    audioPlayData.volume = 1.0f;
                }
            }
            for (int i3 = 0; i3 < list2.size(); i3++) {
                AudioPlayData audioPlayData2 = list2.get(i3);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) == null) {
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
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) == null) {
                    return false;
                }
            }
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (list2.get(i3) == null) {
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
                for (int i2 = 0; i2 < list.size(); i2++) {
                    AudioPlayData audioPlayData = list.get(i2);
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
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: Exception -> 0x0223, TryCatch #3 {Exception -> 0x0223, blocks: (B:19:0x0044, B:21:0x004a, B:28:0x0064, B:33:0x00ad, B:35:0x00c0, B:36:0x00d9, B:47:0x010b, B:10:0x0018, B:11:0x0025, B:13:0x002b), top: B:87:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean clipAacFile(String str, String str2, long j2, long j3, StringBuilder sb) {
        InterceptResult invokeCommon;
        Track track;
        Movie movie;
        Movie movie2;
        String str3;
        String str4;
        long j4;
        long j5;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), sb})) == null) {
            long j6 = j3;
            StringBuilder sb2 = sb;
            char c2 = 0;
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
                    } catch (Exception e2) {
                        e = e2;
                        if (sb2 != null) {
                        }
                        e.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception unused2) {
            }
            if (track != null) {
                if (sb2 != null) {
                    sb2.append(" mp4parser 音频合成没有找到aac音频-1 ");
                }
                return false;
            }
            Movie movie3 = new Movie();
            long d2 = x.d(track);
            long j7 = d2 - j6;
            long j8 = 0;
            long j9 = j7 <= 0 ? d2 : j7;
            if (j9 <= 0) {
                if (sb2 != null) {
                    sb2.append(" clipAacFile 音频合成过程中发生异常: ");
                    sb2.append(" 音频可用时长异常");
                    sb2.append(" 详细信息:");
                    sb2.append("canUseAacDuration:" + j9 + ",aacDuration" + d2 + ",audioStartTimeS" + j6);
                }
                return false;
            }
            String str5 = PreferencesUtil.RIGHT_MOUNT;
            String str6 = ",";
            int i2 = 1;
            int i3 = (j2 > j9 ? 1 : (j2 == j9 ? 0 : -1));
            try {
                if (i3 < 0) {
                    long e3 = x.e(track, (j6 * 1.0d) / 1000.0d);
                    long e4 = x.e(track, ((j6 + j2) * 1.0d) / 1000.0d);
                    if (isDebug) {
                        String str7 = "muxAacMp4 videoDuration < aacDuration (aac from to)=[" + e3 + "," + e4 + PreferencesUtil.RIGHT_MOUNT;
                    }
                    movie3.addTrack(new AppendTrack(new CroppedTrack(track, e3, e4)));
                    movie = movie3;
                } else if (i3 > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    long j10 = 0;
                    while (j10 < j2) {
                        long j11 = j2 - j10;
                        if (j11 >= j9) {
                            if (j6 == j8) {
                                Track[] trackArr = new Track[i2];
                                trackArr[c2] = track;
                                arrayList2.add(new AppendTrack(trackArr));
                                movie2 = movie3;
                                str3 = str5;
                                str4 = str6;
                                j4 = j9;
                                j5 = d2;
                                arrayList = arrayList2;
                            } else {
                                long e5 = x.e(track, (j6 * 1.0d) / 1000.0d);
                                long e6 = x.e(track, (d2 * 1.0d) / 1000.0d);
                                j5 = d2;
                                arrayList = arrayList2;
                                str3 = str5;
                                movie2 = movie3;
                                str4 = str6;
                                j4 = j9;
                                arrayList.add(new AppendTrack(new CroppedTrack(track, e5, e6)));
                            }
                            j10 += j4;
                        } else {
                            movie2 = movie3;
                            str3 = str5;
                            str4 = str6;
                            j4 = j9;
                            j5 = d2;
                            arrayList = arrayList2;
                            long e7 = x.e(track, (j6 * 1.0d) / 1000.0d);
                            long e8 = x.e(track, ((j6 + j11) * 1.0d) / 1000.0d);
                            arrayList.add(new AppendTrack(new CroppedTrack(track, e7, e8)));
                            if (isDebug) {
                                String str8 = "muxAacMp4 videoDuration > aacDuration (audio from to)=[" + e7 + str4 + e8 + str3;
                            }
                            j10 += j11;
                        }
                        j6 = j3;
                        str5 = str3;
                        str6 = str4;
                        arrayList2 = arrayList;
                        j9 = j4;
                        d2 = j5;
                        c2 = 0;
                        i2 = 1;
                        j8 = 0;
                        movie3 = movie2;
                    }
                    ArrayList arrayList3 = arrayList2;
                    movie = movie3;
                    movie.addTrack(new AppendTrack((Track[]) arrayList3.toArray(new Track[arrayList3.size()])));
                } else {
                    movie = movie3;
                    movie.addTrack(track);
                    boolean z = isDebug;
                }
                Container build = new DefaultMp4Builder().build(movie);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                build.writeContainer(fileOutputStream.getChannel());
                fileOutputStream.close();
                long a2 = n.a(str2);
                if (a2 <= 0) {
                    if (sb != null) {
                        sb.append(", mp4parser afterDuration:");
                        sb.append(a2);
                        return false;
                    }
                    return false;
                }
                return true;
            } catch (Exception e9) {
                e = e9;
                sb2 = sb;
                if (sb2 != null) {
                    sb2.append(" mp4parser 音频合成过程中发生异常-1:");
                    sb2.append(e.getMessage());
                    sb2.append(" 详细信息-1 :");
                    sb2.append(m.g(e));
                }
                e.printStackTrace();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static int getBlankAudioDuration(List<AudioPlayData> list) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return -1;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                AudioPlayData audioPlayData = list.get(i4);
                if (audioPlayData != null && !FileUtils.isExists(audioPlayData.audioPath) && (i2 = audioPlayData.end - audioPlayData.start) > i3) {
                    i3 = i2;
                }
            }
            return i3;
        }
        return invokeL.intValue;
    }

    public static int getBlankAudioDuration(List<AudioPlayData> list, List<AudioPlayData> list2) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, list, list2)) == null) {
            if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
                return -1;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                AudioPlayData audioPlayData = list.get(i5);
                if (audioPlayData != null && TextUtils.isEmpty(audioPlayData.audioPath) && (i3 = audioPlayData.end - audioPlayData.start) > i4) {
                    i4 = i3;
                }
            }
            for (int i6 = 0; i6 < list2.size(); i6++) {
                AudioPlayData audioPlayData2 = list2.get(i6);
                if (audioPlayData2 != null && TextUtils.isEmpty(audioPlayData2.audioPath) && (i2 = audioPlayData2.end - audioPlayData2.start) > i4) {
                    i4 = i2;
                }
            }
            return i4;
        }
        return invokeLL.intValue;
    }

    public static boolean getNearestBlankAudioPath(List<List<AudioPlayData>> list, int i2, String str, c.a.x0.m.a aVar) {
        InterceptResult invokeLILL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65548, null, list, i2, str, aVar)) == null) {
            if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
                sb = new StringBuilder();
                sb.append(aVar.f31016e);
                sb.append("list 为空, or outPath 为空");
            } else {
                AudioPlayData audioPlayData = null;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    List<AudioPlayData> list2 = list.get(i3);
                    if (list2 != null && list2.size() > 0) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= list2.size()) {
                                break;
                            }
                            AudioPlayData audioPlayData2 = list2.get(i4);
                            if (audioPlayData2 != null && !TextUtils.isEmpty(audioPlayData2.audioPath)) {
                                int f2 = n.f(audioPlayData2.audioPath);
                                audioPlayData2.realDuration = f2;
                                if (f2 <= 0) {
                                    continue;
                                } else if (f2 == i2) {
                                    audioPlayData = audioPlayData2;
                                    break;
                                } else if (audioPlayData == null || Math.abs(audioPlayData.realDuration - i2) > Math.abs(audioPlayData2.realDuration - i2)) {
                                    audioPlayData = audioPlayData2;
                                }
                            }
                            i4++;
                        }
                    }
                }
                if (audioPlayData != null && audioPlayData.realDuration != 0) {
                    c.e(TAG, "blank 音频路径" + audioPlayData.audioPath);
                    f.C1425f e2 = f.e(audioPlayData.audioPath);
                    if (e2 == null) {
                        e2 = new f.C1425f();
                    }
                    boolean[] zArr = {false};
                    try {
                        f.l(audioPlayData.audioPath, str, e2.f30982a, e2.f30983b, 0.0f, e2.f30984c, 0.0f, (i2 * 1.0f) / 1000.0f, "audio/mpeg".equals(e2.f30985d), new a.InterfaceC1436a(aVar, zArr) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ c.a.x0.m.a val$errorLogInfo;
                            public final /* synthetic */ boolean[] val$isSuccess;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {aVar, zArr};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$errorLogInfo = aVar;
                                this.val$isSuccess = zArr;
                            }

                            @Override // c.a.x0.s.a.InterfaceC1436a
                            public void onCompletion() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$isSuccess[0] = true;
                                    synchronized (VLogMultiAudioMixer.lockObject) {
                                        VLogMultiAudioMixer.lockObject.notifyAll();
                                    }
                                }
                            }

                            @Override // c.a.x0.s.a.InterfaceC1436a
                            public boolean onError(int i5, int i6, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5, i6, obj)) == null) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(",ffmpegerror:");
                                    sb2.append(i5);
                                    sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                    sb2.append(i6);
                                    sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                    sb2.append(obj != null ? obj.toString() : "");
                                    String sb3 = sb2.toString();
                                    c.a.x0.m.a aVar2 = this.val$errorLogInfo;
                                    if (aVar2 != null) {
                                        aVar2.f31016e = this.val$errorLogInfo.f31016e + sb3;
                                    }
                                    synchronized (VLogMultiAudioMixer.lockObject) {
                                        VLogMultiAudioMixer.lockObject.notifyAll();
                                    }
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }

                            @Override // c.a.x0.s.a.InterfaceC1436a
                            public boolean onInfo(int i5, int i6, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i5, i6, obj)) == null) {
                                    c.e(VLogMultiAudioMixer.TAG, " 进行blank 音量文件生成 进度i1 = " + i6);
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }
                        });
                        c.e("VideoMuxer", "resampledone");
                        try {
                            synchronized (lockObject) {
                                lockObject.wait();
                            }
                            if (zArr[0] && FileUtils.isExists(str)) {
                                c.e(TAG, "blank volume 生成成功");
                                return true;
                            }
                            aVar.f31016e += " ffmpeg 调整音量失败了-2 ";
                            return false;
                        } catch (InterruptedException e3) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(aVar.f31016e);
                            sb2.append(e3);
                            aVar.f31016e = sb2.toString() != null ? e3.getMessage() : " ffmpeg 调整音量失败了-1 ";
                            return false;
                        }
                    } catch (Throwable th) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(aVar.f31016e);
                        sb3.append(th);
                        aVar.f31016e = sb3.toString() != null ? th.getMessage() : " ffmpeg 调整音量失败了-3 ";
                        return false;
                    }
                }
                sb = new StringBuilder();
                sb.append(aVar.f31016e);
                sb.append("音频源筛选为null or realDuration==0, closeTarget=");
                sb.append(audioPlayData);
            }
            aVar.f31016e = sb.toString();
            return false;
        }
        return invokeLILL.booleanValue;
    }

    public static boolean jointAACList(List<Track> list, String str, long j2, long j3, c.a.x0.m.a aVar) {
        InterceptResult invokeCommon;
        Track track;
        long j4;
        long j5;
        long j6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{list, str, Long.valueOf(j2), Long.valueOf(j3), aVar})) == null) {
            long j7 = j2;
            c.e("VideoMuxer", "jointAACList" + str);
            StringBuilder sb = new StringBuilder();
            if (list == null || TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            try {
                if (j7 > j3) {
                    return false;
                }
                try {
                    long f2 = n.f(str);
                    f.C1425f e2 = f.e(str);
                    sb.append(" , 音频duration=");
                    sb.append(f2);
                    if (e2 != null) {
                        sb.append(" , 音频format : ");
                        sb.append(" , bitWidth=");
                        sb.append(e2.f30984c);
                        sb.append(" , channelCount=");
                        sb.append(e2.f30983b);
                        sb.append(" , mime=");
                        sb.append(e2.f30985d);
                        sb.append(" , sampleRate=");
                        sb.append(e2.f30982a);
                    }
                } catch (Exception e3) {
                    sb.append(m.g(e3));
                }
                Track track2 = null;
                long j8 = j3 - j7;
                try {
                    track = new AACTrackImpl(new FileDataSourceImpl(str));
                } catch (Exception e4) {
                    sb.append(" ,aacTrack error ");
                    sb.append(m.g(e4));
                    for (Track track3 : MovieCreator.build(str).getTracks()) {
                        if (track3 != null && "soun".equals(track3.getHandler())) {
                            track2 = track3;
                        }
                    }
                    track = track2;
                }
                if (track == null) {
                    if (aVar != null) {
                        aVar.f31016e += " mp4parser 音频合成没有找到aac音频-2  " + sb.toString();
                    }
                    return false;
                }
                long d2 = x.d(track);
                long j9 = d2 - j7;
                if (j9 < 0) {
                    j9 = d2;
                }
                if (isDebug) {
                    String str2 = "视频拼接- aacDuration" + d2 + " ,audioStartTimeS=" + j7 + " , canUseAacDuration" + j9;
                }
                int i2 = (j8 > j9 ? 1 : (j8 == j9 ? 0 : -1));
                if (i2 <= 0) {
                    list.add(new AppendTrack(new CroppedTrack(track, x.e(track, (j7 * 1.0d) / 1000.0d), x.e(track, ((j7 + j8) * 1.0d) / 1000.0d))));
                    return true;
                } else if (i2 <= 0) {
                    list.add(new AppendTrack(track));
                    boolean z = isDebug;
                    return true;
                } else {
                    long j10 = 0;
                    while (j10 < j8) {
                        if (isDebug) {
                            String str3 = "finalAudioDuration = " + j10 + " , targetDuration" + j8;
                        }
                        long j11 = j8 - j10;
                        if (j11 >= j9) {
                            if (j7 == 0) {
                                j4 = j8;
                                list.add(new AppendTrack(track));
                                j5 = j9;
                                j6 = d2;
                            } else {
                                j4 = j8;
                                j5 = j9;
                                j6 = d2;
                                list.add(new AppendTrack(new CroppedTrack(track, x.e(track, (j7 * 1.0d) / 1000.0d), x.e(track, (d2 * 1.0d) / 1000.0d))));
                            }
                            j10 += j5;
                        } else {
                            j4 = j8;
                            j5 = j9;
                            j6 = d2;
                            long e5 = x.e(track, (j7 * 1.0d) / 1000.0d);
                            long e6 = x.e(track, ((j7 + j11) * 1.0d) / 1000.0d);
                            list.add(new AppendTrack(new CroppedTrack(track, e5, e6)));
                            if (isDebug) {
                                String str4 = "muxAacMp4 videoDuration > aacDuration (audio from to)=[" + e5 + "," + e6 + PreferencesUtil.RIGHT_MOUNT;
                            }
                            j10 += j11;
                        }
                        j7 = j2;
                        j8 = j4;
                        j9 = j5;
                        d2 = j6;
                    }
                    return true;
                }
            } catch (Exception e7) {
                if (aVar != null) {
                    aVar.f31016e += sb.toString() + " mp4parser 音频合成过程中发生异常-2:" + e7.getMessage() + " 详细信息：" + m.g(e7);
                }
                e7.printStackTrace();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean mixtureAACFileList(List<AudioPlayData> list, String str, String str2, MultiAudioMixerListener multiAudioMixerListener, c.a.x0.m.a aVar) {
        InterceptResult invokeLLLLL;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65550, null, list, str, str2, multiAudioMixerListener, aVar)) == null) {
            removeAndCorrectErrorData(list);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.addAll(list);
            if (!checkAACList(arrayList)) {
                aVar.f31016e += "数据源错误-1";
                return false;
            }
            boolean z = isDebug;
            int blankAudioDuration = getBlankAudioDuration(arrayList);
            c.e("AudioMuxCostTime", "getBlankAudioDuration:" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (multiAudioMixerListener != null) {
                c.e(TAG, "UPROGRESS_CALCULATE 阶段，当前进度：5");
                multiAudioMixerListener.mixerProgress(5);
            }
            if (blankAudioDuration < 0) {
                aVar.f31016e += "数据源错误-2";
                if (multiAudioMixerListener != null) {
                    c.e(TAG, "PROGRESS_ERROR 阶段 1，当前进度：100" + aVar.f31016e);
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            }
            if (blankAudioDuration == 0) {
                if (multiAudioMixerListener != null) {
                    c.e(TAG, "PROGRESS_BLANK 阶段--单list--blank 0，当前进度：10");
                    multiAudioMixerListener.mixerProgress(10);
                }
                boolean updateAACListVolume = updateAACListVolume(arrayList, null, "", str2, 5, 60, multiAudioMixerListener, new StringBuilder());
                c.e("AudioMuxCostTime", "updateAACListVolume:" + (System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                if (!updateAACListVolume) {
                    aVar.f31016e += sb2.toString();
                    if (multiAudioMixerListener != null) {
                        c.e(TAG, "PROGRESS_ERROR 阶段 2，当前进度：100" + aVar.f31016e);
                        multiAudioMixerListener.mixerProgress(100);
                        return false;
                    }
                    return false;
                }
                if (multiAudioMixerListener != null) {
                    c.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                    multiAudioMixerListener.mixerProgress(60);
                }
                boolean z2 = isDebug;
                try {
                    boolean appendAacList = appendAacList(arrayList, str, aVar);
                    c.e("AudioMuxCostTime", "appendAacList:" + (System.currentTimeMillis() - currentTimeMillis3));
                    if (multiAudioMixerListener != null) {
                        c.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                        multiAudioMixerListener.mixerProgress(70);
                    }
                    if (isDebug) {
                        String str3 = "appendAacList " + appendAacList;
                    }
                    File file = new File(str);
                    if (appendAacList && file.exists()) {
                        if (isDebug) {
                            String str4 = "appendAacList 拼接成功-文件路径：" + str + " , file size = " + file.length();
                        }
                        if (multiAudioMixerListener != null) {
                            c.e(TAG, "PROGRESS_SUCCESS 阶段，当前进度：100");
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return true;
                    }
                    aVar.f31016e += "拼接文件不存在-1";
                    boolean z3 = isDebug;
                    if (multiAudioMixerListener != null) {
                        c.e(TAG, "PROGRESS_ERROR 阶段 4，当前进度：100" + aVar.f31016e);
                        multiAudioMixerListener.mixerProgress(100);
                        return false;
                    }
                    return false;
                } catch (IOException e2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(aVar.f31016e);
                    sb3.append(e2);
                    aVar.f31016e = sb3.toString() != null ? e2.getMessage() : "";
                    if (multiAudioMixerListener != null) {
                        c.e(TAG, "PROGRESS_ERROR 阶段 3，当前进度：100" + aVar.f31016e);
                        multiAudioMixerListener.mixerProgress(100);
                        return false;
                    }
                    return false;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(list);
            String str5 = str2 + "/blank_" + System.currentTimeMillis() + ".aac";
            boolean nearestBlankAudioPath = getNearestBlankAudioPath(arrayList2, blankAudioDuration, str5, aVar);
            c.c(TAG, "getNearestBlankAudioPath - 返回 " + nearestBlankAudioPath + " maxBlankDuration =" + blankAudioDuration);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("getNearestBlankAudioPath1:");
            sb4.append(System.currentTimeMillis() - currentTimeMillis2);
            c.e("AudioMuxCostTime", sb4.toString());
            long currentTimeMillis4 = System.currentTimeMillis();
            File file2 = new File(str5);
            if (!nearestBlankAudioPath || !file2.exists()) {
                if (multiAudioMixerListener != null) {
                    String str6 = "当前进度 ：100错误信息" + aVar.f31016e;
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
            if (multiAudioMixerListener != null) {
                c.e(TAG, "PROGRESS_BLANK 阶段单list--blank >0，当前进度：10");
                multiAudioMixerListener.mixerProgress(10);
            }
            changeAACListBlankAudioPath(arrayList, str5);
            boolean updateAACListVolume2 = updateAACListVolume(arrayList, null, str5, str2, 5, 60, multiAudioMixerListener, new StringBuilder());
            if (isDebug) {
                String str7 = "changeVolumeSuccess ：" + updateAACListVolume2;
            }
            c.e("AudioMuxCostTime", "updateAACListVolume1:" + (System.currentTimeMillis() - currentTimeMillis4));
            long currentTimeMillis5 = System.currentTimeMillis();
            if (!updateAACListVolume2) {
                aVar.f31016e += sb.toString();
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
            if (multiAudioMixerListener != null) {
                c.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                multiAudioMixerListener.mixerProgress(60);
            }
            try {
                appendAacList(arrayList, str, aVar);
                c.e("AudioMuxCostTime", "appendAacList1:" + (System.currentTimeMillis() - currentTimeMillis5));
                if (new File(str).exists()) {
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return true;
                }
                aVar.f31016e += "拼接文件不存在-2";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            } catch (IOException e3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(aVar.f31016e);
                sb5.append(e3);
                aVar.f31016e = sb5.toString() != null ? e3.getMessage() : "";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                    return false;
                }
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean mixtureAACFileList(List<AudioPlayData> list, List<AudioPlayData> list2, String str, String str2, MultiAudioMixerListener multiAudioMixerListener, c.a.x0.m.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{list, list2, str, str2, multiAudioMixerListener, aVar})) == null) {
            removeAndCorrectErrorData(list, list2);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.clear();
            arrayList2.clear();
            arrayList.addAll(list);
            arrayList2.addAll(list2);
            if (checkListVolumeAllZero(arrayList)) {
                c.e(TAG, " video 音频数据全为zero , 直接走 audio 单集合方法  ");
                return mixtureAACFileList(arrayList2, str, str2, multiAudioMixerListener, aVar);
            } else if (checkListVolumeAllZero(arrayList2)) {
                c.e(TAG, " audio 音频数据全为zero , 直接走 video 单集合方法  ");
                return mixtureAACFileList(arrayList, str, str2, multiAudioMixerListener, aVar);
            } else if (!checkAACList(arrayList, arrayList2)) {
                aVar.f31016e += "数据源错误-3";
                if (multiAudioMixerListener != null) {
                    multiAudioMixerListener.mixerProgress(100);
                }
                return false;
            } else {
                int blankAudioDuration = getBlankAudioDuration(arrayList, arrayList2);
                if (multiAudioMixerListener != null) {
                    c.e(TAG, "PROGRESS_CALCULATE 阶段，当前进度：5");
                    multiAudioMixerListener.mixerProgress(5);
                }
                if (blankAudioDuration < 0) {
                    aVar.f31016e += "数据源错误-4";
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                if (blankAudioDuration == 0) {
                    if (multiAudioMixerListener != null) {
                        c.e(TAG, "PROGRESS_BLANK 阶段--双 list--blank=0，当前进度：10");
                        multiAudioMixerListener.mixerProgress(10);
                    }
                    StringBuilder sb = new StringBuilder();
                    if (!updateAACListVolume(arrayList, arrayList2, "", str2, 5, 60, multiAudioMixerListener, sb)) {
                        aVar.f31016e += sb.toString();
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                    c.e("AudioMuxCostTime", "updateAACListVolume2:" + (System.currentTimeMillis() - currentTimeMillis));
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (multiAudioMixerListener != null) {
                        c.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                        multiAudioMixerListener.mixerProgress(60);
                    }
                    String str3 = str2 + "/video_joint_" + System.currentTimeMillis() + ".aac";
                    String str4 = str2 + "/audio_joint_" + System.currentTimeMillis() + ".aac";
                    try {
                        appendAacList(arrayList, str3, aVar);
                        c.e("AudioMuxCostTime", "videoTempListappendAacList2:" + (System.currentTimeMillis() - currentTimeMillis2));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        try {
                            appendAacList(arrayList2, str4, aVar);
                            c.e("AudioMuxCostTime", "audioTempListappendAacList2:" + (System.currentTimeMillis() - currentTimeMillis3));
                            long currentTimeMillis4 = System.currentTimeMillis();
                            File file = new File(str3);
                            File file2 = new File(str4);
                            if (!file.exists() || !file2.exists()) {
                                aVar.f31016e += "拼接文件不存在-3";
                                if (multiAudioMixerListener != null) {
                                    multiAudioMixerListener.mixerProgress(100);
                                }
                                return false;
                            }
                            if (multiAudioMixerListener != null) {
                                c.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                                multiAudioMixerListener.mixerProgress(70);
                            }
                            boolean h2 = g.h(str, new String[]{str4, str3}, sb, new a.InterfaceC1436a(multiAudioMixerListener) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.1
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
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$listener = multiAudioMixerListener;
                                }

                                @Override // c.a.x0.s.a.InterfaceC1436a
                                public void onCompletion() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    }
                                }

                                @Override // c.a.x0.s.a.InterfaceC1436a
                                public boolean onError(int i2, int i3, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }

                                @Override // c.a.x0.s.a.InterfaceC1436a
                                public boolean onInfo(int i2, int i3, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                                        MultiAudioMixerListener multiAudioMixerListener2 = this.val$listener;
                                        if (multiAudioMixerListener2 == null || i2 != 1001) {
                                            return false;
                                        }
                                        int i4 = (int) ((((i3 * 30) * 1.0f) / 100.0f) + 70.0f);
                                        multiAudioMixerListener2.mixerProgress(i4);
                                        c.e(VLogMultiAudioMixer.TAG, "mixAudioByFFmpeg 处理进度：" + i3 + "整体进度" + i4);
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }
                            });
                            c.e("AudioMuxCostTime", "mixAudioByFFmpeg2:" + (System.currentTimeMillis() - currentTimeMillis4));
                            long currentTimeMillis5 = System.currentTimeMillis();
                            if (!h2) {
                                h2 = g.i(str, new float[]{1.0f, 1.0f}, new long[]{0, 0}, new long[]{-1, -1}, new String[]{str4, str3}, sb);
                            }
                            c.e("AudioMuxCostTime", "mixingAudio2:" + (System.currentTimeMillis() - currentTimeMillis5));
                            System.currentTimeMillis();
                            if (h2) {
                                if (multiAudioMixerListener != null) {
                                    multiAudioMixerListener.mixerProgress(100);
                                }
                                return true;
                            }
                            aVar.f31016e += sb.toString();
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        } catch (IOException e2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(aVar.f31016e);
                            sb2.append(e2);
                            aVar.f31016e = sb2.toString() != null ? e2.getMessage() : "";
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        }
                    } catch (IOException e3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(aVar.f31016e);
                        sb3.append(e3);
                        aVar.f31016e = sb3.toString() != null ? e3.getMessage() : "";
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(arrayList);
                arrayList3.add(arrayList2);
                String str5 = str2 + "/blank_" + System.currentTimeMillis() + ".aac";
                String str6 = str2 + "/video_joint_" + System.currentTimeMillis() + ".aac";
                String str7 = str2 + "/audio_joint_" + System.currentTimeMillis() + ".aac";
                boolean nearestBlankAudioPath = getNearestBlankAudioPath(arrayList3, blankAudioDuration, str5, aVar);
                c.e("AudioMuxCostTime", "getNearestBlankAudioPath3:" + (System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis6 = System.currentTimeMillis();
                File file3 = new File(str5);
                if (!nearestBlankAudioPath || !file3.exists()) {
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                if (multiAudioMixerListener != null) {
                    c.e(TAG, "PROGRESS_BLANK 阶段--双 list--blank > 0，当前进度：10");
                    multiAudioMixerListener.mixerProgress(10);
                }
                changeAACListBlankAudioPath(arrayList, arrayList2, str5);
                StringBuilder sb4 = new StringBuilder();
                if (!updateAACListVolume(arrayList, arrayList2, str5, str2, 5, 60, multiAudioMixerListener, sb4)) {
                    aVar.f31016e += sb4.toString();
                    if (multiAudioMixerListener != null) {
                        multiAudioMixerListener.mixerProgress(100);
                    }
                    return false;
                }
                c.e("AudioMuxCostTime", "updateAACListVolume3:" + (System.currentTimeMillis() - currentTimeMillis6));
                long currentTimeMillis7 = System.currentTimeMillis();
                if (multiAudioMixerListener != null) {
                    c.e(TAG, "PROGRESS_UNIFY 阶段，当前进度：60");
                    multiAudioMixerListener.mixerProgress(60);
                }
                try {
                    appendAacList(arrayList, str6, aVar);
                    c.e("AudioMuxCostTime", "videoTempListappendAacList3:" + (System.currentTimeMillis() - currentTimeMillis7));
                    long currentTimeMillis8 = System.currentTimeMillis();
                    try {
                        appendAacList(arrayList2, str7, aVar);
                        c.e("AudioMuxCostTime", "audioTempListappendAacList3:" + (System.currentTimeMillis() - currentTimeMillis8));
                        long currentTimeMillis9 = System.currentTimeMillis();
                        File file4 = new File(str6);
                        File file5 = new File(str7);
                        if (!file4.exists() || !file5.exists()) {
                            aVar.f31016e += "拼接文件不存在-4";
                            if (multiAudioMixerListener != null) {
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return false;
                        }
                        if (multiAudioMixerListener != null) {
                            c.e(TAG, "PROGRESS_APPEND 阶段，当前进度：70");
                            multiAudioMixerListener.mixerProgress(70);
                        }
                        boolean h3 = g.h(str, new String[]{str7, str6}, sb4, new a.InterfaceC1436a(multiAudioMixerListener) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.2
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
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$listener = multiAudioMixerListener;
                            }

                            @Override // c.a.x0.s.a.InterfaceC1436a
                            public void onCompletion() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                }
                            }

                            @Override // c.a.x0.s.a.InterfaceC1436a
                            public boolean onError(int i2, int i3, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }

                            @Override // c.a.x0.s.a.InterfaceC1436a
                            public boolean onInfo(int i2, int i3, Object obj) {
                                InterceptResult invokeIIL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                                    MultiAudioMixerListener multiAudioMixerListener2 = this.val$listener;
                                    if (multiAudioMixerListener2 == null || i2 != 1001) {
                                        return false;
                                    }
                                    int i4 = (int) ((((i3 * 30) * 1.0f) / 100.0f) + 70.0f);
                                    multiAudioMixerListener2.mixerProgress(i4);
                                    c.e(VLogMultiAudioMixer.TAG, "mixAudioByFFmpeg 处理进度：" + i3 + "整体进度" + i4);
                                    return false;
                                }
                                return invokeIIL.booleanValue;
                            }
                        });
                        c.e("AudioMuxCostTime", "mixAudioByFFmpeg3:" + (System.currentTimeMillis() - currentTimeMillis9));
                        long currentTimeMillis10 = System.currentTimeMillis();
                        if (!h3) {
                            h3 = g.i(str, new float[]{1.0f, 1.0f}, new long[]{0, 0}, new long[]{-1, -1}, new String[]{str7, str6}, sb4);
                        }
                        c.e("AudioMuxCostTime", "mixingAudio3:" + (System.currentTimeMillis() - currentTimeMillis10));
                        if (h3) {
                            if (multiAudioMixerListener != null) {
                                c.e(TAG, "混音 阶段，当前进度：100");
                                multiAudioMixerListener.mixerProgress(100);
                            }
                            return true;
                        }
                        aVar.f31016e += sb4.toString();
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    } catch (IOException e4) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(aVar.f31016e);
                        sb5.append(e4);
                        aVar.f31016e = sb5.toString() != null ? e4.getMessage() : "";
                        if (multiAudioMixerListener != null) {
                            multiAudioMixerListener.mixerProgress(100);
                        }
                        return false;
                    }
                } catch (IOException e5) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(aVar.f31016e);
                    sb6.append(e5);
                    aVar.f31016e = sb6.toString() != null ? e5.getMessage() : "";
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

    /* JADX WARN: Code restructure failed: missing block: B:124:0x030d, code lost:
        r9.append("updateAACListVolume- AudioPlayData 为 null or audioPath为空 ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0314, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean updateAACListVolume(List<AudioPlayData> list, List<AudioPlayData> list2, String str, String str2, int i2, int i3, MultiAudioMixerListener multiAudioMixerListener, StringBuilder sb) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        StringBuilder sb2;
        int i4;
        int i5;
        f.C1425f c1425f;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{list, list2, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), multiAudioMixerListener, sb})) != null) {
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
        char c2 = 0;
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
        c.e(TAG, "defaultFormatAudioPath = " + str3);
        boolean z2 = isDebug;
        f.C1425f e2 = f.e(str3);
        if (e2 == null) {
            e2 = new f.C1425f();
        }
        f.C1425f c1425f2 = e2;
        int size = arrayList2.size();
        int i6 = (i3 - i2) / size;
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                return true;
            }
            AudioPlayData audioPlayData2 = (AudioPlayData) arrayList2.get(i7);
            if (audioPlayData2 == null || !FileUtils.isExists(audioPlayData2.audioPath)) {
                break;
            }
            f.C1425f e3 = f.e(((AudioPlayData) arrayList2.get(i7)).audioPath);
            if (e3 == null) {
                e3 = new f.C1425f();
                z = true;
            } else {
                z = false;
            }
            f.C1425f[] c1425fArr = new f.C1425f[2];
            c1425fArr[c2] = c1425f2;
            c1425fArr[1] = e3;
            boolean i8 = f.i(c1425fArr);
            boolean z3 = !i8 && e3.c();
            boolean z4 = !i8 && e3.a();
            boolean z5 = !i8 && e3.b();
            boolean z6 = audioPlayData2.volume != 1.0f;
            boolean equals = "audio/mpeg".equals(e3.f30985d);
            int i9 = (z4 && (z3 || z5 || z6 || z || equals)) ? i6 / 2 : i6;
            c.e(TAG, "data.audioPath" + audioPlayData2.audioPath + "--audioformat:" + e3.f30982a + "," + e3.f30983b + "," + e3.f30984c + "targetaudioformat:" + c1425f2.f30982a + "," + c1425f2.f30983b + "," + c1425f2.f30984c + "," + e3.c() + "," + e3.a() + "," + e3.b() + "," + z6);
            int i10 = i2 + (i7 * i6);
            if (z3 || z4 || z5 || z6 || z || equals) {
                if (z4) {
                    String str5 = str4 + "/change_bit_" + System.currentTimeMillis() + ".aac";
                    if (!g.p(str5, audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, sb, audioPlayData2.volume, c1425f2, e3) || !FileUtils.isExists(str5)) {
                        return false;
                    }
                    if (multiAudioMixerListener != null) {
                        int i11 = i10 + i9;
                        multiAudioMixerListener.mixerProgress(i11);
                        c.e(TAG, "PROGRESS_UNIFY - ConvertBit -阶段，当前进度：" + i11);
                        i10 = i11;
                    }
                    audioPlayData2.audioPath = str5;
                }
                if (z3 || z5 || z6 || z || equals) {
                    try {
                        c.e("VideoMuxer", "startresample,src:" + e3.f30982a + "dest:" + c1425f2.f30982a);
                        String str6 = str2 + "/unify_property_" + System.currentTimeMillis() + ".aac";
                        i4 = i7;
                        i5 = size;
                        c1425f = c1425f2;
                        arrayList = arrayList2;
                        sb2 = sb3;
                        try {
                            f.l(audioPlayData2.audioPath, str6, c1425f2.f30982a, c1425f2.f30983b, audioPlayData2.volume, c1425f2.f30984c, (audioPlayData2.start * 1.0f) / 1000.0f, ((audioPlayData2.end - audioPlayData2.start) * 1.0f) / 1000.0f, equals, new a.InterfaceC1436a(multiAudioMixerListener, i9, i10, sb, audioPlayData2, str6) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer.3
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
                                        Object[] objArr = {multiAudioMixerListener, Integer.valueOf(i9), Integer.valueOf(i10), sb, audioPlayData2, str6};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i12 = newInitContext.flag;
                                        if ((i12 & 1) != 0) {
                                            int i13 = i12 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$listener = multiAudioMixerListener;
                                    this.val$finalItemProgress = i9;
                                    this.val$currentProAfterBit = i10;
                                    this.val$errorMsg = sb;
                                    this.val$data = audioPlayData2;
                                    this.val$unifyPropertyAACPath = str6;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
                                /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
                                /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                @Override // c.a.x0.s.a.InterfaceC1436a
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void onCompletion() {
                                    long j2;
                                    MediaMetadataRetriever mediaMetadataRetriever;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        AudioPlayData audioPlayData3 = this.val$data;
                                        String str7 = this.val$unifyPropertyAACPath;
                                        audioPlayData3.audioPath = str7;
                                        try {
                                            j2 = x.b(str7);
                                            try {
                                                c.e("VideoMuxer", "after ffmpege duration1 = " + j2);
                                            } catch (Exception unused) {
                                            }
                                        } catch (Exception unused2) {
                                            j2 = 0;
                                        }
                                        if (j2 <= 0) {
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
                                                j2 = Long.parseLong(extractMetadata);
                                                c.e("VideoMuxer", "after ffmpege duration2 = " + extractMetadata);
                                                mediaMetadataRetriever.release();
                                            } catch (Exception unused4) {
                                                mediaMetadataRetriever2 = mediaMetadataRetriever;
                                                if (mediaMetadataRetriever2 != null) {
                                                    mediaMetadataRetriever2.release();
                                                }
                                                if (j2 > 0) {
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
                                        if (j2 > 0) {
                                            AudioPlayData audioPlayData4 = this.val$data;
                                            audioPlayData4.end -= audioPlayData4.start;
                                        } else {
                                            this.val$data.end = (int) j2;
                                        }
                                        this.val$data.start = 0;
                                        synchronized (VLogMultiAudioMixer.lockObject) {
                                            VLogMultiAudioMixer.lockObject.notifyAll();
                                        }
                                    }
                                }

                                @Override // c.a.x0.s.a.InterfaceC1436a
                                public boolean onError(int i12, int i13, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i12, i13, obj)) == null) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(",ffmpegerror:");
                                        sb4.append(i12);
                                        sb4.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                                        sb4.append(i13);
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

                                @Override // c.a.x0.s.a.InterfaceC1436a
                                public boolean onInfo(int i12, int i13, Object obj) {
                                    InterceptResult invokeIIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i12, i13, obj)) == null) {
                                        MultiAudioMixerListener multiAudioMixerListener2 = this.val$listener;
                                        if (multiAudioMixerListener2 == null || i12 != 1001) {
                                            return false;
                                        }
                                        int i14 = this.val$currentProAfterBit + ((int) (((i13 * 1.0f) / 100.0f) * this.val$finalItemProgress));
                                        multiAudioMixerListener2.mixerProgress(i14);
                                        c.e(VLogMultiAudioMixer.TAG, "PROGRESS_UNIFY - other property - 阶段， finalItemProgress = " + this.val$finalItemProgress + " i1 = " + i13 + "当前进度：" + i14);
                                        return false;
                                    }
                                    return invokeIIL.booleanValue;
                                }
                            });
                            c.e("VideoMuxer", "resampledone");
                            try {
                                synchronized (lockObject) {
                                    lockObject.wait();
                                }
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                            if (!TextUtils.equals(str6, audioPlayData2.audioPath)) {
                                sb2.append("ffmpeg 重采样失败了");
                                return false;
                            }
                            c.e("VideoMuxer", "resampledone-nextstep");
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
                    i4 = i7;
                    i5 = size;
                    c1425f = c1425f2;
                    arrayList = arrayList2;
                    sb2 = sb3;
                }
                boolean z7 = isDebug;
            } else {
                if (multiAudioMixerListener != null) {
                    int i12 = i10 + i9;
                    multiAudioMixerListener.mixerProgress(i12);
                    c.e(TAG, "PROGRESS_UNIFY - 阶段，当前进度：" + i12);
                }
                i4 = i7;
                i5 = size;
                c1425f = c1425f2;
                arrayList = arrayList2;
                sb2 = sb3;
            }
            i7 = i4 + 1;
            str4 = str2;
            sb3 = sb2;
            size = i5;
            c1425f2 = c1425f;
            arrayList2 = arrayList;
            c2 = 0;
        }
    }
}
