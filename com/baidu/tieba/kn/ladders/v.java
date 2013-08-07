package com.baidu.tieba.kn.ladders;

import android.support.v4.view.bq;
/* loaded from: classes.dex */
class v implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnTabActivity f1199a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(KnTabActivity knTabActivity) {
        this.f1199a = knTabActivity;
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        x xVar;
        xVar = this.f1199a.f1179a;
        xVar.j.setPosition(i + f);
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        x xVar;
        x xVar2;
        x xVar3;
        if (i == 0) {
            xVar = this.f1199a.f1179a;
            int currentItem = xVar.i.getCurrentItem();
            if (currentItem == 0) {
                xVar3 = this.f1199a.f1179a;
                xVar3.j.setPosition(0.0f);
            } else if (currentItem == 1) {
                xVar2 = this.f1199a.f1179a;
                xVar2.j.setPosition(1.0f);
            }
        }
    }
}
