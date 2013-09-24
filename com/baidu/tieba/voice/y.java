package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2059a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar, String str) {
        this.f2059a = rVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        aj.d(aj.b(this.b));
    }
}
