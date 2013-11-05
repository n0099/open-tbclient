package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewPbActivity newPbActivity) {
        this.f2067a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r2.equals(r3.j()) != false) goto L12;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bl blVar;
        boolean d;
        com.baidu.tieba.model.bf bfVar;
        bt btVar;
        com.baidu.tieba.model.bf bfVar2;
        com.baidu.tieba.model.bf bfVar3;
        com.baidu.tieba.model.bl blVar2;
        boolean z = true;
        if (this.f2067a.f2033a != null) {
            if (i == 0) {
                this.f2067a.f2033a.d(this.f2067a);
                this.f2067a.f2033a = null;
            } else if (i == 1) {
                if (this.f2067a.f2033a.d() != null) {
                    String d2 = this.f2067a.f2033a.d();
                    blVar2 = this.f2067a.o;
                }
                z = false;
                blVar = this.f2067a.o;
                MarkData b = blVar.b(this.f2067a.f2033a);
                if (b != null) {
                    d = this.f2067a.d(11009);
                    if (d) {
                        bfVar = this.f2067a.p;
                        bfVar.a(b);
                        btVar = this.f2067a.u;
                        btVar.x();
                        if (!z) {
                            bfVar3 = this.f2067a.p;
                            bfVar3.c();
                            return;
                        }
                        bfVar2 = this.f2067a.p;
                        bfVar2.d();
                    }
                }
            }
        }
    }
}
