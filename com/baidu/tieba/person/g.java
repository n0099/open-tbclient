package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity bBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditMarkActivity editMarkActivity) {
        this.bBk = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        h hVar;
        com.baidu.tieba.model.j jVar;
        com.baidu.tieba.model.j jVar2;
        hVar = this.bBk.bBh;
        jVar = this.bBk.bBg;
        hVar.gU(jVar.getOffset());
        jVar2 = this.bBk.bBg;
        jVar2.g(true);
    }
}
