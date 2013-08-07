package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.at;
/* loaded from: classes.dex */
class a implements at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKEndActivity f1206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PKEndActivity pKEndActivity) {
        this.f1206a = pKEndActivity;
    }

    @Override // com.baidu.tieba.util.at
    public void a() {
        c cVar;
        cVar = this.f1206a.f1202a;
        cVar.a().setVisibility(0);
    }

    @Override // com.baidu.tieba.util.at
    public void b() {
        c cVar;
        cVar = this.f1206a.f1202a;
        cVar.a().setVisibility(8);
    }
}
