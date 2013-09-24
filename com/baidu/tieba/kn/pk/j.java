package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class j implements be {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKWaitingActivity f1282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PKWaitingActivity pKWaitingActivity) {
        this.f1282a = pKWaitingActivity;
    }

    @Override // com.baidu.tieba.util.be
    public void a() {
        l lVar;
        lVar = this.f1282a.b;
        lVar.a().setVisibility(0);
        this.f1282a.f = true;
    }

    @Override // com.baidu.tieba.util.be
    public void b() {
        l lVar;
        lVar = this.f1282a.b;
        lVar.a().setVisibility(8);
        this.f1282a.f = false;
    }
}
