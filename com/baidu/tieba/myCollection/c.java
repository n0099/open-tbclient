package com.baidu.tieba.myCollection;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity byr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditMarkActivity editMarkActivity) {
        this.byr = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        g gVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        gVar = this.byr.byo;
        aVar = this.byr.byn;
        gVar.gW(aVar.getOffset());
        aVar2 = this.byr.byn;
        aVar2.c((Boolean) true);
    }
}
