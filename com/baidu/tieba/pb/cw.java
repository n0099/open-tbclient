package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ com.baidu.tieba.a.an b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(SubPbActivity subPbActivity, com.baidu.tieba.a.an anVar) {
        this.a = subPbActivity;
        this.b = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c(this.b.e().b());
    }
}
