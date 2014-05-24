package com.baidu.tieba.pb.main;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ com.baidu.tieba.data.ae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar, com.baidu.tieba.data.ae aeVar) {
        this.a = azVar;
        this.b = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String f = this.b.f();
        if (!com.baidu.tbadk.core.util.be.c(f)) {
            com.baidu.tbadk.f.a().b(this.b.d(), System.currentTimeMillis());
            com.baidu.tbadk.core.util.bi a = com.baidu.tbadk.core.util.bi.a();
            context = this.a.b;
            a.a(context, new String[]{f});
        }
    }
}
