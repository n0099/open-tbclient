package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes17.dex */
public class a {
    private static a muM = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> muN = new SparseArray<>();

    public static synchronized a dBk() {
        a aVar;
        synchronized (a.class) {
            if (muM == null) {
                muM = new a();
            }
            aVar = muM;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.muN.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dBl() {
        return this.muN.get(4096);
    }

    public void onDestroy() {
        this.muN = null;
        muM = null;
    }
}
