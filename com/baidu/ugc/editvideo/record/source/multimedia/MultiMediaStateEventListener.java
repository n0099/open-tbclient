package com.baidu.ugc.editvideo.record.source.multimedia;
/* loaded from: classes5.dex */
public interface MultiMediaStateEventListener {
    void onIndexChanged(int i2, int i3);

    void onLoop();

    void onPlayEnd();

    void onRepeatIndexEnd(int i2);

    void onRepeatIndexLoop(int i2);
}
