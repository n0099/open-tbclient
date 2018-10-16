package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a hsc = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hsd = new SparseArray<>();

    public static synchronized a bGC() {
        a aVar;
        synchronized (a.class) {
            if (hsc == null) {
                hsc = new a();
            }
            aVar = hsc;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hsd.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bGD() {
        return this.hsd.get(4096);
    }

    public void onDestroy() {
        this.hsd = null;
        hsc = null;
    }
}
