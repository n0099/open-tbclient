package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hbG = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hbH = new SparseArray<>();

    public static synchronized a bBM() {
        a aVar;
        synchronized (a.class) {
            if (hbG == null) {
                hbG = new a();
            }
            aVar = hbG;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hbH.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bBN() {
        return this.hbH.get(4096);
    }

    public void onDestroy() {
        this.hbH = null;
        hbG = null;
    }
}
