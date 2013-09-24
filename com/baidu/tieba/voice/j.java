package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PlayVoiceBnt f2035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PlayVoiceBnt playVoiceBnt) {
        this.f2035a = playVoiceBnt;
    }

    @Override // java.lang.Runnable
    public void run() {
        ai aiVar;
        PlayVoiceBnt playVoiceBnt = this.f2035a;
        aiVar = this.f2035a.b;
        playVoiceBnt.a(aiVar);
    }
}
