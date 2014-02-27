package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ad adVar;
        com.baidu.tieba.model.g gVar;
        com.baidu.tieba.model.g gVar2;
        adVar = this.a.b;
        gVar = this.a.a;
        adVar.a(gVar.a());
        gVar2 = this.a.a;
        gVar2.a((Boolean) true);
    }
}
