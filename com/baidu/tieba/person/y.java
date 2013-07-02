package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        z zVar;
        com.baidu.tieba.model.f fVar;
        com.baidu.tieba.model.f fVar2;
        zVar = this.a.b;
        fVar = this.a.a;
        zVar.a(fVar.a());
        fVar2 = this.a.a;
        fVar2.f();
    }
}
