package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hvb;
import com.baidu.tieba.pwb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import com.coremedia.iso.boxes.Container;
import com.google.android.exoplayer2.util.MimeTypes;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
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
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class nxb {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements pwb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        @Override // com.baidu.tieba.pwb.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        public a(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb;
        }

        @Override // com.baidu.tieba.pwb.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (nxb.a) {
                    nxb.a.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.pwb.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",ffmpegerror i:");
                sb2.append(i);
                sb2.append("i1");
                sb2.append(i2);
                sb2.append("msg:");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = "";
                }
                sb2.append(str);
                sb.append(sb2.toString());
                synchronized (nxb.a) {
                    nxb.a.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements pwb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        @Override // com.baidu.tieba.pwb.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        public b(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb;
        }

        @Override // com.baidu.tieba.pwb.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (nxb.a) {
                    nxb.a.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.pwb.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",ffmpegerror i:");
                sb2.append(i);
                sb2.append("i1");
                sb2.append(i2);
                sb2.append("msg:");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = "";
                }
                sb2.append(str);
                sb.append(sb2.toString());
                synchronized (nxb.a) {
                    nxb.a.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948019249, "Lcom/baidu/tieba/nxb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948019249, "Lcom/baidu/tieba/nxb;");
                return;
            }
        }
        a = new Object();
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Track track;
        Movie movie;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!FileUtils.isExists(str)) {
                return -1L;
            }
            try {
                track = new AACTrackImpl(new FileDataSourceImpl(str));
            } catch (Exception unused) {
                track = null;
                try {
                    movie = MovieCreator.build(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    movie = null;
                }
                if (movie == null) {
                    return -1L;
                }
                for (Track track2 : movie.getTracks()) {
                    if ("soun".equals(track2.getHandler())) {
                        track = track2;
                    }
                }
            }
            if (track == null) {
                return -1L;
            }
            return d(track);
        }
        return invokeL.longValue;
    }

    public static long f(String str) {
        InterceptResult invokeL;
        Movie movie;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!FileUtils.isExists(str)) {
                return -1L;
            }
            Track track = null;
            try {
                try {
                    movie = MovieCreator.build(str);
                } catch (IOException e) {
                    e.printStackTrace();
                    movie = null;
                }
                for (Track track2 : movie.getTracks()) {
                    if ("vide".equals(track2.getHandler())) {
                        track = track2;
                    }
                }
            } catch (Exception unused) {
            }
            if (track == null) {
                return -1L;
            }
            return d(track);
        }
        return invokeL.longValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!FileUtils.checkFile(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            if (FileUtils.checkFile(str2)) {
                return str2;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (Track track : MovieCreator.build(str).getTracks()) {
                    if (track.getHandler().equals("soun")) {
                        arrayList.add(track);
                    }
                }
                Movie movie = new Movie();
                if (arrayList.size() > 0) {
                    movie.addTrack(new AppendTrack((Track[]) arrayList.toArray(new Track[arrayList.size()])));
                    Container build = new DefaultMp4Builder().build(movie);
                    try {
                        FileChannel channel = new RandomAccessFile(str2, "rw").getChannel();
                        build.writeContainer(channel);
                        channel.close();
                    } catch (Exception unused) {
                        swb.e("getAudioFromVideo", "合拍提取音频失败1");
                        return "";
                    }
                }
                return str2;
            } catch (Exception unused2) {
                swb.e("getAudioFromVideo", "合拍提取音频失败2");
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static long d(Track track) {
        InterceptResult invokeL;
        TrackMetaData trackMetaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, track)) == null) {
            if (track == null || (trackMetaData = track.getTrackMetaData()) == null) {
                return 0L;
            }
            long duration = track.getDuration();
            long timescale = trackMetaData.getTimescale();
            if (duration <= 0 || timescale <= 0) {
                return 0L;
            }
            return (((float) duration) * 1000.0f) / ((float) timescale);
        }
        return invokeL.longValue;
    }

    public static long e(Track track, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{track, Double.valueOf(d)})) == null) {
            long j = 0;
            if (track == null) {
                return 0L;
            }
            double d2 = 0.0d;
            TrackMetaData trackMetaData = track.getTrackMetaData();
            if (trackMetaData == null) {
                return 0L;
            }
            long timescale = trackMetaData.getTimescale();
            long[] sampleDurations = track.getSampleDurations();
            if (timescale > 0 && sampleDurations != null) {
                for (long j2 : sampleDurations) {
                    d2 += j2 / timescale;
                    if (d2 >= d) {
                        break;
                    }
                    j++;
                }
            }
            return j;
        }
        return invokeCommon.longValue;
    }

    public static boolean g(StringBuilder sb, String str, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, sb, str, list)) == null) {
            StringBuilder sb2 = new StringBuilder();
            hvb.b(list, str, "", new a(sb2), true, false);
            synchronized (a) {
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sb.append(sb2.toString());
            return TextUtils.isEmpty(sb2.toString());
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(StringBuilder sb, List<String> list, String str, rvb rvbVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, sb, list, str, rvbVar)) == null) {
            boolean z = false;
            if (xwb.e(list)) {
                if (sb != null) {
                    sb.append("原文件列表 inputFileList == null");
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (sb != null) {
                    sb.append("mergeVideo操作，outputFile为空 ");
                }
                return false;
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    if (FileUtils.isExists(list.get(i))) {
                        arrayList.add(list.get(i));
                    }
                }
                if (arrayList.size() < 1) {
                    if (sb != null) {
                        sb.append("原文件列表为空或输出视频路径不合法");
                    }
                    return false;
                } else if (arrayList.size() == 1) {
                    try {
                        return FileUtils.copyFile(list.get(0), str);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } else {
                    boolean g = g(sb, str, arrayList);
                    long j = 0;
                    if (g) {
                        long j2 = 0;
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            j2 += dxb.a((String) arrayList.get(i2));
                        }
                        long a2 = j2 - dxb.a(str);
                        if (Math.abs(a2) >= 1000) {
                            sb.append("ffmpeg duration check error mp4Srcduration - mp4MixerDuration : ");
                            sb.append(a2);
                            g = false;
                        }
                    }
                    if (!g && (g = new bvb(arrayList, str, rvbVar).b(sb))) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            j += dxb.a((String) arrayList.get(i3));
                        }
                        long a3 = j - dxb.a(str);
                        if (Math.abs(a3) >= 1000) {
                            sb.append("extractor duration check error mp4Srcduration - mp4MixerDuration : ");
                            sb.append(a3);
                            if (z) {
                                return i(sb, arrayList, str);
                            }
                            return z;
                        }
                    }
                    z = g;
                    if (z) {
                    }
                }
            }
        } else {
            return invokeLLLL.booleanValue;
        }
    }

    public static boolean i(StringBuilder sb, List<String> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, sb, list, str)) == null) {
            LinkedList<Movie> linkedList = new LinkedList();
            try {
                for (String str2 : list) {
                    linkedList.add(MovieCreator.build(str2));
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Movie movie : linkedList) {
                    for (Track track : movie.getTracks()) {
                        if (track.getHandler().equals("soun")) {
                            arrayList2.add(track);
                        }
                        if (track.getHandler().equals("vide")) {
                            arrayList.add(track);
                        }
                    }
                }
                Movie movie2 = new Movie();
                if (arrayList2.size() > 0) {
                    movie2.addTrack(new AppendTrack((Track[]) arrayList2.toArray(new Track[arrayList2.size()])));
                }
                if (arrayList.size() > 0) {
                    movie2.addTrack(new AppendTrack((Track[]) arrayList.toArray(new Track[arrayList.size()])));
                }
                Container build = new DefaultMp4Builder().build(movie2);
                FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                build.writeContainer(channel);
                channel.close();
                return true;
            } catch (Exception e) {
                if (sb != null) {
                    sb.append("mp4parser 录制视频拼接过程中发生异常:" + e.getMessage());
                }
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean j(StringBuilder sb, String str, String str2, String str3, long j, long j2) {
        InterceptResult invokeCommon;
        boolean l;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{sb, str, str2, str3, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" vDuration:");
                    sb2.append(dxb.f(str2));
                    sb2.append(" , aDuration:");
                    sb2.append(dxb.f(str));
                    usb.a("time_duration_error", sb2.toString(), null);
                } catch (Exception unused) {
                }
                long a2 = dxb.a(str2);
                if (k(sb, str, str2, str3) || (l = l(sb, str, str2, str3, j))) {
                    return true;
                }
                hvb.f e = hvb.e(str);
                if (e != null && MimeTypes.AUDIO_MPEG.equals(e.d)) {
                    String str4 = FileUtils.removeExtention(str) + "mp3toaac.aac";
                    File file = new File(str4);
                    if (j2 > 0 && j2 - j <= a2) {
                        j3 = j2;
                    } else {
                        j3 = a2 + j;
                    }
                    if (sb != null) {
                        sb.append(",startmp3ToAAC");
                    }
                    boolean l2 = ivb.l(str, str4, j, j3, sb);
                    if (sb != null) {
                        sb.append(",mp3ToAACresult:" + l2);
                    }
                    if (!l2) {
                        if (file.exists()) {
                            file.delete();
                        }
                        return false;
                    }
                    l = l(sb, file.getAbsolutePath(), str2, str3, j);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                return l;
            }
            if (sb != null) {
                sb.append("音频合成原文件列表为空或输出视频路径不合法");
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean k(StringBuilder sb, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, sb, str, str2, str3)) == null) {
            if (!FileUtils.checkFile(str) || !FileUtils.checkFile(str2)) {
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            if (sb != null) {
                sb.append(",startmuxAudioVideobyFFmpeg");
            }
            usb.a("av_muxer_by_ffmpeg", "startmuxAudioVideobyFFmpeg", null);
            hvb.m(str2, str, str3, new b(sb2));
            try {
                synchronized (a) {
                    a.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(sb2.toString())) {
                if (sb == null) {
                    return false;
                }
                sb.append(sb2.toString());
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00be A[Catch: Exception -> 0x0294, TryCatch #2 {Exception -> 0x0294, blocks: (B:31:0x00b1, B:33:0x00be, B:34:0x00ca, B:36:0x00d0, B:41:0x00e8, B:43:0x00ee, B:50:0x010f, B:52:0x014a, B:54:0x0157, B:57:0x0167, B:68:0x01a6, B:20:0x0077, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:10:0x005d, B:5:0x000e, B:7:0x002e), top: B:105:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x029a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean l(StringBuilder sb, String str, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        StringBuilder sb2;
        StringBuilder sb3;
        Track track;
        long j2;
        ArrayList arrayList;
        long j3;
        long j4;
        long j5;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{sb, str, str2, str3, Long.valueOf(j)})) == null) {
            StringBuilder sb4 = new StringBuilder();
            char c = 0;
            try {
                try {
                    long f = dxb.f(str);
                    hvb.f e = hvb.e(str);
                    sb4.append(" , 音频duration=");
                    sb4.append(f);
                    sb4.append(" , 视频duration=");
                    sb4.append(dxb.f(str2));
                    if (e != null) {
                        sb4.append(" , 音频format : ");
                        sb4.append(" , bitWidth=");
                        sb4.append(e.c);
                        sb4.append(" , channelCount=");
                        sb4.append(e.b);
                        sb4.append(" , mime=");
                        sb4.append(e.d);
                        sb4.append(" , sampleRate=");
                        sb4.append(e.a);
                    }
                } catch (Exception e2) {
                    sb4.append(cxb.g(e2));
                }
                Track track2 = null;
                try {
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    track = new AACTrackImpl(new FileDataSourceImpl(str));
                } catch (Exception e4) {
                    e = e4;
                    sb4.append(" ,aacTrack error ");
                    sb4.append(e.toString());
                    Track track3 = null;
                    for (Track track4 : MovieCreator.build(str).getTracks()) {
                        if (track4 != null && "soun".equals(track4.getHandler())) {
                            track3 = track4;
                        }
                    }
                    track = track3;
                    if (track != null) {
                    }
                }
                if (track != null) {
                    if (sb != null) {
                        sb.append(" mp4parser 音频合成没有找到aac aacTrack ");
                        sb.append(sb4.toString());
                    }
                    return false;
                }
                for (Track track5 : MovieCreator.build(str2).getTracks()) {
                    if ("vide".equals(track5.getHandler())) {
                        track2 = track5;
                    }
                }
                if (track2 == null) {
                    if (sb != null) {
                        sb.append("mp4parser 音频合成 videoTracks == null");
                    }
                    return false;
                }
                Movie movie = new Movie();
                movie.addTrack(track2);
                long d = d(track2);
                long d2 = d(track);
                long j6 = d2 - j;
                if (j6 <= 0) {
                    j2 = d2;
                } else {
                    j2 = j6;
                }
                if (j2 <= 0) {
                    if (sb != null) {
                        sb.append(" mp4parser 音频合成过程中发生异常: ");
                        sb.append(sb4.toString());
                        sb.append(" 音频可用时长异常");
                        sb.append(" 详细信息:");
                        sb.append("canUseAacDuration:" + j2 + ",aacDuration" + d2 + ",audioStartTimeS" + j);
                    }
                    return false;
                }
                int i = 1;
                if (Math.abs(d - j2) < 100) {
                    movie.addTrack(track);
                } else {
                    int i2 = (d > j2 ? 1 : (d == j2 ? 0 : -1));
                    if (i2 < 0) {
                        movie.addTrack(new AppendTrack(new CroppedTrack(track, e(track, (j * 1.0d) / 1000.0d), e(track, ((j + d) * 1.0d) / 1000.0d))));
                    } else if (i2 > 0) {
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            long j7 = 0;
                            while (j7 < d) {
                                long j8 = d - j7;
                                if (j8 >= j2) {
                                    if (j == 0) {
                                        long j9 = j2;
                                        Track[] trackArr = new Track[i];
                                        trackArr[c] = track;
                                        arrayList2.add(new AppendTrack(trackArr));
                                        j3 = j9;
                                        sb3 = sb4;
                                        arrayList = arrayList2;
                                        j4 = d2;
                                        j5 = d;
                                    } else {
                                        j5 = d;
                                        Track[] trackArr2 = new Track[1];
                                        sb3 = sb4;
                                        arrayList = arrayList2;
                                        j3 = j2;
                                        j4 = d2;
                                        try {
                                            trackArr2[0] = new CroppedTrack(track, e(track, (j * 1.0d) / 1000.0d), e(track, (d2 * 1.0d) / 1000.0d));
                                            arrayList.add(new AppendTrack(trackArr2));
                                        } catch (Exception e5) {
                                            e = e5;
                                            sb2 = sb;
                                            if (sb2 != null) {
                                                sb2.append(" mp4parser 音频合成过程中发生异常-0: ");
                                                sb2.append(",logBuilder: ");
                                                sb2.append(sb3.toString());
                                                sb2.append(",详细信息-0:");
                                                sb2.append(cxb.g(e));
                                            }
                                            e.printStackTrace();
                                            return false;
                                        }
                                    }
                                    j7 += j3;
                                } else {
                                    sb3 = sb4;
                                    arrayList = arrayList2;
                                    j3 = j2;
                                    j4 = d2;
                                    j5 = d;
                                    arrayList.add(new AppendTrack(new CroppedTrack(track, e(track, (j * 1.0d) / 1000.0d), e(track, ((j + j8) * 1.0d) / 1000.0d))));
                                    j7 += j8;
                                }
                                arrayList2 = arrayList;
                                d = j5;
                                sb4 = sb3;
                                j2 = j3;
                                d2 = j4;
                                c = 0;
                                i = 1;
                            }
                            sb3 = sb4;
                            ArrayList arrayList3 = arrayList2;
                            movie.addTrack(new AppendTrack((Track[]) arrayList3.toArray(new Track[arrayList3.size()])));
                            Container build = new DefaultMp4Builder().build(movie);
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
                            build.writeContainer(fileOutputStream.getChannel());
                            fileOutputStream.close();
                            a2 = dxb.a(str3);
                            if (a2 > 0) {
                                if (sb != null) {
                                    sb.append(", mp4parser afterDuration:");
                                    sb.append(a2);
                                    return false;
                                }
                                return false;
                            }
                            return true;
                        } catch (Exception e6) {
                            e = e6;
                            sb3 = sb4;
                            sb2 = sb;
                            if (sb2 != null) {
                            }
                            e.printStackTrace();
                            return false;
                        }
                    }
                }
                sb3 = sb4;
                Container build2 = new DefaultMp4Builder().build(movie);
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str3));
                build2.writeContainer(fileOutputStream2.getChannel());
                fileOutputStream2.close();
                a2 = dxb.a(str3);
                if (a2 > 0) {
                }
            } catch (Exception e7) {
                e = e7;
                sb2 = sb;
                sb3 = sb4;
                if (sb2 != null) {
                }
                e.printStackTrace();
                return false;
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }
}
