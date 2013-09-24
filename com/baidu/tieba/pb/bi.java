package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bi implements com.baidu.tieba.model.ay {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(NewPbActivity newPbActivity) {
        this.f1555a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.ay
    public void a(boolean z, boolean z2, String str) {
        br brVar;
        com.baidu.tieba.model.aw awVar;
        com.baidu.tieba.model.bd bdVar;
        com.baidu.tieba.model.bd bdVar2;
        br brVar2;
        com.baidu.tieba.model.bd bdVar3;
        brVar = this.f1555a.t;
        brVar.A();
        if (z) {
            awVar = this.f1555a.o;
            awVar.a(z2);
            bdVar = this.f1555a.n;
            bdVar.c(z2);
            bdVar2 = this.f1555a.n;
            if (!bdVar2.s()) {
                brVar2 = this.f1555a.t;
                bdVar3 = this.f1555a.n;
                brVar2.a(bdVar3.k());
            } else {
                this.f1555a.t();
            }
            if (z2) {
                this.f1555a.a(this.f1555a.getString(R.string.add_mark));
                return;
            } else {
                this.f1555a.a(this.f1555a.getString(R.string.remove_mark));
                return;
            }
        }
        this.f1555a.a(str);
    }
}
