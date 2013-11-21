package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(VoiceManager voiceManager) {
        this.f2598a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f2598a.e()) {
            this.f2598a.w();
        }
    }
}
