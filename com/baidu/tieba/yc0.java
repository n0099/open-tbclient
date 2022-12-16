package com.baidu.tieba;

import com.baidu.mario.audio.AudioParams;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface yc0 {
    void a(boolean z, AudioParams audioParams);

    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioStop(boolean z);
}
