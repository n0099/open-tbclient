package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes22.dex */
public class a {
    private static a nog = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> noh = new SparseArray<>();

    public static synchronized a dOI() {
        a aVar;
        synchronized (a.class) {
            if (nog == null) {
                nog = new a();
            }
            aVar = nog;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.noh.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dOJ() {
        return this.noh.get(4096);
    }

    public void onDestroy() {
        this.noh = null;
        nog = null;
    }
}
