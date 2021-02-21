package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes8.dex */
public class a {
    private static a nLX = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nLY = new SparseArray<>();

    public static synchronized a dSu() {
        a aVar;
        synchronized (a.class) {
            if (nLX == null) {
                nLX = new a();
            }
            aVar = nLX;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nLY.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dSv() {
        return this.nLY.get(4096);
    }

    public void onDestroy() {
        this.nLY = null;
        nLX = null;
    }
}
