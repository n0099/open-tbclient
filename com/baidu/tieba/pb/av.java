package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.f1461a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r2.equals(r3.i()) != false) goto L12;
     */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bc bcVar;
        boolean b;
        com.baidu.tieba.model.av avVar;
        bn bnVar;
        com.baidu.tieba.model.av avVar2;
        com.baidu.tieba.model.av avVar3;
        com.baidu.tieba.model.bc bcVar2;
        boolean z = true;
        if (this.f1461a.f1437a != null) {
            if (i == 0) {
                this.f1461a.f1437a.d(this.f1461a);
                this.f1461a.f1437a = null;
            } else if (i == 1) {
                if (this.f1461a.f1437a.d() != null) {
                    String d = this.f1461a.f1437a.d();
                    bcVar2 = this.f1461a.j;
                }
                z = false;
                bcVar = this.f1461a.j;
                MarkData b2 = bcVar.b(this.f1461a.f1437a);
                if (b2 != null) {
                    b = this.f1461a.b(11009);
                    if (b) {
                        avVar = this.f1461a.k;
                        avVar.a(b2);
                        bnVar = this.f1461a.p;
                        bnVar.m();
                        if (!z) {
                            avVar3 = this.f1461a.k;
                            avVar3.c();
                            return;
                        }
                        avVar2 = this.f1461a.k;
                        avVar2.d();
                    }
                }
            }
        }
    }
}
