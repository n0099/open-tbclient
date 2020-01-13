package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes8.dex */
public class a {
    private static a kuT = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> kuU = new SparseArray<>();

    public static synchronized a cNX() {
        a aVar;
        synchronized (a.class) {
            if (kuT == null) {
                kuT = new a();
            }
            aVar = kuT;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.kuU.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cNY() {
        return this.kuU.get(4096);
    }

    public void onDestroy() {
        this.kuU = null;
        kuT = null;
    }
}
