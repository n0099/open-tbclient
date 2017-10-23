package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a guv = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> guw = new SparseArray<>();

    public static synchronized a bvt() {
        a aVar;
        synchronized (a.class) {
            if (guv == null) {
                guv = new a();
            }
            aVar = guv;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.guw.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bvu() {
        return this.guw.get(4096);
    }

    public void onDestroy() {
        this.guw = null;
        guv = null;
    }
}
