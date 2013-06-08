package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        y yVar;
        com.baidu.tieba.c.f fVar;
        com.baidu.tieba.c.f fVar2;
        yVar = this.a.d;
        fVar = this.a.c;
        yVar.a(fVar.a());
        fVar2 = this.a.c;
        fVar2.f();
    }
}
