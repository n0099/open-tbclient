package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity bAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditMarkActivity editMarkActivity) {
        this.bAW = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        h hVar;
        com.baidu.tieba.model.j jVar;
        com.baidu.tieba.model.j jVar2;
        hVar = this.bAW.bAT;
        jVar = this.bAW.bAS;
        hVar.gU(jVar.getOffset());
        jVar2 = this.bAW.bAS;
        jVar2.g(true);
    }
}
