package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.av f2162a;
    final /* synthetic */ View b;
    final /* synthetic */ am c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, com.baidu.tieba.data.av avVar, View view) {
        this.c = amVar;
        this.f2162a = avVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        cr crVar;
        com.baidu.tieba.model.bm bmVar;
        crVar = this.c.f2161a.y;
        com.baidu.tieba.data.av avVar = this.f2162a;
        View view = this.b;
        bmVar = this.c.f2161a.s;
        crVar.a(false, avVar, true, null, null, view, bmVar.l().l());
    }
}
