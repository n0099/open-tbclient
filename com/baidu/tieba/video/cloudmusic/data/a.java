package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a kwj = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> kwk = new SparseArray<>();

    public static synchronized a cPx() {
        a aVar;
        synchronized (a.class) {
            if (kwj == null) {
                kwj = new a();
            }
            aVar = kwj;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.kwk.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cPy() {
        return this.kwk.get(4096);
    }

    public void onDestroy() {
        this.kwk = null;
        kwj = null;
    }
}
