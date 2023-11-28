package com.baidu.tieba;

import android.media.MediaPlayer;
/* loaded from: classes7.dex */
public interface l04 extends yz3 {
    void a(boolean z);

    void c(String str) throws Exception;

    void f(xc4 xc4Var);

    void g(MediaPlayer.OnInfoListener onInfoListener);

    void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void j(MediaPlayer.OnPreparedListener onPreparedListener);

    void l(MediaPlayer.OnErrorListener onErrorListener);

    void n(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void q(MediaPlayer.OnCompletionListener onCompletionListener);

    boolean s();

    void setVolume(float f);
}
