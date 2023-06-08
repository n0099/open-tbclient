package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface wfb {
    void onPlayerAudioStalls(egb egbVar, boolean z, int i);

    void onPlayerDecodeBitrate(egb egbVar, int i, int i2);

    void onPlayerDecodeOuputSize(egb egbVar, int i, int i2);

    void onPlayerDecodeType(egb egbVar, int i);

    void onPlayerReceiveToRenderDelay(egb egbVar, int i);

    void onPlayerRenderFramerate(egb egbVar, int i);

    void onPlayerVideoStalls(egb egbVar, boolean z, int i);
}
