package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.bn;
/* loaded from: classes.dex */
class j implements bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKWaitingActivity f1777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PKWaitingActivity pKWaitingActivity) {
        this.f1777a = pKWaitingActivity;
    }

    @Override // com.baidu.tieba.util.bn
    public void a() {
        l lVar;
        lVar = this.f1777a.b;
        lVar.a().setVisibility(0);
        this.f1777a.f = true;
    }

    @Override // com.baidu.tieba.util.bn
    public void b() {
        l lVar;
        lVar = this.f1777a.b;
        lVar.a().setVisibility(8);
        this.f1777a.f = false;
    }
}
