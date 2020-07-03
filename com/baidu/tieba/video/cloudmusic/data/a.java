package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a lVG = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> lVH = new SparseArray<>();

    public static synchronized a dmz() {
        a aVar;
        synchronized (a.class) {
            if (lVG == null) {
                lVG = new a();
            }
            aVar = lVG;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.lVH.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dmA() {
        return this.lVH.get(4096);
    }

    public void onDestroy() {
        this.lVH = null;
        lVG = null;
    }
}
