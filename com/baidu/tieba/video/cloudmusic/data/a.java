package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes7.dex */
public class a {
    private static a krq = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> krr = new SparseArray<>();

    public static synchronized a cMS() {
        a aVar;
        synchronized (a.class) {
            if (krq == null) {
                krq = new a();
            }
            aVar = krq;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.krr.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cMT() {
        return this.krr.get(4096);
    }

    public void onDestroy() {
        this.krr = null;
        krq = null;
    }
}
