package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.model.ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.f1220a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.ao
    public void a(boolean z, boolean z2, String str) {
        bk bkVar;
        com.baidu.tieba.model.am amVar;
        com.baidu.tieba.model.ax axVar;
        com.baidu.tieba.model.ax axVar2;
        bk bkVar2;
        com.baidu.tieba.model.ax axVar3;
        bkVar = this.f1220a.p;
        bkVar.p();
        if (z) {
            amVar = this.f1220a.k;
            amVar.a(z2);
            axVar = this.f1220a.j;
            axVar.c(z2);
            axVar2 = this.f1220a.j;
            if (!axVar2.r()) {
                bkVar2 = this.f1220a.p;
                axVar3 = this.f1220a.j;
                bkVar2.a(axVar3.j());
            } else {
                this.f1220a.q();
            }
            if (z2) {
                this.f1220a.a(this.f1220a.getString(R.string.add_mark));
                return;
            } else {
                this.f1220a.a(this.f1220a.getString(R.string.remove_mark));
                return;
            }
        }
        this.f1220a.a(str);
    }
}
