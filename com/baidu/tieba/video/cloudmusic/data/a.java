package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a lic = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> lid = new SparseArray<>();

    public static synchronized a daN() {
        a aVar;
        synchronized (a.class) {
            if (lic == null) {
                lic = new a();
            }
            aVar = lic;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.lid.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList daO() {
        return this.lid.get(4096);
    }

    public void onDestroy() {
        this.lid = null;
        lic = null;
    }
}
