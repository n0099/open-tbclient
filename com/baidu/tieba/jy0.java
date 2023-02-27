package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface jy0 {
    void onBufferingUpdate(int i);

    void onCompletion();

    boolean onError(int i, int i2, Object obj);

    boolean onInfo(int i, int i2, Object obj);

    boolean onMediaSourceChanged(int i, int i2, Object obj);

    void onPrepared();

    void onSeekComplete();

    void onVideoSizeChanged(int i, int i2, int i3, int i4);
}
