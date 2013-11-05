package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VoiceManager voiceManager) {
        this.f2599a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        ae m;
        m = this.f2599a.m();
        if (m != null) {
            this.f2599a.b(m);
        }
    }
}
