package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(VoiceManager voiceManager) {
        this.f2645a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager.VoiceModel voiceModel;
        ad adVar;
        VoiceManager.VoiceModel voiceModel2;
        VoiceManager voiceManager = this.f2645a;
        voiceModel = this.f2645a.w;
        voiceManager.v = voiceModel;
        VoiceManager voiceManager2 = this.f2645a;
        adVar = this.f2645a.x;
        voiceManager2.y = adVar;
        this.f2645a.x = null;
        VoiceManager voiceManager3 = this.f2645a;
        voiceModel2 = this.f2645a.v;
        voiceManager3.d(voiceModel2);
    }
}
