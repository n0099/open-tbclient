package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class a {
    private static a hoR = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> hoS = new SparseArray<>();

    public static synchronized a bAX() {
        a aVar;
        synchronized (a.class) {
            if (hoR == null) {
                hoR = new a();
            }
            aVar = hoR;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.hoS.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList bAY() {
        return this.hoS.get(4096);
    }

    public void onDestroy() {
        this.hoS = null;
        hoR = null;
    }
}
