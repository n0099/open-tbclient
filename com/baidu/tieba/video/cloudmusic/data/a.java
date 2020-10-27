package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes23.dex */
public class a {
    private static a nhd = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nhe = new SparseArray<>();

    public static synchronized a dMh() {
        a aVar;
        synchronized (a.class) {
            if (nhd == null) {
                nhd = new a();
            }
            aVar = nhd;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nhe.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dMi() {
        return this.nhe.get(4096);
    }

    public void onDestroy() {
        this.nhe = null;
        nhd = null;
    }
}
