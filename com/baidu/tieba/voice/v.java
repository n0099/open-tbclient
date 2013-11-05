package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VoiceManager voiceManager) {
        this.f2595a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.f2595a.f2553a != null) {
            i = this.f2595a.H;
            if (i == 2) {
                this.f2595a.f2553a.C();
            }
        }
    }
}
