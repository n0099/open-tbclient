package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes7.dex */
public class a {
    private static a nBM = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nBN = new SparseArray<>();

    public static synchronized a dQb() {
        a aVar;
        synchronized (a.class) {
            if (nBM == null) {
                nBM = new a();
            }
            aVar = nBM;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nBN.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dQc() {
        return this.nBN.get(4096);
    }

    public void onDestroy() {
        this.nBN = null;
        nBM = null;
    }
}
