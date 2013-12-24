package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.b.c();
    }
}
