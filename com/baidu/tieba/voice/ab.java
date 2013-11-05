package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(VoiceManager voiceManager) {
        this.f2562a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f2562a.e()) {
            this.f2562a.w();
        }
    }
}
