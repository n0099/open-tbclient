package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a hAY = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hAZ = new SparseArray<>();

    public static synchronized a bIg() {
        a aVar;
        synchronized (a.class) {
            if (hAY == null) {
                hAY = new a();
            }
            aVar = hAY;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hAZ.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bIh() {
        return this.hAZ.get(4096);
    }

    public void onDestroy() {
        this.hAZ = null;
        hAY = null;
    }
}
