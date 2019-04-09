package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a iVG = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> iVH = new SparseArray<>();

    public static synchronized a cjc() {
        a aVar;
        synchronized (a.class) {
            if (iVG == null) {
                iVG = new a();
            }
            aVar = iVG;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.iVH.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cjd() {
        return this.iVH.get(4096);
    }

    public void onDestroy() {
        this.iVH = null;
        iVG = null;
    }
}
