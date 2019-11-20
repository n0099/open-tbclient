package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a jxt = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> jxu = new SparseArray<>();

    public static synchronized a csQ() {
        a aVar;
        synchronized (a.class) {
            if (jxt == null) {
                jxt = new a();
            }
            aVar = jxt;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.jxu.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList csR() {
        return this.jxu.get(4096);
    }

    public void onDestroy() {
        this.jxu = null;
        jxt = null;
    }
}
