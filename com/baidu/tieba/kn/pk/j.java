package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.at;
/* loaded from: classes.dex */
class j implements at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKWaitingActivity f1215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PKWaitingActivity pKWaitingActivity) {
        this.f1215a = pKWaitingActivity;
    }

    @Override // com.baidu.tieba.util.at
    public void a() {
        l lVar;
        lVar = this.f1215a.b;
        lVar.a().setVisibility(0);
        this.f1215a.f = true;
    }

    @Override // com.baidu.tieba.util.at
    public void b() {
        l lVar;
        lVar = this.f1215a.b;
        lVar.a().setVisibility(8);
        this.f1215a.f = false;
    }
}
