package com.baidu.tieba.kn.ladders;
/* loaded from: classes.dex */
class m implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnLaddersFragment f1193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(KnLaddersFragment knLaddersFragment) {
        this.f1193a = knLaddersFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        boolean z2;
        this.f1193a.f = false;
        android.support.v4.app.n g = this.f1193a.g();
        KnLaddersFragment knLaddersFragment = this.f1193a;
        z2 = this.f1193a.f;
        KnLaddersModel.fetch(g, knLaddersFragment, z2);
    }
}
