package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes8.dex */
public class a {
    private static a nGs = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nGt = new SparseArray<>();

    public static synchronized a dTS() {
        a aVar;
        synchronized (a.class) {
            if (nGs == null) {
                nGs = new a();
            }
            aVar = nGs;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nGt.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dTT() {
        return this.nGt.get(4096);
    }

    public void onDestroy() {
        this.nGt = null;
        nGs = null;
    }
}
