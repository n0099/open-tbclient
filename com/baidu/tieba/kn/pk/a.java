package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.az;
/* loaded from: classes.dex */
class a implements az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKEndActivity f1239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PKEndActivity pKEndActivity) {
        this.f1239a = pKEndActivity;
    }

    @Override // com.baidu.tieba.util.az
    public void a() {
        c cVar;
        cVar = this.f1239a.f1235a;
        cVar.a().setVisibility(0);
    }

    @Override // com.baidu.tieba.util.az
    public void b() {
        c cVar;
        cVar = this.f1239a.f1235a;
        cVar.a().setVisibility(8);
    }
}
