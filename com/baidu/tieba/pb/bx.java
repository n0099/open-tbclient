package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
final class bx implements Runnable {
    final /* synthetic */ bw a;
    private final /* synthetic */ com.baidu.tieba.data.av b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, com.baidu.tieba.data.av avVar, View view) {
        this.a = bwVar;
        this.b = avVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NewPbActivity newPbActivity;
        cu cuVar;
        NewPbActivity newPbActivity2;
        com.baidu.tieba.model.bb bbVar;
        newPbActivity = this.a.a;
        cuVar = newPbActivity.C;
        com.baidu.tieba.data.av avVar = this.b;
        View view = this.c;
        newPbActivity2 = this.a.a;
        bbVar = newPbActivity2.w;
        cuVar.a(false, avVar, null, null, view, bbVar.q().l());
    }
}
