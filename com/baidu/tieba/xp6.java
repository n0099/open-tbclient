package com.baidu.tieba;

import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.external.music.data.MusicData;
/* loaded from: classes6.dex */
public interface xp6 {
    void a(float f);

    String b();

    void c(MusicData musicData, Object obj);

    void d();

    void e(TbMusicData tbMusicData);

    void f(String str, String str2);

    boolean g();

    void onPause();

    void onResume();

    void pause();

    void releasePlayer();

    void reset();
}
