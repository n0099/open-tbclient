package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.oma;
import com.baidu.tieba.video.meida.MultiAudioMixer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Container;
import com.facebook.imageutils.JfifUtil;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AACTrackImpl;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;
import com.qq.e.comm.adevent.AdEventType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class pma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pma a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements MultiAudioMixer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FileOutputStream a;
        public final /* synthetic */ String b;

        public a(pma pmaVar, String str) throws FileNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pmaVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = str;
            this.a = new FileOutputStream(this.b);
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer.c
        public void onMixComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer.c
        public void onMixError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer.c
        public void onMixing(byte[] bArr) throws IOException {
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) && (fileOutputStream = this.a) != null) {
                fileOutputStream.write(bArr);
            }
        }
    }

    public pma() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        oma.g();
    }

    public static pma e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (pma.class) {
                    if (a == null) {
                        a = new pma();
                    }
                }
            }
            return a;
        }
        return (pma) invokeV.objValue;
    }

    public final void a(long j, long j2, List<Track> list, List<Track> list2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list, list2}) == null) {
            Movie movie = new Movie();
            long j3 = 0;
            while (j > j3) {
                long j4 = j - j3;
                if (j4 >= j2) {
                    movie.addTrack(new AppendTrack((Track[]) list.toArray(new Track[list.size()])));
                    j3 += j2;
                } else {
                    double d = j4 / 1000;
                    double d2 = 0.0d;
                    boolean z = false;
                    for (Track track : list) {
                        if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                            if (!z) {
                                d2 = d(track, d2, false);
                                d = d(track, d, true);
                                z = true;
                            } else {
                                throw new RuntimeException("The startTime has already been corrected by another track with SyncSample. Not Supported.");
                            }
                        }
                    }
                    for (Track track2 : list) {
                        long j5 = -1;
                        long j6 = -1;
                        int i = 0;
                        long j7 = 0;
                        double d3 = -1.0d;
                        double d4 = 0.0d;
                        while (i < track2.getSampleDurations().length) {
                            long j8 = j3;
                            long j9 = track2.getSampleDurations()[i];
                            int i2 = (d4 > d3 ? 1 : (d4 == d3 ? 0 : -1));
                            if (i2 > 0 && d4 <= d2) {
                                j5 = j7;
                            }
                            if (i2 > 0 && d4 <= d) {
                                j6 = j7;
                            }
                            j7++;
                            i++;
                            d3 = d4;
                            d2 = d2;
                            d4 = (j9 / track2.getTrackMetaData().getTimescale()) + d4;
                            j3 = j8;
                        }
                        movie.addTrack(new CroppedTrack(track2, j5, j6));
                        d2 = d2;
                    }
                    j3 += j4;
                }
            }
            for (Track track3 : movie.getTracks()) {
                if (track3.getHandler().equals("soun")) {
                    list2.add(track3);
                }
            }
        }
    }

    public final long b(String str, List<Track> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list)) == null) {
            try {
                long j = 0;
                for (Track track : MovieCreator.build(str).getTracks()) {
                    if (track.getHandler().equals("soun")) {
                        list.add(track);
                        j += (track.getDuration() * 1000) / track.getTrackMetaData().getTimescale();
                    }
                }
                return j;
            } catch (Exception e) {
                e.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final mma c(String str, List<Track> list, List<Track> list2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, list2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new mma(-1L, 1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a38));
            }
            if (!new File(str).exists()) {
                return new mma(-1L, 2, TbadkCoreApplication.getInst().getString(R.string.file_not_exist));
            }
            long j = 0;
            try {
                for (Track track : MovieCreator.build(str).getTracks()) {
                    if (list2 != null && track.getHandler().equals("soun")) {
                        list2.add(track);
                    }
                    if (track.getHandler().equals("vide")) {
                        list.add(track);
                        j += (track.getDuration() * 1000) / track.getTrackMetaData().getTimescale();
                    }
                }
                return new mma(j, 0, "");
            } catch (Exception e) {
                e.printStackTrace();
                return new mma(-1L, 3, t69.a(e));
            }
        }
        return (mma) invokeLLL.objValue;
    }

    public qma i(List<String> list, String str, boolean z) {
        InterceptResult invokeLLZ;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, list, str, z)) == null) {
            if (list != null && !TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(str);
                file.mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                LinkedList linkedList2 = new LinkedList();
                LinkedList linkedList3 = new LinkedList();
                for (int i = 0; i < list.size(); i++) {
                    try {
                        String str2 = list.get(i);
                        if (z) {
                            linkedList = linkedList3;
                        } else {
                            linkedList = null;
                        }
                        mma c = c(str2, linkedList2, linkedList);
                        if (c.a != -1) {
                            long j = c.a;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return new qma(11, t69.a(e));
                    }
                }
                j(str, linkedList2, linkedList3);
                BdLog.e("mixingVideoByVideo videoList length = " + list.size() + " cost = " + (System.currentTimeMillis() - currentTimeMillis));
                return new qma(0, "");
            }
            return new qma(10, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a38));
        }
        return (qma) invokeLLZ.objValue;
    }

    public final double d(Track track, double d, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{track, Double.valueOf(d), Boolean.valueOf(z)})) == null) {
            int length = track.getSyncSamples().length;
            double[] dArr = new double[length];
            int i = 0;
            double d2 = 0.0d;
            long j = 0;
            double d3 = 0.0d;
            for (int i2 = 0; i2 < track.getSampleDurations().length; i2++) {
                long j2 = track.getSampleDurations()[i2];
                j++;
                if (Arrays.binarySearch(track.getSyncSamples(), j) >= 0) {
                    dArr[Arrays.binarySearch(track.getSyncSamples(), j)] = d3;
                }
                d3 += j2 / track.getTrackMetaData().getTimescale();
            }
            while (i < length) {
                double d4 = dArr[i];
                if (d4 > d) {
                    if (z) {
                        return d4;
                    }
                    return d2;
                }
                i++;
                d2 = d4;
            }
            return dArr[length - 1];
        }
        return invokeCommon.doubleValue;
    }

    public final void j(String str, List<Track> list, List<Track> list2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, list2) == null) {
            Movie movie = new Movie();
            if (list2 != null && list2.size() > 0) {
                movie.addTrack(new AppendTrack((Track[]) list2.toArray(new Track[list2.size()])));
            }
            if (list != null && list.size() > 0) {
                movie.addTrack(new AppendTrack((Track[]) list.toArray(new Track[list.size()])));
            }
            Container build = new DefaultMp4Builder().build(movie);
            FileChannel channel = new RandomAccessFile(String.format(str, new Object[0]), "rw").getChannel();
            build.writeContainer(channel);
            channel.close();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public boolean f(String str, String str2, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, strArr)) == null) {
            ?? r2 = 0;
            if (strArr != null) {
                int i = 2;
                if (strArr.length >= 2) {
                    String str3 = str2 + "temp_" + System.currentTimeMillis();
                    File[] fileArr = new File[strArr.length];
                    try {
                        oma.a d = oma.d(strArr[0]);
                        if (d == null) {
                            return false;
                        }
                        oma.a aVar = new oma.a();
                        char c = 1;
                        int i2 = 0;
                        boolean z = true;
                        while (i2 < strArr.length) {
                            if (i2 != 0) {
                                aVar = oma.d(strArr[i2]);
                                if (aVar == null) {
                                    return r2;
                                }
                                oma.a[] aVarArr = new oma.a[i];
                                aVarArr[r2] = d;
                                aVarArr[c] = aVar;
                                z = oma.h(aVarArr);
                            }
                            String str4 = str2 + "temp_" + i2 + "_" + System.currentTimeMillis();
                            if (new jma(strArr[i2]).a(str4, z, d, aVar) != null) {
                                if (!z && i2 != 0 && aVar.c()) {
                                    String str5 = str2 + "resample_" + System.currentTimeMillis();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    boolean i3 = oma.i(str4, str5, aVar.a, d.a);
                                    BdLog.e("resample cost = " + (System.currentTimeMillis() - currentTimeMillis));
                                    if (i3) {
                                        str4 = str5;
                                    }
                                }
                                fileArr[i2] = new File(str4);
                            }
                            i2++;
                            r2 = 0;
                            i = 2;
                            c = 1;
                        }
                        MultiAudioMixer a2 = MultiAudioMixer.a();
                        try {
                            a2.d(new a(this, str3));
                            a2.b(fileArr);
                            lma a3 = lma.a(str3);
                            a3.d(d.a);
                            a3.c(d.b);
                            a3.b(str);
                            return true;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return false;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public qma g(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(str2);
                file.mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                LinkedList linkedList = new LinkedList();
                try {
                    mma c = c(str, linkedList, null);
                    if (c.a == -1) {
                        if (c.b == 1) {
                            i = 218;
                        } else if (c.b == 2) {
                            i = 219;
                        } else {
                            i = PassFaceRecogManager.j;
                        }
                        return new qma(i, c.c);
                    }
                    BdLog.e("mixingVideoByAudio videoTracks = " + linkedList.size());
                    j(str2, linkedList, null);
                    return new qma(0, "");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new qma(221, t69.a(e));
                } finally {
                    BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
            return new qma(217, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a38));
        }
        return (qma) invokeLL.objValue;
    }

    public qma h(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String str4;
        LinkedList linkedList;
        int i;
        qma qmaVar;
        StringBuilder sb;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                long currentTimeMillis = System.currentTimeMillis();
                String str5 = cla.f + (TbMd5.getNameMd5FromUrl(str + str2 + str3) + "/");
                new File(str5).mkdirs();
                File file = new File(str3);
                file.mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                LinkedList linkedList2 = new LinkedList();
                LinkedList linkedList3 = new LinkedList();
                LinkedList linkedList4 = new LinkedList();
                LinkedList linkedList5 = new LinkedList();
                try {
                    mma c = c(str, linkedList2, linkedList3);
                    long j = c.a;
                    if (j == -1) {
                        if (c.b == 1) {
                            i2 = 210;
                        } else if (c.b == 2) {
                            i2 = AdEventType.VIDEO_LOADING;
                        } else {
                            i2 = 212;
                        }
                        qmaVar = new qma(i2, c.c);
                        FileHelper.deleteFileOrDir(new File(str5));
                        sb = new StringBuilder();
                    } else {
                        long b = b(str2, linkedList4);
                        if (b == -1) {
                            if (c.b == 1) {
                                i = 213;
                            } else if (c.b == 2) {
                                i = Constants.METHOD_IM_EMOJI;
                            } else {
                                i = 215;
                            }
                            qmaVar = new qma(i, c.c);
                            FileHelper.deleteFileOrDir(new File(str5));
                            sb = new StringBuilder();
                        } else {
                            try {
                                a(j, b, linkedList4, linkedList5);
                                if (z && linkedList3.size() > 0 && Build.VERSION.SDK_INT >= 16) {
                                    String str6 = str5 + "temp_" + System.currentTimeMillis();
                                    j(str6, null, linkedList5);
                                    String str7 = str5 + "temp_" + System.currentTimeMillis();
                                    linkedList = linkedList3;
                                    j(str7, null, linkedList);
                                    String str8 = str5 + "temp_" + System.currentTimeMillis() + ".acc";
                                    if (f(str8, str5, str6, str7)) {
                                        AACTrackImpl aACTrackImpl = new AACTrackImpl(new FileDataSourceImpl(str8));
                                        linkedList5.clear();
                                        linkedList5.add(aACTrackImpl);
                                    }
                                    BdLog.e("mixingVideoByAudio mixing cost = " + (System.currentTimeMillis() - currentTimeMillis));
                                } else {
                                    linkedList = linkedList3;
                                }
                                BdLog.e("mixingVideoByAudio audioTracks = " + linkedList.size() + " musicTracks = " + linkedList5.size() + " videoTracks = " + linkedList2.size());
                                j(str3, linkedList2, linkedList5);
                                qma qmaVar2 = new qma(0, "");
                                FileHelper.deleteFileOrDir(new File(str5));
                                BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
                                return qmaVar2;
                            } catch (Exception e) {
                                e = e;
                                str4 = "mixingVideoByAudio cost = ";
                                try {
                                    e.printStackTrace();
                                    qma qmaVar3 = new qma(JfifUtil.MARKER_SOI, t69.a(e));
                                    FileHelper.deleteFileOrDir(new File(str5));
                                    BdLog.e(str4 + (System.currentTimeMillis() - currentTimeMillis));
                                    return qmaVar3;
                                } catch (Throwable th) {
                                    th = th;
                                    FileHelper.deleteFileOrDir(new File(str5));
                                    BdLog.e(str4 + (System.currentTimeMillis() - currentTimeMillis));
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                str4 = "mixingVideoByAudio cost = ";
                                FileHelper.deleteFileOrDir(new File(str5));
                                BdLog.e(str4 + (System.currentTimeMillis() - currentTimeMillis));
                                throw th;
                            }
                        }
                    }
                    sb.append("mixingVideoByAudio cost = ");
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    BdLog.e(sb.toString());
                    return qmaVar;
                } catch (Exception e2) {
                    e = e2;
                    str4 = "mixingVideoByAudio cost = ";
                } catch (Throwable th3) {
                    th = th3;
                    str4 = "mixingVideoByAudio cost = ";
                }
            } else {
                return new qma(209, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a38));
            }
        } else {
            return (qma) invokeCommon.objValue;
        }
    }
}
