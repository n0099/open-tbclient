package com.baidu.tieba.voice;
/* loaded from: classes.dex */
class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2598a;
    final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, String str) {
        this.b = wVar;
        this.f2598a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.H = 1;
        this.b.c.f2553a.a(this.f2598a, this.b.b);
    }
}
