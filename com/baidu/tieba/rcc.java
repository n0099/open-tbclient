package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface rcc {
    void onPlayerAudioStalls(zcc zccVar, boolean z, int i);

    void onPlayerDecodeBitrate(zcc zccVar, int i, int i2);

    void onPlayerDecodeOuputSize(zcc zccVar, int i, int i2);

    void onPlayerDecodeType(zcc zccVar, int i);

    void onPlayerReceiveToRenderDelay(zcc zccVar, int i);

    void onPlayerRenderFramerate(zcc zccVar, int i);

    void onPlayerVideoStalls(zcc zccVar, boolean z, int i);
}
