package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a kxN = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> kxO = new SparseArray<>();

    public static synchronized a cPR() {
        a aVar;
        synchronized (a.class) {
            if (kxN == null) {
                kxN = new a();
            }
            aVar = kxN;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.kxO.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cPS() {
        return this.kxO.get(4096);
    }

    public void onDestroy() {
        this.kxO = null;
        kxN = null;
    }
}
