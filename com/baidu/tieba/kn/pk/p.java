package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.bn;
/* loaded from: classes.dex */
class p implements bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PKingActivity pKingActivity) {
        this.f1783a = pKingActivity;
    }

    @Override // com.baidu.tieba.util.bn
    public void a() {
        t tVar;
        tVar = this.f1783a.b;
        tVar.a().setVisibility(0);
        this.f1783a.j = true;
    }

    @Override // com.baidu.tieba.util.bn
    public void b() {
        t tVar;
        tVar = this.f1783a.b;
        tVar.a().setVisibility(8);
        this.f1783a.j = false;
    }
}
