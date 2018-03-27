package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hpp = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hpq = new SparseArray<>();

    public static synchronized a bBc() {
        a aVar;
        synchronized (a.class) {
            if (hpp == null) {
                hpp = new a();
            }
            aVar = hpp;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hpq.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bBd() {
        return this.hpq.get(4096);
    }

    public void onDestroy() {
        this.hpq = null;
        hpp = null;
    }
}
