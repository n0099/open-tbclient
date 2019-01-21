package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a hFr = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hFs = new SparseArray<>();

    public static synchronized a bJE() {
        a aVar;
        synchronized (a.class) {
            if (hFr == null) {
                hFr = new a();
            }
            aVar = hFr;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hFs.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bJF() {
        return this.hFs.get(4096);
    }

    public void onDestroy() {
        this.hFs = null;
        hFr = null;
    }
}
