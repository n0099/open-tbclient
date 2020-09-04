package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes17.dex */
public class a {
    private static a mve = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> mvf = new SparseArray<>();

    public static synchronized a dBt() {
        a aVar;
        synchronized (a.class) {
            if (mve == null) {
                mve = new a();
            }
            aVar = mve;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.mvf.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dBu() {
        return this.mvf.get(4096);
    }

    public void onDestroy() {
        this.mvf = null;
        mve = null;
    }
}
