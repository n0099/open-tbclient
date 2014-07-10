package com.baidu.tieba.pb.main;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ bc a;
    private final /* synthetic */ com.baidu.tieba.data.ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar, com.baidu.tieba.data.ah ahVar) {
        this.a = bcVar;
        this.b = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String f = this.b.f();
        if (!com.baidu.tbadk.core.util.bm.c(f)) {
            com.baidu.tbadk.i.a().b(this.b.d(), System.currentTimeMillis());
            com.baidu.tbadk.core.util.bq a = com.baidu.tbadk.core.util.bq.a();
            context = this.a.b;
            a.a(context, new String[]{f});
        }
    }
}
