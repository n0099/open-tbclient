package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface phb {
    void onPlayerAudioStalls(xhb xhbVar, boolean z, int i);

    void onPlayerDecodeBitrate(xhb xhbVar, int i, int i2);

    void onPlayerDecodeOuputSize(xhb xhbVar, int i, int i2);

    void onPlayerDecodeType(xhb xhbVar, int i);

    void onPlayerReceiveToRenderDelay(xhb xhbVar, int i);

    void onPlayerRenderFramerate(xhb xhbVar, int i);

    void onPlayerVideoStalls(xhb xhbVar, boolean z, int i);
}
