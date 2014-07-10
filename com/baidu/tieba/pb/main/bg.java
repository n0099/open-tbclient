package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bg implements DialogInterface.OnClickListener {
    final /* synthetic */ bf a;
    private final /* synthetic */ com.baidu.tieba.data.ah b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, com.baidu.tieba.data.ah ahVar, int i) {
        this.a = bfVar;
        this.b = ahVar;
        this.c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bc bcVar;
        bcVar = this.a.a;
        bcVar.a(this.b, this.c);
    }
}
