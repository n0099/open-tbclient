package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a gQL = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> gQM = new SparseArray<>();

    public static synchronized a bBr() {
        a aVar;
        synchronized (a.class) {
            if (gQL == null) {
                gQL = new a();
            }
            aVar = gQL;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.gQM.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bBs() {
        return this.gQM.get(4096);
    }

    public void onDestroy() {
        this.gQM = null;
        gQL = null;
    }
}
