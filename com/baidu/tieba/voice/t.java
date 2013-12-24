package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager.VoiceModel voiceModel;
        ad adVar;
        VoiceManager.VoiceModel voiceModel2;
        VoiceManager voiceManager = this.a;
        voiceModel = this.a.w;
        voiceManager.v = voiceModel;
        VoiceManager voiceManager2 = this.a;
        adVar = this.a.x;
        voiceManager2.y = adVar;
        this.a.x = null;
        VoiceManager voiceManager3 = this.a;
        voiceModel2 = this.a.v;
        voiceManager3.d(voiceModel2);
    }
}
