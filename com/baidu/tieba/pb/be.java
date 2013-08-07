package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class be implements com.baidu.tieba.model.ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewPbActivity newPbActivity) {
        this.f1471a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.ax
    public void a(boolean z, boolean z2, String str) {
        bn bnVar;
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.bc bcVar;
        com.baidu.tieba.model.bc bcVar2;
        bn bnVar2;
        com.baidu.tieba.model.bc bcVar3;
        bnVar = this.f1471a.p;
        bnVar.p();
        if (z) {
            avVar = this.f1471a.k;
            avVar.a(z2);
            bcVar = this.f1471a.j;
            bcVar.c(z2);
            bcVar2 = this.f1471a.j;
            if (!bcVar2.r()) {
                bnVar2 = this.f1471a.p;
                bcVar3 = this.f1471a.j;
                bnVar2.a(bcVar3.j());
            } else {
                this.f1471a.o();
            }
            if (z2) {
                this.f1471a.a(this.f1471a.getString(R.string.add_mark));
                return;
            } else {
                this.f1471a.a(this.f1471a.getString(R.string.remove_mark));
                return;
            }
        }
        this.f1471a.a(str);
    }
}
