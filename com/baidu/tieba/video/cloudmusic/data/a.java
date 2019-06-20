package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a joI = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> joJ = new SparseArray<>();

    public static synchronized a cri() {
        a aVar;
        synchronized (a.class) {
            if (joI == null) {
                joI = new a();
            }
            aVar = joI;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.joJ.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList crj() {
        return this.joJ.get(4096);
    }

    public void onDestroy() {
        this.joJ = null;
        joI = null;
    }
}
