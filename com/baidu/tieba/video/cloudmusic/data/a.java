package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes23.dex */
public class a {
    private static a mUD = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> mUE = new SparseArray<>();

    public static synchronized a dIZ() {
        a aVar;
        synchronized (a.class) {
            if (mUD == null) {
                mUD = new a();
            }
            aVar = mUD;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.mUE.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dJa() {
        return this.mUE.get(4096);
    }

    public void onDestroy() {
        this.mUE = null;
        mUD = null;
    }
}
