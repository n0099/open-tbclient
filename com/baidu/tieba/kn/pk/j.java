package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.az;
/* loaded from: classes.dex */
class j implements az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKWaitingActivity f1248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PKWaitingActivity pKWaitingActivity) {
        this.f1248a = pKWaitingActivity;
    }

    @Override // com.baidu.tieba.util.az
    public void a() {
        l lVar;
        lVar = this.f1248a.b;
        lVar.a().setVisibility(0);
        this.f1248a.f = true;
    }

    @Override // com.baidu.tieba.util.az
    public void b() {
        l lVar;
        lVar = this.f1248a.b;
        lVar.a().setVisibility(8);
        this.f1248a.f = false;
    }
}
