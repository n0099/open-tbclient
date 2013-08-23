package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.f1494a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bo boVar;
        bo boVar2;
        NewPbActivity newPbActivity = this.f1494a;
        boVar = this.f1494a.q;
        newPbActivity.r = boVar.U();
        boVar2 = this.f1494a.q;
        boVar2.b();
        if (i == 0) {
            com.baidu.tieba.write.ba.a(this.f1494a);
        } else if (i == 1) {
            com.baidu.tieba.write.ba.b(this.f1494a);
        }
    }
}
