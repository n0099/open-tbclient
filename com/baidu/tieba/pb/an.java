package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.aw f2071a;
    final /* synthetic */ View b;
    final /* synthetic */ am c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, com.baidu.tieba.data.aw awVar, View view) {
        this.c = amVar;
        this.f2071a = awVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        cp cpVar;
        com.baidu.tieba.model.bm bmVar;
        cpVar = this.c.f2070a.y;
        com.baidu.tieba.data.aw awVar = this.f2071a;
        View view = this.b;
        bmVar = this.c.f2070a.s;
        cpVar.a(false, awVar, true, null, null, view, bmVar.l().l());
    }
}
