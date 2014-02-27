package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class el implements Runnable {
    final /* synthetic */ ed a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ed edVar, String str) {
        this.a = edVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}
