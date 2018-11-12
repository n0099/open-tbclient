package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a htM = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> htN = new SparseArray<>();

    public static synchronized a bGb() {
        a aVar;
        synchronized (a.class) {
            if (htM == null) {
                htM = new a();
            }
            aVar = htM;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.htN.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bGc() {
        return this.htN.get(4096);
    }

    public void onDestroy() {
        this.htN = null;
        htM = null;
    }
}
