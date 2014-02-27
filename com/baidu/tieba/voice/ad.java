package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
/* loaded from: classes.dex */
public interface ad {
    void a(int i);

    void a(int i, String str);

    void a(VoiceManager.VoiceModel voiceModel);

    ad getRealView();

    VoiceManager.VoiceModel getVoiceModel();
}
