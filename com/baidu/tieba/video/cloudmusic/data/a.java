package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes17.dex */
public class a {
    private static a mdb = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> mdc = new SparseArray<>();

    public static synchronized a dpP() {
        a aVar;
        synchronized (a.class) {
            if (mdb == null) {
                mdb = new a();
            }
            aVar = mdb;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.mdc.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dpQ() {
        return this.mdc.get(4096);
    }

    public void onDestroy() {
        this.mdc = null;
        mdb = null;
    }
}
