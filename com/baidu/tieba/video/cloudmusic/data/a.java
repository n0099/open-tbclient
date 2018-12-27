package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a hEj = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hEk = new SparseArray<>();

    public static synchronized a bIV() {
        a aVar;
        synchronized (a.class) {
            if (hEj == null) {
                hEj = new a();
            }
            aVar = hEj;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hEk.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bIW() {
        return this.hEk.get(4096);
    }

    public void onDestroy() {
        this.hEk = null;
        hEj = null;
    }
}
