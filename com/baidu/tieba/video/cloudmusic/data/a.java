package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes7.dex */
public class a {
    private static a nOc = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nOd = new SparseArray<>();

    public static synchronized a dSC() {
        a aVar;
        synchronized (a.class) {
            if (nOc == null) {
                nOc = new a();
            }
            aVar = nOc;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nOd.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dSD() {
        return this.nOd.get(4096);
    }

    public void onDestroy() {
        this.nOd = null;
        nOc = null;
    }
}
