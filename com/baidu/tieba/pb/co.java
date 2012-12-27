package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ com.baidu.tieba.a.am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(SubPbActivity subPbActivity, com.baidu.tieba.a.am amVar) {
        this.a = subPbActivity;
        this.b = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c(this.b.d().b());
    }
}
