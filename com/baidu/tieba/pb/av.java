package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r2.equals(r3.i()) != false) goto L12;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.ax axVar;
        boolean b;
        com.baidu.tieba.model.am amVar;
        bk bkVar;
        com.baidu.tieba.model.am amVar2;
        com.baidu.tieba.model.am amVar3;
        com.baidu.tieba.model.ax axVar2;
        boolean z = true;
        if (this.a.a != null) {
            if (i == 0) {
                this.a.a.e(this.a);
                this.a.a = null;
            } else if (i == 1) {
                if (this.a.a.d() != null) {
                    String d = this.a.a.d();
                    axVar2 = this.a.j;
                }
                z = false;
                axVar = this.a.j;
                MarkData b2 = axVar.b(this.a.a);
                if (b2 != null) {
                    b = this.a.b(1100009);
                    if (b) {
                        amVar = this.a.k;
                        amVar.a(b2);
                        bkVar = this.a.p;
                        bkVar.m();
                        if (!z) {
                            amVar3 = this.a.k;
                            amVar3.c();
                            return;
                        }
                        amVar2 = this.a.k;
                        amVar2.d();
                    }
                }
            }
        }
    }
}
