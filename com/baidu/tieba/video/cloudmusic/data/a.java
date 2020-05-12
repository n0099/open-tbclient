package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class a {
    private static a lig = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> lih = new SparseArray<>();

    public static synchronized a daL() {
        a aVar;
        synchronized (a.class) {
            if (lig == null) {
                lig = new a();
            }
            aVar = lig;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.lih.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList daM() {
        return this.lih.get(4096);
    }

    public void onDestroy() {
        this.lih = null;
        lig = null;
    }
}
