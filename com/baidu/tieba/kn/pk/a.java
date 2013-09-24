package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class a implements be {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKEndActivity f1273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PKEndActivity pKEndActivity) {
        this.f1273a = pKEndActivity;
    }

    @Override // com.baidu.tieba.util.be
    public void a() {
        c cVar;
        cVar = this.f1273a.f1269a;
        cVar.a().setVisibility(0);
    }

    @Override // com.baidu.tieba.util.be
    public void b() {
        c cVar;
        cVar = this.f1273a.f1269a;
        cVar.a().setVisibility(8);
    }
}
