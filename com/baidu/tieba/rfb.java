package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface rfb {
    void onPlayerAudioStalls(zfb zfbVar, boolean z, int i);

    void onPlayerDecodeBitrate(zfb zfbVar, int i, int i2);

    void onPlayerDecodeOuputSize(zfb zfbVar, int i, int i2);

    void onPlayerDecodeType(zfb zfbVar, int i);

    void onPlayerReceiveToRenderDelay(zfb zfbVar, int i);

    void onPlayerRenderFramerate(zfb zfbVar, int i);

    void onPlayerVideoStalls(zfb zfbVar, boolean z, int i);
}
