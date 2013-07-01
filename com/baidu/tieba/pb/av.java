package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.f1213a = newPbActivity;
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
        if (this.f1213a.f1189a != null) {
            if (i == 0) {
                this.f1213a.f1189a.e(this.f1213a);
                this.f1213a.f1189a = null;
            } else if (i == 1) {
                if (this.f1213a.f1189a.d() != null) {
                    String d = this.f1213a.f1189a.d();
                    axVar2 = this.f1213a.j;
                }
                z = false;
                axVar = this.f1213a.j;
                MarkData b2 = axVar.b(this.f1213a.f1189a);
                if (b2 != null) {
                    b = this.f1213a.b(1100009);
                    if (b) {
                        amVar = this.f1213a.k;
                        amVar.a(b2);
                        bkVar = this.f1213a.p;
                        bkVar.m();
                        if (!z) {
                            amVar3 = this.f1213a.k;
                            amVar3.c();
                            return;
                        }
                        amVar2 = this.f1213a.k;
                        amVar2.d();
                    }
                }
            }
        }
    }
}
