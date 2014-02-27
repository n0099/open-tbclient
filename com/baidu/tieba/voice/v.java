package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.a.B;
        if (bool != null) {
            bool2 = this.a.B;
            if (bool2.booleanValue()) {
                this.a.l();
            } else {
                this.a.m();
            }
        }
    }
}
