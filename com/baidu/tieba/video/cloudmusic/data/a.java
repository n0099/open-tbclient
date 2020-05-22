package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a lAR = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> lAS = new SparseArray<>();

    public static synchronized a dhZ() {
        a aVar;
        synchronized (a.class) {
            if (lAR == null) {
                lAR = new a();
            }
            aVar = lAR;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.lAS.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dia() {
        return this.lAS.get(4096);
    }

    public void onDestroy() {
        this.lAS = null;
        lAR = null;
    }
}
