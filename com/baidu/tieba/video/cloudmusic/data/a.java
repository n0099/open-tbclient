package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes23.dex */
public class a {
    private static a nmZ = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nna = new SparseArray<>();

    public static synchronized a dOJ() {
        a aVar;
        synchronized (a.class) {
            if (nmZ == null) {
                nmZ = new a();
            }
            aVar = nmZ;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nna.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dOK() {
        return this.nna.get(4096);
    }

    public void onDestroy() {
        this.nna = null;
        nmZ = null;
    }
}
