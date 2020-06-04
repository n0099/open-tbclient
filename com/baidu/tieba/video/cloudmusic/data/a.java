package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a lCa = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> lCb = new SparseArray<>();

    public static synchronized a dio() {
        a aVar;
        synchronized (a.class) {
            if (lCa == null) {
                lCa = new a();
            }
            aVar = lCa;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.lCb.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dip() {
        return this.lCb.get(4096);
    }

    public void onDestroy() {
        this.lCb = null;
        lCa = null;
    }
}
