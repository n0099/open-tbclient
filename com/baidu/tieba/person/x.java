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
        com.baidu.tieba.c.c cVar;
        com.baidu.tieba.c.c cVar2;
        yVar = this.a.d;
        cVar = this.a.c;
        yVar.a(cVar.a());
        cVar2 = this.a.c;
        cVar2.f();
    }
}
