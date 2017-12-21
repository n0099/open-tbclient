package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gQQ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gQR = new SparseArray<>();

    public static synchronized a bBs() {
        a aVar;
        synchronized (a.class) {
            if (gQQ == null) {
                gQQ = new a();
            }
            aVar = gQQ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gQR.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bBt() {
        return this.gQR.get(4096);
    }

    public void onDestroy() {
        this.gQR = null;
        gQQ = null;
    }
}
