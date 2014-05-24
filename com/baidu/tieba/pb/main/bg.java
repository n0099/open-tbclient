package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class bg implements DialogInterface.OnClickListener {
    final /* synthetic */ bf a;
    private final /* synthetic */ com.baidu.tieba.data.ae b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, com.baidu.tieba.data.ae aeVar, String str) {
        this.a = bfVar;
        this.b = aeVar;
        this.c = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        az azVar;
        Context context;
        com.baidu.tbadk.f.a().b(this.b.d(), System.currentTimeMillis());
        com.baidu.tbadk.core.util.bi a = com.baidu.tbadk.core.util.bi.a();
        azVar = this.a.a;
        context = azVar.b;
        a.a(context, new String[]{this.c});
    }
}
