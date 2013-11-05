package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(VoiceManager voiceManager) {
        this.f2561a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.f2561a.B;
        if (bool != null) {
            bool2 = this.f2561a.B;
            if (bool2.booleanValue()) {
                this.f2561a.j();
            } else {
                this.f2561a.k();
            }
        }
    }
}
