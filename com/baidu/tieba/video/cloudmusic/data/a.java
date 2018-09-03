package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hcU = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hcV = new SparseArray<>();

    public static synchronized a bAz() {
        a aVar;
        synchronized (a.class) {
            if (hcU == null) {
                hcU = new a();
            }
            aVar = hcU;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hcV.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAA() {
        return this.hcV.get(4096);
    }

    public void onDestroy() {
        this.hcV = null;
        hcU = null;
    }
}
