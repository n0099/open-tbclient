package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnClickListener {
    final /* synthetic */ bc a;
    private final /* synthetic */ com.baidu.tieba.data.ae b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar, com.baidu.tieba.data.ae aeVar, int i) {
        this.a = bcVar;
        this.b = aeVar;
        this.c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        az azVar;
        azVar = this.a.a;
        azVar.a(this.b, this.c);
    }
}
