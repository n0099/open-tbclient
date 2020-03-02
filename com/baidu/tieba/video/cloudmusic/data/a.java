package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a kvX = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> kvY = new SparseArray<>();

    public static synchronized a cPw() {
        a aVar;
        synchronized (a.class) {
            if (kvX == null) {
                kvX = new a();
            }
            aVar = kvX;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.kvY.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cPx() {
        return this.kvY.get(4096);
    }

    public void onDestroy() {
        this.kvY = null;
        kvX = null;
    }
}
