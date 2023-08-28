package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface y0c {
    void onPlayerAudioStalls(g1c g1cVar, boolean z, int i);

    void onPlayerDecodeBitrate(g1c g1cVar, int i, int i2);

    void onPlayerDecodeOuputSize(g1c g1cVar, int i, int i2);

    void onPlayerDecodeType(g1c g1cVar, int i);

    void onPlayerReceiveToRenderDelay(g1c g1cVar, int i);

    void onPlayerRenderFramerate(g1c g1cVar, int i);

    void onPlayerVideoStalls(g1c g1cVar, boolean z, int i);
}
