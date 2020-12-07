package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes23.dex */
public class a {
    private static a nCj = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nCk = new SparseArray<>();

    public static synchronized a dUa() {
        a aVar;
        synchronized (a.class) {
            if (nCj == null) {
                nCj = new a();
            }
            aVar = nCj;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nCk.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dUb() {
        return this.nCk.get(4096);
    }

    public void onDestroy() {
        this.nCk = null;
        nCj = null;
    }
}
