package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gXB = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gXC = new SparseArray<>();

    public static synchronized a bBm() {
        a aVar;
        synchronized (a.class) {
            if (gXB == null) {
                gXB = new a();
            }
            aVar = gXB;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gXC.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bBn() {
        return this.gXC.get(4096);
    }

    public void onDestroy() {
        this.gXC = null;
        gXB = null;
    }
}
