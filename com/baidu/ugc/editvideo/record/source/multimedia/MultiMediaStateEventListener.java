package com.baidu.ugc.editvideo.record.source.multimedia;
/* loaded from: classes4.dex */
public interface MultiMediaStateEventListener {
    void onIndexChanged(int i, int i2);

    void onLoop();

    void onPlayEnd();

    void onRepeatIndexEnd(int i);

    void onRepeatIndexLoop(int i);
}
