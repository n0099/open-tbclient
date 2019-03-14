package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a iVR = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> iVS = new SparseArray<>();

    public static synchronized a cje() {
        a aVar;
        synchronized (a.class) {
            if (iVR == null) {
                iVR = new a();
            }
            aVar = iVR;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.iVS.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cjf() {
        return this.iVS.get(4096);
    }

    public void onDestroy() {
        this.iVS = null;
        iVR = null;
    }
}
