package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hcT = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hcU = new SparseArray<>();

    public static synchronized a bAx() {
        a aVar;
        synchronized (a.class) {
            if (hcT == null) {
                hcT = new a();
            }
            aVar = hcT;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hcU.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAy() {
        return this.hcU.get(4096);
    }

    public void onDestroy() {
        this.hcU = null;
        hcT = null;
    }
}
