package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a joE = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> joF = new SparseArray<>();

    public static synchronized a crh() {
        a aVar;
        synchronized (a.class) {
            if (joE == null) {
                joE = new a();
            }
            aVar = joE;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.joF.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList cri() {
        return this.joF.get(4096);
    }

    public void onDestroy() {
        this.joF = null;
        joE = null;
    }
}
