package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class am implements Runnable {
    final /* synthetic */ com.baidu.tieba.data.ax a;
    final /* synthetic */ View b;
    final /* synthetic */ al c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, com.baidu.tieba.data.ax axVar, View view) {
        this.c = alVar;
        this.a = axVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        cs csVar;
        com.baidu.tieba.model.bm bmVar;
        csVar = this.c.a.z;
        com.baidu.tieba.data.ax axVar = this.a;
        View view = this.b;
        bmVar = this.c.a.t;
        csVar.a(false, axVar, true, null, null, view, bmVar.l().l());
    }
}
