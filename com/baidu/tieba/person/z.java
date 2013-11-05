package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditMarkActivity f2260a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(EditMarkActivity editMarkActivity) {
        this.f2260a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        aaVar = this.f2260a.b;
        oVar = this.f2260a.f2158a;
        aaVar.a(oVar.a());
        oVar2 = this.f2260a.f2158a;
        oVar2.a((Boolean) true);
    }
}
