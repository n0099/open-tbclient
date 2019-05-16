package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a joD = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> joE = new SparseArray<>();

    public static synchronized a crf() {
        a aVar;
        synchronized (a.class) {
            if (joD == null) {
                joD = new a();
            }
            aVar = joD;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.joE.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList crg() {
        return this.joE.get(4096);
    }

    public void onDestroy() {
        this.joE = null;
        joD = null;
    }
}
