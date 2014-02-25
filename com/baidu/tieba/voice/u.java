package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad m;
        m = this.a.m();
        if (m != null) {
            this.a.b(m);
        }
    }
}
