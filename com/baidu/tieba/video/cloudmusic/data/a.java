package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a hsd = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hse = new SparseArray<>();

    public static synchronized a bGC() {
        a aVar;
        synchronized (a.class) {
            if (hsd == null) {
                hsd = new a();
            }
            aVar = hsd;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hse.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bGD() {
        return this.hse.get(4096);
    }

    public void onDestroy() {
        this.hse = null;
        hsd = null;
    }
}
