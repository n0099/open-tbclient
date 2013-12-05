package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2747a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VoiceManager voiceManager) {
        this.f2747a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.f2747a.f2708a != null) {
            i = this.f2747a.H;
            if (i == 2) {
                this.f2747a.f2708a.C();
            }
        }
    }
}
