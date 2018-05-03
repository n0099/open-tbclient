package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gKW = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gKX = new SparseArray<>();

    public static synchronized a bwh() {
        a aVar;
        synchronized (a.class) {
            if (gKW == null) {
                gKW = new a();
            }
            aVar = gKW;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gKX.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bwi() {
        return this.gKX.get(4096);
    }

    public void onDestroy() {
        this.gKX = null;
        gKW = null;
    }
}
