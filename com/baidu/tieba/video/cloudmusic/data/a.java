package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes7.dex */
public class a {
    private static a nBN = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> nBO = new SparseArray<>();

    public static synchronized a dQb() {
        a aVar;
        synchronized (a.class) {
            if (nBN == null) {
                nBN = new a();
            }
            aVar = nBN;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.nBO.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dQc() {
        return this.nBO.get(4096);
    }

    public void onDestroy() {
        this.nBO = null;
        nBN = null;
    }
}
