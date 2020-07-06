package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a lVJ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> lVK = new SparseArray<>();

    public static synchronized a dmD() {
        a aVar;
        synchronized (a.class) {
            if (lVJ == null) {
                lVJ = new a();
            }
            aVar = lVJ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.lVK.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dmE() {
        return this.lVK.get(4096);
    }

    public void onDestroy() {
        this.lVK = null;
        lVJ = null;
    }
}
