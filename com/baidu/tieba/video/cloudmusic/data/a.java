package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a jvW = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> jvX = new SparseArray<>();

    public static synchronized a cup() {
        a aVar;
        synchronized (a.class) {
            if (jvW == null) {
                jvW = new a();
            }
            aVar = jvW;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.jvX.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cuq() {
        return this.jvX.get(4096);
    }

    public void onDestroy() {
        this.jvX = null;
        jvW = null;
    }
}
