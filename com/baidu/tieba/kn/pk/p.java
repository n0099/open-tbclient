package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.az;
/* loaded from: classes.dex */
class p implements az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1254a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PKingActivity pKingActivity) {
        this.f1254a = pKingActivity;
    }

    @Override // com.baidu.tieba.util.az
    public void a() {
        t tVar;
        tVar = this.f1254a.b;
        tVar.a().setVisibility(0);
        this.f1254a.j = true;
    }

    @Override // com.baidu.tieba.util.az
    public void b() {
        t tVar;
        tVar = this.f1254a.b;
        tVar.a().setVisibility(8);
        this.f1254a.j = false;
    }
}
