package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes22.dex */
public class a {
    private static a mEP = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> mEQ = new SparseArray<>();

    public static synchronized a dFn() {
        a aVar;
        synchronized (a.class) {
            if (mEP == null) {
                mEP = new a();
            }
            aVar = mEP;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.mEQ.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList dFo() {
        return this.mEQ.get(4096);
    }

    public void onDestroy() {
        this.mEQ = null;
        mEP = null;
    }
}
