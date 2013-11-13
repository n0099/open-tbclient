package com.baidu.tieba.write;
/* loaded from: classes.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2675a;
    final /* synthetic */ WriteActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity, int i) {
        this.b = writeActivity;
        this.f2675a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f2675a);
    }
}
