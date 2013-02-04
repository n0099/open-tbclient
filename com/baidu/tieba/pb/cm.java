package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ com.baidu.tieba.a.am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(SubPbActivity subPbActivity, com.baidu.tieba.a.am amVar) {
        this.a = subPbActivity;
        this.b = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(0, this.b.a());
    }
}
