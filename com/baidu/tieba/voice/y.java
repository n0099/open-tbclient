package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ VoiceManager a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VoiceManager voiceManager, String str) {
        this.a = voiceManager;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        aj.d(aj.b(this.b));
    }
}
