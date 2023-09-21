package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface t5c {
    void onPlayerAudioStalls(b6c b6cVar, boolean z, int i);

    void onPlayerDecodeBitrate(b6c b6cVar, int i, int i2);

    void onPlayerDecodeOuputSize(b6c b6cVar, int i, int i2);

    void onPlayerDecodeType(b6c b6cVar, int i);

    void onPlayerReceiveToRenderDelay(b6c b6cVar, int i);

    void onPlayerRenderFramerate(b6c b6cVar, int i);

    void onPlayerVideoStalls(b6c b6cVar, boolean z, int i);
}
