package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface nhc {
    void onPlayerAudioStalls(vhc vhcVar, boolean z, int i);

    void onPlayerDecodeBitrate(vhc vhcVar, int i, int i2);

    void onPlayerDecodeOuputSize(vhc vhcVar, int i, int i2);

    void onPlayerDecodeType(vhc vhcVar, int i);

    void onPlayerReceiveToRenderDelay(vhc vhcVar, int i);

    void onPlayerRenderFramerate(vhc vhcVar, int i);

    void onPlayerVideoStalls(vhc vhcVar, boolean z, int i);
}
