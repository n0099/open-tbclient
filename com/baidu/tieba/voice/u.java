package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VoiceManager voiceManager) {
        this.f2594a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager.VoiceModel voiceModel;
        ae aeVar;
        VoiceManager.VoiceModel voiceModel2;
        VoiceManager voiceManager = this.f2594a;
        voiceModel = this.f2594a.w;
        voiceManager.v = voiceModel;
        VoiceManager voiceManager2 = this.f2594a;
        aeVar = this.f2594a.x;
        voiceManager2.y = aeVar;
        this.f2594a.x = null;
        VoiceManager voiceManager3 = this.f2594a;
        voiceModel2 = this.f2594a.v;
        voiceManager3.d(voiceModel2);
    }
}
