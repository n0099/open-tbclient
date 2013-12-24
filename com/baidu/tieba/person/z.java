package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        aaVar = this.a.b;
        oVar = this.a.a;
        aaVar.a(oVar.a());
        oVar2 = this.a.a;
        oVar2.a((Boolean) true);
    }
}
