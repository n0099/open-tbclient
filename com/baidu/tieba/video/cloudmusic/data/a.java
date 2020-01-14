package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes8.dex */
public class a {
    private static a kuY = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> kuZ = new SparseArray<>();

    public static synchronized a cNZ() {
        a aVar;
        synchronized (a.class) {
            if (kuY == null) {
                kuY = new a();
            }
            aVar = kuY;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.kuZ.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cOa() {
        return this.kuZ.get(4096);
    }

    public void onDestroy() {
        this.kuZ = null;
        kuY = null;
    }
}
