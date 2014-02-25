package com.baidu.tieba.voice;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ z a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, String str, int i) {
        this.a = zVar;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.a.a;
        voiceManager.H = 1;
        voiceManager2 = this.a.a;
        voiceManager2.a.a(this.b, this.c);
    }
}
