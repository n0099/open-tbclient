package com.baidu.tieba.video.meida;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.video.meida.MultiAudioMixer;
import com.baidu.tieba.video.meida.g;
import com.coremedia.iso.boxes.Container;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class h {
    private static volatile h nFz;

    private h() {
        g.dRh();
    }

    public static h dRn() {
        if (nFz == null) {
            synchronized (h.class) {
                if (nFz == null) {
                    nFz = new h();
                }
            }
        }
        return nFz;
    }

    public i a(List<String> list, String str, boolean z) {
        if (list == null || TextUtils.isEmpty(str)) {
            return new i(10, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        long j = 0;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        int i = 0;
        while (i < list.size()) {
            try {
                e f = f(list.get(i), linkedList, z ? linkedList2 : null);
                i++;
                j = f.length != -1 ? f.length + j : j;
            } catch (Exception e) {
                e.printStackTrace();
                return new i(11, com.baidu.tieba.l.a.p(e));
            }
        }
        e(str, linkedList, linkedList2);
        BdLog.e("mixingVideoByVideo videoList length = " + list.size() + " cost = " + (System.currentTimeMillis() - currentTimeMillis));
        return new i(0, "");
    }

    private void e(String str, List<Track> list, List<Track> list2) throws IOException {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
    public i gC(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new i(217, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str2);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        LinkedList linkedList = new LinkedList();
        try {
            e f = f(str, linkedList, null);
            if (f.length == -1) {
                return new i(f.nFv == 1 ? 218 : f.nFv == 2 ? 219 : 220, f.errorMsg);
            }
            BdLog.e("mixingVideoByAudio videoTracks = " + linkedList.size());
            e(str2, linkedList, null);
            return new i(0, "");
        } catch (Exception e) {
            e.printStackTrace();
            return new i(221, com.baidu.tieba.l.a.p(e));
        } finally {
            BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=5, 272=6] */
    public i l(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return new i(FAUEnum.PR_TIMEOUT, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str4 = com.baidu.tieba.video.c.nAC + (av.getNameMd5FromUrl(str + str2 + str3) + "/");
        new File(str4).mkdirs();
        File file = new File(str3);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        try {
            e f = f(str, linkedList, linkedList2);
            long j = f.length;
            if (j == -1) {
                return new i(f.nFv == 1 ? 210 : f.nFv == 2 ? 211 : 212, f.errorMsg);
            }
            long s = s(str2, linkedList3);
            if (s == -1) {
                return new i(f.nFv == 1 ? 213 : f.nFv == 2 ? 214 : 215, f.errorMsg);
            }
            a(j, s, linkedList3, linkedList4);
            if (z && linkedList2.size() > 0 && Build.VERSION.SDK_INT >= 16) {
                String str5 = str4 + "temp_" + System.currentTimeMillis();
                e(str5, null, linkedList4);
                String str6 = str4 + "temp_" + System.currentTimeMillis();
                e(str6, null, linkedList2);
                String str7 = str4 + "temp_" + System.currentTimeMillis() + ".acc";
                if (c(str7, str4, str5, str6)) {
                    AACTrackImpl aACTrackImpl = new AACTrackImpl(new FileDataSourceImpl(str7));
                    linkedList4.clear();
                    linkedList4.add(aACTrackImpl);
                }
                BdLog.e("mixingVideoByAudio mixing cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            BdLog.e("mixingVideoByAudio audioTracks = " + linkedList2.size() + " musicTracks = " + linkedList4.size() + " videoTracks = " + linkedList.size());
            e(str3, linkedList, linkedList4);
            return new i(0, "");
        } catch (Exception e) {
            e.printStackTrace();
            return new i(216, com.baidu.tieba.l.a.p(e));
        } finally {
            n.deleteFileOrDir(new File(str4));
            BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ec, code lost:
        if (r12 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, String str2, String... strArr) {
        boolean z;
        g.a aVar;
        String str3;
        if (strArr == null || strArr.length < 2) {
            return false;
        }
        final String str4 = str2 + "temp_" + System.currentTimeMillis();
        File[] fileArr = new File[strArr.length];
        try {
            g.a Tz = g.Tz(strArr[0]);
            if (Tz == null) {
                return false;
            }
            g.a aVar2 = new g.a();
            boolean z2 = true;
            int i = 0;
            while (i < strArr.length) {
                if (i != 0) {
                    g.a Tz2 = g.Tz(strArr[i]);
                    if (Tz2 == null) {
                        return false;
                    }
                    z = g.a(Tz, Tz2);
                    aVar = Tz2;
                } else {
                    z = z2;
                    aVar = aVar2;
                }
                String str5 = str2 + "temp_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
                if (new b(strArr[i]).a(str5, z, Tz, aVar) != null) {
                    if (!z && i != 0 && aVar.dRi()) {
                        str3 = str2 + "resample_" + System.currentTimeMillis();
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean d = g.d(str5, str3, aVar.sampleRate, Tz.sampleRate);
                        BdLog.e("resample cost = " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    str3 = str5;
                    fileArr[i] = new File(str3);
                }
                i++;
                z2 = z;
                aVar2 = aVar;
            }
            MultiAudioMixer dRl = MultiAudioMixer.dRl();
            dRl.a(new MultiAudioMixer.b() { // from class: com.baidu.tieba.video.meida.h.1
                FileOutputStream nFA;

                {
                    this.nFA = new FileOutputStream(str4);
                }

                @Override // com.baidu.tieba.video.meida.MultiAudioMixer.b
                public void ag(byte[] bArr) throws IOException {
                    if (this.nFA != null) {
                        this.nFA.write(bArr);
                    }
                }

                @Override // com.baidu.tieba.video.meida.MultiAudioMixer.b
                public void Km(int i2) {
                    try {
                        if (this.nFA != null) {
                            this.nFA.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.baidu.tieba.video.meida.MultiAudioMixer.b
                public void dRm() {
                    try {
                        if (this.nFA != null) {
                            this.nFA.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dRl.e(fileArr);
            d Ty = d.Ty(str4);
            Ty.setSampleRate(Tz.sampleRate);
            Ty.setChannelCount(Tz.channelCount);
            Ty.Tx(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void a(long j, long j2, List<Track> list, List<Track> list2) throws Exception {
        Movie movie = new Movie();
        long j3 = 0;
        while (true) {
            long j4 = j3;
            if (j > j4) {
                long j5 = j - j4;
                if (j5 >= j2) {
                    movie.addTrack(new AppendTrack((Track[]) list.toArray(new Track[list.size()])));
                    j3 = j4 + j2;
                } else {
                    double d = 0.0d;
                    double d2 = j5 / 1000;
                    boolean z = false;
                    Iterator<Track> it = list.iterator();
                    while (true) {
                        boolean z2 = z;
                        double d3 = d2;
                        double d4 = d;
                        if (it.hasNext()) {
                            Track next = it.next();
                            if (next.getSyncSamples() != null && next.getSyncSamples().length > 0) {
                                if (z2) {
                                    throw new RuntimeException("The startTime has already been corrected by another track with SyncSample. Not Supported.");
                                }
                                d4 = a(next, d4, false);
                                d3 = a(next, d3, true);
                                z2 = true;
                            }
                            z = z2;
                            d2 = d3;
                            d = d4;
                        } else {
                            for (Track track : list) {
                                double d5 = 0.0d;
                                double d6 = -1.0d;
                                long j6 = -1;
                                long j7 = -1;
                                int i = 0;
                                long j8 = 0;
                                while (i < track.getSampleDurations().length) {
                                    long j9 = track.getSampleDurations()[i];
                                    if (d5 > d6 && d5 <= d4) {
                                        j6 = j8;
                                    }
                                    if (d5 > d6 && d5 <= d3) {
                                        j7 = j8;
                                    }
                                    j8++;
                                    i++;
                                    d6 = d5;
                                    d5 += j9 / track.getTrackMetaData().getTimescale();
                                }
                                movie.addTrack(new CroppedTrack(track, j6, j7));
                            }
                            j3 = j4 + j5;
                        }
                    }
                }
            } else {
                for (Track track2 : movie.getTracks()) {
                    if (track2.getHandler().equals("soun")) {
                        list2.add(track2);
                    }
                }
                return;
            }
        }
    }

    private double a(Track track, double d, boolean z) {
        double[] dArr = new double[track.getSyncSamples().length];
        long j = 0;
        double d2 = 0.0d;
        for (int i = 0; i < track.getSampleDurations().length; i++) {
            long j2 = track.getSampleDurations()[i];
            if (Arrays.binarySearch(track.getSyncSamples(), 1 + j) >= 0) {
                dArr[Arrays.binarySearch(track.getSyncSamples(), 1 + j)] = d2;
            }
            d2 += j2 / track.getTrackMetaData().getTimescale();
            j++;
        }
        double d3 = 0.0d;
        int length = dArr.length;
        int i2 = 0;
        while (i2 < length) {
            double d4 = dArr[i2];
            if (d4 > d) {
                return z ? d4 : d3;
            }
            i2++;
            d3 = d4;
        }
        return dArr[dArr.length - 1];
    }

    private e f(String str, List<Track> list, List<Track> list2) {
        if (TextUtils.isEmpty(str)) {
            return new e(-1L, 1, TbadkCoreApplication.getInst().getString(R.string.illegal_argument));
        }
        if (!new File(str).exists()) {
            return new e(-1L, 2, TbadkCoreApplication.getInst().getString(R.string.file_not_exist));
        }
        long j = 0;
        try {
            Iterator<Track> it = MovieCreator.build(str).getTracks().iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    Track next = it.next();
                    if (list2 != null && next.getHandler().equals("soun")) {
                        list2.add(next);
                    }
                    if (next.getHandler().equals("vide")) {
                        list.add(next);
                        j = ((next.getDuration() * 1000) / next.getTrackMetaData().getTimescale()) + j2;
                    } else {
                        j = j2;
                    }
                } else {
                    return new e(j2, 0, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new e(-1L, 3, com.baidu.tieba.l.a.p(e));
        }
    }

    private long s(String str, List<Track> list) {
        long j = 0;
        try {
            Iterator<Track> it = MovieCreator.build(str).getTracks().iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    Track next = it.next();
                    if (next.getHandler().equals("soun")) {
                        list.add(next);
                        j = ((next.getDuration() * 1000) / next.getTrackMetaData().getTimescale()) + j2;
                    } else {
                        j = j2;
                    }
                } else {
                    return j2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }
}
