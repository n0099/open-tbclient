package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2165a;
    final /* synthetic */ eb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(eb ebVar, String str) {
        this.b = ebVar;
        this.f2165a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2165a);
    }
}
