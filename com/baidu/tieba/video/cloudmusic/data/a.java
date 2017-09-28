package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a guK = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> guL = new SparseArray<>();

    public static synchronized a bvC() {
        a aVar;
        synchronized (a.class) {
            if (guK == null) {
                guK = new a();
            }
            aVar = guK;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.guL.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bvD() {
        return this.guL.get(4096);
    }

    public void onDestroy() {
        this.guL = null;
        guK = null;
    }
}
