package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1498a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.f1498a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r2.equals(r3.j()) != false) goto L12;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bb bbVar;
        boolean b;
        com.baidu.tieba.model.au auVar;
        bo boVar;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        com.baidu.tieba.model.bb bbVar2;
        boolean z = true;
        if (this.f1498a.f1474a != null) {
            if (i == 0) {
                this.f1498a.f1474a.d(this.f1498a);
                this.f1498a.f1474a = null;
            } else if (i == 1) {
                if (this.f1498a.f1474a.d() != null) {
                    String d = this.f1498a.f1474a.d();
                    bbVar2 = this.f1498a.k;
                }
                z = false;
                bbVar = this.f1498a.k;
                MarkData b2 = bbVar.b(this.f1498a.f1474a);
                if (b2 != null) {
                    b = this.f1498a.b(11009);
                    if (b) {
                        auVar = this.f1498a.l;
                        auVar.a(b2);
                        boVar = this.f1498a.q;
                        boVar.n();
                        if (!z) {
                            auVar3 = this.f1498a.l;
                            auVar3.c();
                            return;
                        }
                        auVar2 = this.f1498a.l;
                        auVar2.d();
                    }
                }
            }
        }
    }
}
