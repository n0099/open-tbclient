package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2776a;
    final /* synthetic */ WriteActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity, int i) {
        this.b = writeActivity;
        this.f2776a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f2776a);
    }
}
