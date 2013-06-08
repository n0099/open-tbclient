package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.c.am {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.am
    public void a(boolean z, boolean z2, String str) {
        bk bkVar;
        com.baidu.tieba.c.ak akVar;
        com.baidu.tieba.c.ax axVar;
        com.baidu.tieba.c.ax axVar2;
        bk bkVar2;
        com.baidu.tieba.c.ax axVar3;
        bkVar = this.a.o;
        bkVar.q();
        if (z) {
            akVar = this.a.j;
            akVar.a(z2);
            axVar = this.a.i;
            axVar.c(z2);
            axVar2 = this.a.i;
            if (!axVar2.w()) {
                bkVar2 = this.a.o;
                axVar3 = this.a.i;
                bkVar2.a(axVar3.m());
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
