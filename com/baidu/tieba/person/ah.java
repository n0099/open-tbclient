package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class ah implements Runnable {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
