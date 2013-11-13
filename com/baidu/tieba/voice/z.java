package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VoiceManager voiceManager) {
        this.f2651a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.f2651a.B;
        if (bool != null) {
            bool2 = this.f2651a.B;
            if (bool2.booleanValue()) {
                this.f2651a.j();
            } else {
                this.f2651a.k();
            }
        }
    }
}
