package com.baidu.tieba;

import android.media.MediaPlayer;
/* loaded from: classes6.dex */
public interface k04 extends xz3 {
    void a(boolean z);

    void c(String str) throws Exception;

    void f(wc4 wc4Var);

    void g(MediaPlayer.OnInfoListener onInfoListener);

    void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void k(MediaPlayer.OnPreparedListener onPreparedListener);

    void l(MediaPlayer.OnErrorListener onErrorListener);

    void n(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void q(MediaPlayer.OnCompletionListener onCompletionListener);

    boolean s();

    void setVolume(float f);
}
