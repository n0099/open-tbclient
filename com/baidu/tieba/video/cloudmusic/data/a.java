package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gEv = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gEw = new SparseArray<>();

    public static synchronized a byI() {
        a aVar;
        synchronized (a.class) {
            if (gEv == null) {
                gEv = new a();
            }
            aVar = gEv;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gEw.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList byJ() {
        return this.gEw.get(4096);
    }

    public void onDestroy() {
        this.gEw = null;
        gEv = null;
    }
}
