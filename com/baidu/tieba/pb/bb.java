package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.model.ao {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.ao
    public void a(boolean z, boolean z2, String str) {
        bk bkVar;
        com.baidu.tieba.model.am amVar;
        com.baidu.tieba.model.ax axVar;
        com.baidu.tieba.model.ax axVar2;
        bk bkVar2;
        com.baidu.tieba.model.ax axVar3;
        bkVar = this.a.p;
        bkVar.p();
        if (z) {
            amVar = this.a.k;
            amVar.a(z2);
            axVar = this.a.j;
            axVar.c(z2);
            axVar2 = this.a.j;
            if (!axVar2.r()) {
                bkVar2 = this.a.p;
                axVar3 = this.a.j;
                bkVar2.a(axVar3.j());
            } else {
                this.a.q();
            }
            if (z2) {
                this.a.a(this.a.getString(R.string.add_mark));
                return;
            } else {
                this.a.a(this.a.getString(R.string.remove_mark));
                return;
            }
        }
        this.a.a(str);
    }
}
