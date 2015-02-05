package com.baidu.tieba.myCollection;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnClickListener {
    final /* synthetic */ g byx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.byx = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        dialog = this.byx.byv;
        com.baidu.adp.lib.g.k.b(dialog, this.byx.byt.getPageContext());
    }
}
