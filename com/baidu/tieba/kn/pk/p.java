package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class p implements be {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PKingActivity pKingActivity) {
        this.f1288a = pKingActivity;
    }

    @Override // com.baidu.tieba.util.be
    public void a() {
        t tVar;
        tVar = this.f1288a.b;
        tVar.a().setVisibility(0);
        this.f1288a.j = true;
    }

    @Override // com.baidu.tieba.util.be
    public void b() {
        t tVar;
        tVar = this.f1288a.b;
        tVar.a().setVisibility(8);
        this.f1288a.j = false;
    }
}
