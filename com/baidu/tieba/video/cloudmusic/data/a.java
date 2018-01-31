package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hnP = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hnQ = new SparseArray<>();

    public static synchronized a bAo() {
        a aVar;
        synchronized (a.class) {
            if (hnP == null) {
                hnP = new a();
            }
            aVar = hnP;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hnQ.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAp() {
        return this.hnQ.get(4096);
    }

    public void onDestroy() {
        this.hnQ = null;
        hnP = null;
    }
}
