package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a kvV = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> kvW = new SparseArray<>();

    public static synchronized a cPu() {
        a aVar;
        synchronized (a.class) {
            if (kvV == null) {
                kvV = new a();
            }
            aVar = kvV;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.kvW.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cPv() {
        return this.kvW.get(4096);
    }

    public void onDestroy() {
        this.kvW = null;
        kvV = null;
    }
}
