package com.baidu.tieba.square;

import com.baidu.tieba.data.ba;
import com.baidu.tieba.model.cj;
import com.baidu.tieba.model.ck;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class x implements ck {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareActivity squareActivity) {
        this.f2380a = squareActivity;
    }

    @Override // com.baidu.tieba.model.ck
    public void a(boolean z, String str, ba baVar) {
        ax axVar;
        boolean z2;
        ax axVar2;
        ax axVar3;
        boolean z3;
        ax axVar4;
        ax axVar5;
        cj cjVar;
        axVar = this.f2380a.f2330a;
        axVar.a(true, "");
        if (z) {
            axVar5 = this.f2380a.f2330a;
            cjVar = this.f2380a.b;
            axVar5.a(cjVar.a());
            this.f2380a.c = true;
            this.f2380a.e();
        }
        z2 = this.f2380a.d;
        if (z2) {
            this.f2380a.d = false;
            axVar4 = this.f2380a.f2330a;
            axVar4.f();
        }
        if (!UtilHelper.b()) {
            axVar3 = this.f2380a.f2330a;
            axVar3.h();
            z3 = this.f2380a.c;
            if (!z3) {
                this.f2380a.d();
                return;
            }
            return;
        }
        this.f2380a.a(str);
        axVar2 = this.f2380a.f2330a;
        axVar2.i();
    }
}
