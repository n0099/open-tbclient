package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2752a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VoiceManager voiceManager) {
        this.f2752a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.f2752a.B;
        if (bool != null) {
            bool2 = this.f2752a.B;
            if (bool2.booleanValue()) {
                this.f2752a.j();
            } else {
                this.f2752a.k();
            }
        }
    }
}
