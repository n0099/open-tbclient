package com.baidu.tieba.kn.ladders;
/* loaded from: classes.dex */
class m implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnLaddersFragment f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(KnLaddersFragment knLaddersFragment) {
        this.f1257a = knLaddersFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        boolean z2;
        this.f1257a.f = false;
        android.support.v4.app.n h = this.f1257a.h();
        KnLaddersFragment knLaddersFragment = this.f1257a;
        z2 = this.f1257a.f;
        KnLaddersModel.fetch(h, knLaddersFragment, z2);
    }
}
