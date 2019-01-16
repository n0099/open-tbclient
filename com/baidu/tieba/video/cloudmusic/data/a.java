package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a hFq = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hFr = new SparseArray<>();

    public static synchronized a bJE() {
        a aVar;
        synchronized (a.class) {
            if (hFq == null) {
                hFq = new a();
            }
            aVar = hFq;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hFr.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bJF() {
        return this.hFr.get(4096);
    }

    public void onDestroy() {
        this.hFr = null;
        hFq = null;
    }
}
