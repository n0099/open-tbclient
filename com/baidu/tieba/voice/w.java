package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.a.e()) {
            this.a.w();
        }
    }
}
