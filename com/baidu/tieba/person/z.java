package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditMarkActivity f2295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(EditMarkActivity editMarkActivity) {
        this.f2295a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        aaVar = this.f2295a.b;
        oVar = this.f2295a.f2200a;
        aaVar.a(oVar.a());
        oVar2 = this.f2295a.f2200a;
        oVar2.a((Boolean) true);
    }
}
