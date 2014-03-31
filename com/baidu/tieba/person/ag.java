package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class ag implements Runnable {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.a = afVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
