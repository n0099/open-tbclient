package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        if (this.a.a == null) {
            return;
        }
        i = this.a.H;
        if (i == 2) {
            ae aeVar = this.a.a;
        }
    }
}
