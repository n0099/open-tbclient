package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hxS = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hxT = new SparseArray<>();

    public static synchronized a bGP() {
        a aVar;
        synchronized (a.class) {
            if (hxS == null) {
                hxS = new a();
            }
            aVar = hxS;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hxT.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bGQ() {
        return this.hxT.get(4096);
    }

    public void onDestroy() {
        this.hxT = null;
        hxS = null;
    }
}
