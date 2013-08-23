package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.model.aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.f1509a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.aw
    public void a(boolean z, boolean z2, String str) {
        bo boVar;
        com.baidu.tieba.model.au auVar;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        bo boVar2;
        com.baidu.tieba.model.bb bbVar3;
        boVar = this.f1509a.q;
        boVar.q();
        if (z) {
            auVar = this.f1509a.l;
            auVar.a(z2);
            bbVar = this.f1509a.k;
            bbVar.c(z2);
            bbVar2 = this.f1509a.k;
            if (!bbVar2.s()) {
                boVar2 = this.f1509a.q;
                bbVar3 = this.f1509a.k;
                boVar2.a(bbVar3.k());
            } else {
                this.f1509a.p();
            }
            if (z2) {
                this.f1509a.a(this.f1509a.getString(R.string.add_mark));
                return;
            } else {
                this.f1509a.a(this.f1509a.getString(R.string.remove_mark));
                return;
            }
        }
        this.f1509a.a(str);
    }
}
