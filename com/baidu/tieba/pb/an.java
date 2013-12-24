package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class an implements Runnable {
    final /* synthetic */ com.baidu.tieba.data.av a;
    final /* synthetic */ View b;
    final /* synthetic */ am c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, com.baidu.tieba.data.av avVar, View view) {
        this.c = amVar;
        this.a = avVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        cr crVar;
        com.baidu.tieba.model.bm bmVar;
        crVar = this.c.a.x;
        com.baidu.tieba.data.av avVar = this.a;
        View view = this.b;
        bmVar = this.c.a.r;
        crVar.a(false, avVar, true, null, null, view, bmVar.l().l());
    }
}
