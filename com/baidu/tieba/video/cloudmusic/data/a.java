package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes17.dex */
public class a {
    private static a mcZ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> mda = new SparseArray<>();

    public static synchronized a dpO() {
        a aVar;
        synchronized (a.class) {
            if (mcZ == null) {
                mcZ = new a();
            }
            aVar = mcZ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.mda.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dpP() {
        return this.mda.get(4096);
    }

    public void onDestroy() {
        this.mda = null;
        mcZ = null;
    }
}
