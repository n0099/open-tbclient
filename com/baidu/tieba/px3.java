package com.baidu.tieba;

import android.media.MediaPlayer;
/* loaded from: classes5.dex */
public interface px3 extends cx3 {
    void a(boolean z);

    void c(String str) throws Exception;

    void f(ba4 ba4Var);

    void g(MediaPlayer.OnInfoListener onInfoListener);

    void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void j(MediaPlayer.OnPreparedListener onPreparedListener);

    void k(MediaPlayer.OnErrorListener onErrorListener);

    void n(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void q(MediaPlayer.OnCompletionListener onCompletionListener);

    boolean s();

    void setVolume(float f);
}
