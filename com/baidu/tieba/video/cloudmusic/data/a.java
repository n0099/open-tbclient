package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gOd = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gOe = new SparseArray<>();

    public static synchronized a bAL() {
        a aVar;
        synchronized (a.class) {
            if (gOd == null) {
                gOd = new a();
            }
            aVar = gOd;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gOe.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAM() {
        return this.gOe.get(4096);
    }

    public void onDestroy() {
        this.gOe = null;
        gOd = null;
    }
}
