package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gLZ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gMa = new SparseArray<>();

    public static synchronized a bwf() {
        a aVar;
        synchronized (a.class) {
            if (gLZ == null) {
                gLZ = new a();
            }
            aVar = gLZ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gMa.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bwg() {
        return this.gMa.get(4096);
    }

    public void onDestroy() {
        this.gMa = null;
        gLZ = null;
    }
}
