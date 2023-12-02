package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface mhc {
    void onPlayerAudioStalls(uhc uhcVar, boolean z, int i);

    void onPlayerDecodeBitrate(uhc uhcVar, int i, int i2);

    void onPlayerDecodeOuputSize(uhc uhcVar, int i, int i2);

    void onPlayerDecodeType(uhc uhcVar, int i);

    void onPlayerReceiveToRenderDelay(uhc uhcVar, int i);

    void onPlayerRenderFramerate(uhc uhcVar, int i);

    void onPlayerVideoStalls(uhc uhcVar, boolean z, int i);
}
