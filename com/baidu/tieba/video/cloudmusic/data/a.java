package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a jyk = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> jyl = new SparseArray<>();

    public static synchronized a csS() {
        a aVar;
        synchronized (a.class) {
            if (jyk == null) {
                jyk = new a();
            }
            aVar = jyk;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.jyl.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList csT() {
        return this.jyl.get(4096);
    }

    public void onDestroy() {
        this.jyl = null;
        jyk = null;
    }
}
