package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r2.equals(r3.l()) != false) goto L12;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.c.ax axVar;
        boolean c;
        com.baidu.tieba.c.ak akVar;
        bk bkVar;
        com.baidu.tieba.c.ak akVar2;
        com.baidu.tieba.c.ak akVar3;
        com.baidu.tieba.c.ax axVar2;
        boolean z = true;
        if (this.a.c != null) {
            if (i == 0) {
                this.a.c.e(this.a);
                this.a.c = null;
            } else if (i == 1) {
                if (this.a.c.d() != null) {
                    String d = this.a.c.d();
                    axVar2 = this.a.i;
                }
                z = false;
                axVar = this.a.i;
                com.baidu.tieba.a.af b = axVar.b(this.a.c);
                if (b != null) {
                    c = this.a.c(1100009);
                    if (c) {
                        akVar = this.a.j;
                        akVar.a(b);
                        bkVar = this.a.o;
                        bkVar.m();
                        if (!z) {
                            akVar3 = this.a.j;
                            akVar3.f();
                            return;
                        }
                        akVar2 = this.a.j;
                        akVar2.g();
                    }
                }
            }
        }
    }
}
