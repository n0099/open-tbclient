package com.baidu.tieba.kn.pk;

import com.baidu.tieba.util.bn;
/* loaded from: classes.dex */
class a implements bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKEndActivity f1768a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PKEndActivity pKEndActivity) {
        this.f1768a = pKEndActivity;
    }

    @Override // com.baidu.tieba.util.bn
    public void a() {
        c cVar;
        cVar = this.f1768a.f1764a;
        cVar.a().setVisibility(0);
    }

    @Override // com.baidu.tieba.util.bn
    public void b() {
        c cVar;
        cVar = this.f1768a.f1764a;
        cVar.a().setVisibility(8);
    }
}
