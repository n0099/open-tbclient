package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a iVF = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> iVG = new SparseArray<>();

    public static synchronized a cjc() {
        a aVar;
        synchronized (a.class) {
            if (iVF == null) {
                iVF = new a();
            }
            aVar = iVF;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.iVG.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cjd() {
        return this.iVG.get(4096);
    }

    public void onDestroy() {
        this.iVG = null;
        iVF = null;
    }
}
