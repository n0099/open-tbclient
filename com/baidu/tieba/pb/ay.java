package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.f1544a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r2.equals(r3.j()) != false) goto L12;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bd bdVar;
        boolean b;
        com.baidu.tieba.model.aw awVar;
        br brVar;
        com.baidu.tieba.model.aw awVar2;
        com.baidu.tieba.model.aw awVar3;
        com.baidu.tieba.model.bd bdVar2;
        boolean z = true;
        if (this.f1544a.f1516a != null) {
            if (i == 0) {
                this.f1544a.f1516a.d(this.f1544a);
                this.f1544a.f1516a = null;
            } else if (i == 1) {
                if (this.f1544a.f1516a.d() != null) {
                    String d = this.f1544a.f1516a.d();
                    bdVar2 = this.f1544a.n;
                }
                z = false;
                bdVar = this.f1544a.n;
                MarkData b2 = bdVar.b(this.f1544a.f1516a);
                if (b2 != null) {
                    b = this.f1544a.b(11009);
                    if (b) {
                        awVar = this.f1544a.o;
                        awVar.a(b2);
                        brVar = this.f1544a.t;
                        brVar.x();
                        if (!z) {
                            awVar3 = this.f1544a.o;
                            awVar3.c();
                            return;
                        }
                        awVar2 = this.f1544a.o;
                        awVar2.d();
                    }
                }
            }
        }
    }
}
