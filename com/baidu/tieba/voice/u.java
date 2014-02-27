package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ad o;
        o = this.a.o();
        if (o != null) {
            this.a.b(o);
        }
    }
}
