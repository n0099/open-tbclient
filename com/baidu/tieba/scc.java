package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface scc {
    void onPlayerAudioStalls(adc adcVar, boolean z, int i);

    void onPlayerDecodeBitrate(adc adcVar, int i, int i2);

    void onPlayerDecodeOuputSize(adc adcVar, int i, int i2);

    void onPlayerDecodeType(adc adcVar, int i);

    void onPlayerReceiveToRenderDelay(adc adcVar, int i);

    void onPlayerRenderFramerate(adc adcVar, int i);

    void onPlayerVideoStalls(adc adcVar, boolean z, int i);
}
