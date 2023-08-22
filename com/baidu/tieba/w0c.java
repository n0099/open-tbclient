package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface w0c {
    void onPlayerAudioStalls(e1c e1cVar, boolean z, int i);

    void onPlayerDecodeBitrate(e1c e1cVar, int i, int i2);

    void onPlayerDecodeOuputSize(e1c e1cVar, int i, int i2);

    void onPlayerDecodeType(e1c e1cVar, int i);

    void onPlayerReceiveToRenderDelay(e1c e1cVar, int i);

    void onPlayerRenderFramerate(e1c e1cVar, int i);

    void onPlayerVideoStalls(e1c e1cVar, boolean z, int i);
}
