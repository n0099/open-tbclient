package com.baidu.tieba.video.meida;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.video.meida.MultiAudioMixer;
import com.baidu.tieba.video.meida.f;
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
/* loaded from: classes2.dex */
public class g {
    private static volatile g gxG;

    private g() {
        f.bwt();
    }

    public static g bwz() {
        if (gxG == null) {
            synchronized (g.class) {
                if (gxG == null) {
                    gxG = new g();
                }
            }
        }
        return gxG;
    }

    public boolean j(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return false;
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
                long c = c(list.get(i), linkedList, linkedList2);
                i++;
                j = c != -1 ? c + j : j;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        b(str, linkedList, linkedList2);
        BdLog.e("mixingVideoByVideo videoList length = " + list.size() + " cost = " + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    private void b(String str, List<Track> list, List<Track> list2) throws IOException {
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

    public boolean cl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str2);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        LinkedList linkedList = new LinkedList();
        try {
            if (c(str, linkedList, null) == -1) {
                return false;
            }
            BdLog.e("mixingVideoByAudio videoTracks = " + linkedList.size());
            b(str2, linkedList, (List<Track>) null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=5, 253=5] */
    public boolean c(String str, String str2, String str3, boolean z) {
        File file;
        StringBuilder sb;
        String str4;
        StringBuilder append;
        long currentTimeMillis;
        long j;
        StringBuilder append2;
        String sb2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        String str5 = com.baidu.tieba.video.b.gtH + (ao.dP(str + str2 + str3) + "/");
        new File(str5).mkdirs();
        File file2 = new File(str3);
        file2.mkdirs();
        if (file2.exists()) {
            file2.delete();
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        try {
            try {
                long c = c(str, linkedList, linkedList2);
                if (c == -1) {
                    return false;
                }
                long p = p(str2, linkedList3);
                if (p == -1) {
                    return false;
                }
                a(c, p, linkedList3, linkedList4);
                if (z && linkedList2.size() > 0 && Build.VERSION.SDK_INT >= 16) {
                    String str6 = str5 + "temp_" + System.currentTimeMillis();
                    b(str6, (List<Track>) null, linkedList4);
                    String str7 = str5 + "temp_" + System.currentTimeMillis();
                    b(str7, (List<Track>) null, linkedList2);
                    String str8 = str5 + "temp_" + System.currentTimeMillis() + ".acc";
                    if (b(str8, str5, str6, str7)) {
                        AACTrackImpl aACTrackImpl = new AACTrackImpl(new FileDataSourceImpl(str8));
                        linkedList4.clear();
                        linkedList4.add(aACTrackImpl);
                    }
                    BdLog.e("mixingVideoByAudio mixing cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                }
                BdLog.e("mixingVideoByAudio audioTracks = " + linkedList2.size() + " musicTracks = " + linkedList4.size() + " videoTracks = " + linkedList.size());
                b(str3, linkedList, linkedList4);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                k.s(new File(str5));
                BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                return false;
            }
        } finally {
            k.s(new File(str5));
            BdLog.e("mixingVideoByAudio cost = " + (System.currentTimeMillis() - currentTimeMillis2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ee, code lost:
        if (r12 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str, String str2, String... strArr) {
        boolean z;
        f.a aVar;
        String str3;
        if (strArr == null || strArr.length < 2) {
            return false;
        }
        final String str4 = str2 + "temp_" + System.currentTimeMillis();
        File[] fileArr = new File[strArr.length];
        try {
            f.a sO = f.sO(strArr[0]);
            if (sO == null) {
                return false;
            }
            f.a aVar2 = new f.a();
            int i = 0;
            boolean z2 = true;
            while (i < strArr.length) {
                if (i != 0) {
                    f.a sO2 = f.sO(strArr[i]);
                    if (sO2 == null) {
                        return false;
                    }
                    z = f.a(sO, sO2);
                    aVar = sO2;
                } else {
                    z = z2;
                    aVar = aVar2;
                }
                String str5 = str2 + "temp_" + i + "_" + System.currentTimeMillis();
                if (new b(strArr[i]).a(str5, z, sO, aVar) != null) {
                    if (!z && i != 0 && aVar.bwu()) {
                        str3 = str2 + "resample_" + System.currentTimeMillis();
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean e = f.e(str5, str3, aVar.gxA, sO.gxA);
                        BdLog.e("resample cost = " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    str3 = str5;
                    fileArr[i] = new File(str3);
                }
                i++;
                aVar2 = aVar;
                z2 = z;
            }
            MultiAudioMixer bwx = MultiAudioMixer.bwx();
            bwx.a(new MultiAudioMixer.b() { // from class: com.baidu.tieba.video.meida.g.1
                FileOutputStream gxH;

                {
                    this.gxH = new FileOutputStream(str4);
                }

                @Override // com.baidu.tieba.video.meida.MultiAudioMixer.b
                public void C(byte[] bArr) throws IOException {
                    if (this.gxH != null) {
                        this.gxH.write(bArr);
                    }
                }

                @Override // com.baidu.tieba.video.meida.MultiAudioMixer.b
                public void uz(int i2) {
                    try {
                        if (this.gxH != null) {
                            this.gxH.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.baidu.tieba.video.meida.MultiAudioMixer.b
                public void bwy() {
                    try {
                        if (this.gxH != null) {
                            this.gxH.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            bwx.a(fileArr);
            d sN = d.sN(str4);
            sN.setSampleRate(sO.gxA);
            sN.setChannelCount(sO.channelCount);
            sN.sM(str);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
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
                                long j6 = 0;
                                double d5 = 0.0d;
                                double d6 = -1.0d;
                                long j7 = -1;
                                long j8 = -1;
                                int i = 0;
                                while (i < track.getSampleDurations().length) {
                                    long j9 = track.getSampleDurations()[i];
                                    if (d5 > d6 && d5 <= d4) {
                                        j7 = j6;
                                    }
                                    if (d5 > d6 && d5 <= d3) {
                                        j8 = j6;
                                    }
                                    j6++;
                                    i++;
                                    double d7 = d5;
                                    d5 = (j9 / track.getTrackMetaData().getTimescale()) + d5;
                                    d6 = d7;
                                }
                                movie.addTrack(new CroppedTrack(track, j7, j8));
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

    private long c(String str, List<Track> list, List<Track> list2) {
        long j = 0;
        try {
            Iterator<Track> it = MovieCreator.build(str).getTracks().iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    Track next = it.next();
                    if (next.getHandler().equals("soun")) {
                        list2.add(next);
                    }
                    if (next.getHandler().equals("vide")) {
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

    private long p(String str, List<Track> list) {
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
