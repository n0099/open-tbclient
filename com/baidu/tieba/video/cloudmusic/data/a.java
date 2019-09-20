package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a jys = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> jyt = new SparseArray<>();

    public static synchronized a cvd() {
        a aVar;
        synchronized (a.class) {
            if (jys == null) {
                jys = new a();
            }
            aVar = jys;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.jyt.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cve() {
        return this.jyt.get(4096);
    }

    public void onDestroy() {
        this.jyt = null;
        jys = null;
    }
}
