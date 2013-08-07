package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.at;
/* loaded from: classes.dex */
class p implements at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PKingActivity pKingActivity) {
        this.f1221a = pKingActivity;
    }

    @Override // com.baidu.tieba.util.at
    public void a() {
        t tVar;
        tVar = this.f1221a.b;
        tVar.a().setVisibility(0);
        this.f1221a.j = true;
    }

    @Override // com.baidu.tieba.util.at
    public void b() {
        t tVar;
        tVar = this.f1221a.b;
        tVar.a().setVisibility(8);
        this.f1221a.j = false;
    }
}
