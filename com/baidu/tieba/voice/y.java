package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VoiceManager voiceManager) {
        this.f2751a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad m;
        m = this.f2751a.m();
        if (m != null) {
            this.f2751a.b(m);
        }
    }
}
