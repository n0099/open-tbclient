package com.baidu.tieba.kn.ladders;

import android.support.v4.view.bq;
/* loaded from: classes.dex */
class v implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnTabActivity f1265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(KnTabActivity knTabActivity) {
        this.f1265a = knTabActivity;
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        y yVar;
        yVar = this.f1265a.f1245a;
        yVar.j.setPosition(i + f);
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        y yVar;
        y yVar2;
        y yVar3;
        if (i == 0) {
            yVar = this.f1265a.f1245a;
            int currentItem = yVar.i.getCurrentItem();
            if (currentItem == 0) {
                yVar3 = this.f1265a.f1245a;
                yVar3.j.setPosition(0.0f);
            } else if (currentItem == 1) {
                yVar2 = this.f1265a.f1245a;
                yVar2.j.setPosition(1.0f);
            }
        }
    }
}
