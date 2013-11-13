package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VoiceManager voiceManager) {
        this.f2646a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.f2646a.f2607a != null) {
            i = this.f2646a.H;
            if (i == 2) {
                this.f2646a.f2607a.C();
            }
        }
    }
}
