package com.baidu.tieba.square;

import com.baidu.tieba.data.bc;
import com.baidu.tieba.model.bz;
import com.baidu.tieba.model.ca;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class x implements ca {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f1858a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareActivity squareActivity) {
        this.f1858a = squareActivity;
    }

    @Override // com.baidu.tieba.model.ca
    public void a(boolean z, String str, bc bcVar) {
        ax axVar;
        boolean z2;
        ax axVar2;
        ax axVar3;
        boolean z3;
        ax axVar4;
        ax axVar5;
        bz bzVar;
        axVar = this.f1858a.f1809a;
        axVar.a(true, "");
        if (z) {
            axVar5 = this.f1858a.f1809a;
            bzVar = this.f1858a.b;
            axVar5.a(bzVar.a());
            this.f1858a.c = true;
            this.f1858a.e();
        }
        z2 = this.f1858a.d;
        if (z2) {
            this.f1858a.d = false;
            axVar4 = this.f1858a.f1809a;
            axVar4.d();
        }
        if (!UtilHelper.b()) {
            axVar3 = this.f1858a.f1809a;
            axVar3.f();
            z3 = this.f1858a.c;
            if (z3) {
                return;
            }
            this.f1858a.d();
            return;
        }
        this.f1858a.a(str);
        axVar2 = this.f1858a.f1809a;
        axVar2.g();
    }
}
