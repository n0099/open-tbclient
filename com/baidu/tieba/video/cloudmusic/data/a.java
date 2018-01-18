package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hnv = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hnw = new SparseArray<>();

    public static synchronized a bAm() {
        a aVar;
        synchronized (a.class) {
            if (hnv == null) {
                hnv = new a();
            }
            aVar = hnv;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hnw.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAn() {
        return this.hnw.get(4096);
    }

    public void onDestroy() {
        this.hnw = null;
        hnv = null;
    }
}
