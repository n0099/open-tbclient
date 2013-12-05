package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2257a;
    final /* synthetic */ ed b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(ed edVar, String str) {
        this.b = edVar;
        this.f2257a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2257a);
    }
}
