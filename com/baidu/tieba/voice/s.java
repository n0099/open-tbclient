package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ VoiceManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(VoiceManager voiceManager, String str) {
        this.b = voiceManager;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (aj.d(aj.b(this.a))) {
        }
    }
}
