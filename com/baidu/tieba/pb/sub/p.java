package com.baidu.tieba.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
final class p implements Runnable {
    final /* synthetic */ o a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ View d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str, int i, View view) {
        this.a = oVar;
        this.b = str;
        this.c = i;
        this.d = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        m mVar;
        n nVar2;
        m mVar2;
        nVar = this.a.a;
        mVar = nVar.a;
        mVar.b(this.b);
        nVar2 = this.a.a;
        mVar2 = nVar2.a;
        mVar2.a(this.c, this.d);
    }
}
