package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2746a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(VoiceManager voiceManager) {
        this.f2746a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager.VoiceModel voiceModel;
        ad adVar;
        VoiceManager.VoiceModel voiceModel2;
        VoiceManager voiceManager = this.f2746a;
        voiceModel = this.f2746a.w;
        voiceManager.v = voiceModel;
        VoiceManager voiceManager2 = this.f2746a;
        adVar = this.f2746a.x;
        voiceManager2.y = adVar;
        this.f2746a.x = null;
        VoiceManager voiceManager3 = this.f2746a;
        voiceModel2 = this.f2746a.v;
        voiceManager3.d(voiceModel2);
    }
}
