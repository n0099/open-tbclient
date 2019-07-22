package com.baidu.tieba.video.cloudmusic.data;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {
    private static a juP = null;
    private SparseArray<CloudMusicData.MusicTagList.MusicList> juQ = new SparseArray<>();

    public static synchronized a ctT() {
        a aVar;
        synchronized (a.class) {
            if (juP == null) {
                juP = new a();
            }
            aVar = juP;
        }
        return aVar;
    }

    private a() {
    }

    public void a(CloudMusicData.MusicTagList.MusicList musicList) {
        this.juQ.put(4096, musicList);
    }

    public CloudMusicData.MusicTagList.MusicList ctU() {
        return this.juQ.get(4096);
    }

    public void onDestroy() {
        this.juQ = null;
        juP = null;
    }
}
