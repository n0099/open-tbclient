package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1209a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.f1209a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bk bkVar;
        bk bkVar2;
        NewPbActivity newPbActivity = this.f1209a;
        bkVar = this.f1209a.p;
        newPbActivity.q = bkVar.T();
        bkVar2 = this.f1209a.p;
        bkVar2.a();
        if (i == 0) {
            com.baidu.tieba.write.bb.a(this.f1209a);
        } else if (i == 1) {
            com.baidu.tieba.write.bb.b(this.f1209a);
        }
    }
}
