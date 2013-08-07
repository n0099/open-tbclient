package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.f1457a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bn bnVar;
        bn bnVar2;
        NewPbActivity newPbActivity = this.f1457a;
        bnVar = this.f1457a.p;
        newPbActivity.q = bnVar.T();
        bnVar2 = this.f1457a.p;
        bnVar2.a();
        if (i == 0) {
            com.baidu.tieba.write.ba.a(this.f1457a);
        } else if (i == 1) {
            com.baidu.tieba.write.ba.b(this.f1457a);
        }
    }
}
