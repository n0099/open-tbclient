package com.baidu.tieba.myCollection;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditMarkActivity editMarkActivity) {
        this.bwI = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        g gVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        gVar = this.bwI.bwF;
        aVar = this.bwI.bwE;
        gVar.gN(aVar.getOffset());
        aVar2 = this.bwI.bwE;
        aVar2.c((Boolean) true);
    }
}
