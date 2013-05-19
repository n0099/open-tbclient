package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.c.aj {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.aj
    public void a(boolean z, boolean z2, String str) {
        bl blVar;
        com.baidu.tieba.c.ah ahVar;
        com.baidu.tieba.c.au auVar;
        com.baidu.tieba.c.au auVar2;
        bl blVar2;
        com.baidu.tieba.c.au auVar3;
        blVar = this.a.o;
        blVar.q();
        if (z) {
            ahVar = this.a.j;
            ahVar.a(z2);
            auVar = this.a.i;
            auVar.c(z2);
            auVar2 = this.a.i;
            if (!auVar2.v()) {
                blVar2 = this.a.o;
                auVar3 = this.a.i;
                blVar2.a(auVar3.l());
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
