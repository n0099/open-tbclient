package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes23.dex */
public class a {
    private static a nCl = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nCm = new SparseArray<>();

    public static synchronized a dUb() {
        a aVar;
        synchronized (a.class) {
            if (nCl == null) {
                nCl = new a();
            }
            aVar = nCl;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nCm.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dUc() {
        return this.nCm.get(4096);
    }

    public void onDestroy() {
        this.nCm = null;
        nCl = null;
    }
}
