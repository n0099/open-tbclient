package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hkM = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hkN = new SparseArray<>();

    public static synchronized a bDo() {
        a aVar;
        synchronized (a.class) {
            if (hkM == null) {
                hkM = new a();
            }
            aVar = hkM;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hkN.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bDp() {
        return this.hkN.get(4096);
    }

    public void onDestroy() {
        this.hkN = null;
        hkM = null;
    }
}
