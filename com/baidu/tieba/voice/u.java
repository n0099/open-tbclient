package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VoiceManager voiceManager) {
        this.f2629a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.f2629a.f2590a != null) {
            i = this.f2629a.H;
            if (i == 2) {
                this.f2629a.f2590a.C();
            }
        }
    }
}
