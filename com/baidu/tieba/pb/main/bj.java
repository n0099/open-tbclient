package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class bj implements DialogInterface.OnClickListener {
    final /* synthetic */ bi a;
    private final /* synthetic */ com.baidu.tieba.data.ah b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar, com.baidu.tieba.data.ah ahVar, String str) {
        this.a = biVar;
        this.b = ahVar;
        this.c = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bc bcVar;
        Context context;
        com.baidu.tbadk.i.a().b(this.b.d(), System.currentTimeMillis());
        com.baidu.tbadk.core.util.bq a = com.baidu.tbadk.core.util.bq.a();
        bcVar = this.a.a;
        context = bcVar.b;
        a.a(context, new String[]{this.c});
    }
}
