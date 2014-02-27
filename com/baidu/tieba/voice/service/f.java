package com.baidu.tieba.voice.service;
/* loaded from: classes.dex */
final class f implements Runnable {
    final /* synthetic */ MyAudioRecorder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyAudioRecorder myAudioRecorder) {
        this.a = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MyAudioRecorder.a(this.a);
    }
}
