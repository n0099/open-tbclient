package com.baidu.tieba.kn.ladders;
/* loaded from: classes.dex */
class m implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnLaddersFragment f1752a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(KnLaddersFragment knLaddersFragment) {
        this.f1752a = knLaddersFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        boolean z2;
        this.f1752a.f = false;
        android.support.v4.app.n i = this.f1752a.i();
        KnLaddersFragment knLaddersFragment = this.f1752a;
        z2 = this.f1752a.f;
        KnLaddersModel.fetch(i, knLaddersFragment, z2);
    }
}
