package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements DialogInterface.OnClickListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        p pVar;
        p pVar2;
        if (i == 0) {
            pVar2 = this.a.c;
            pVar2.a(11);
            return;
        }
        pVar = this.a.c;
        pVar.a(12);
    }
}
