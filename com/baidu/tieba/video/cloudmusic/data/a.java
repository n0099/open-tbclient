package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hpe = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hpf = new SparseArray<>();

    public static synchronized a bAY() {
        a aVar;
        synchronized (a.class) {
            if (hpe == null) {
                hpe = new a();
            }
            aVar = hpe;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hpf.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAZ() {
        return this.hpf.get(4096);
    }

    public void onDestroy() {
        this.hpf = null;
        hpe = null;
    }
}
