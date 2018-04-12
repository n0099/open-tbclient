package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gKZ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gLa = new SparseArray<>();

    public static synchronized a bwh() {
        a aVar;
        synchronized (a.class) {
            if (gKZ == null) {
                gKZ = new a();
            }
            aVar = gKZ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gLa.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bwi() {
        return this.gLa.get(4096);
    }

    public void onDestroy() {
        this.gLa = null;
        gKZ = null;
    }
}
