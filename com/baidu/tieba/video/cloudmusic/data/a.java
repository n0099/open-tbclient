package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gDn = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gDo = new SparseArray<>();

    public static synchronized a byw() {
        a aVar;
        synchronized (a.class) {
            if (gDn == null) {
                gDn = new a();
            }
            aVar = gDn;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gDo.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList byx() {
        return this.gDo.get(4096);
    }

    public void onDestroy() {
        this.gDo = null;
        gDn = null;
    }
}
