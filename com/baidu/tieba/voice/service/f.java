package com.baidu.tieba.voice.service;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyAudioRecorder f2744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyAudioRecorder myAudioRecorder) {
        this.f2744a = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2744a.i();
    }
}
