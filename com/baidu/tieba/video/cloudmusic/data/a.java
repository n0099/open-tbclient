package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a guJ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> guK = new SparseArray<>();

    public static synchronized a bvB() {
        a aVar;
        synchronized (a.class) {
            if (guJ == null) {
                guJ = new a();
            }
            aVar = guJ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.guK.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bvC() {
        return this.guK.get(4096);
    }

    public void onDestroy() {
        this.guK = null;
        guJ = null;
    }
}
