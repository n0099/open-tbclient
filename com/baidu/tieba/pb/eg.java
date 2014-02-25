package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class eg implements Runnable {
    final /* synthetic */ ef a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ View d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ef efVar, String str, int i, View view) {
        this.a = efVar;
        this.b = str;
        this.c = i;
        this.d = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ee eeVar;
        ed edVar;
        ee eeVar2;
        ed edVar2;
        eeVar = this.a.a;
        edVar = eeVar.a;
        edVar.b(this.b);
        eeVar2 = this.a.a;
        edVar2 = eeVar2.a;
        edVar2.a(this.c, this.d);
    }
}
