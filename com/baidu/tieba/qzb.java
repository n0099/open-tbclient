package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface qzb {
    void onPlayerAudioStalls(yzb yzbVar, boolean z, int i);

    void onPlayerDecodeBitrate(yzb yzbVar, int i, int i2);

    void onPlayerDecodeOuputSize(yzb yzbVar, int i, int i2);

    void onPlayerDecodeType(yzb yzbVar, int i);

    void onPlayerReceiveToRenderDelay(yzb yzbVar, int i);

    void onPlayerRenderFramerate(yzb yzbVar, int i);

    void onPlayerVideoStalls(yzb yzbVar, boolean z, int i);
}
