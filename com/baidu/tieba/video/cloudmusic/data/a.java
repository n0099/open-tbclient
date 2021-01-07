package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes8.dex */
public class a {
    private static a nGr = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nGs = new SparseArray<>();

    public static synchronized a dTT() {
        a aVar;
        synchronized (a.class) {
            if (nGr == null) {
                nGr = new a();
            }
            aVar = nGr;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nGs.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dTU() {
        return this.nGs.get(4096);
    }

    public void onDestroy() {
        this.nGs = null;
        nGr = null;
    }
}
