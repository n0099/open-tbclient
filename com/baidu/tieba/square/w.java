package com.baidu.tieba.square;

import com.baidu.tieba.data.bc;
import com.baidu.tieba.model.bx;
import com.baidu.tieba.model.by;
import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class w implements by {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f1758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareActivity squareActivity) {
        this.f1758a = squareActivity;
    }

    @Override // com.baidu.tieba.model.by
    public void a(boolean z, String str, bc bcVar) {
        ab abVar;
        boolean z2;
        ab abVar2;
        ab abVar3;
        boolean z3;
        ab abVar4;
        ab abVar5;
        bx bxVar;
        abVar = this.f1758a.f1734a;
        abVar.a(true, "");
        if (z) {
            abVar5 = this.f1758a.f1734a;
            bxVar = this.f1758a.b;
            abVar5.a(bxVar.a());
            this.f1758a.c = true;
            this.f1758a.k();
        }
        z2 = this.f1758a.d;
        if (z2) {
            this.f1758a.d = false;
            abVar4 = this.f1758a.f1734a;
            abVar4.c();
        }
        if (NetWorkCore.b(this.f1758a) == NetWorkCore.NetworkState.UNAVAIL) {
            abVar3 = this.f1758a.f1734a;
            abVar3.e();
            z3 = this.f1758a.c;
            if (z3) {
                return;
            }
            this.f1758a.d();
            return;
        }
        this.f1758a.a(str);
        abVar2 = this.f1758a.f1734a;
        abVar2.f();
    }
}
