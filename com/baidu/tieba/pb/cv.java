package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ com.baidu.tieba.a.al b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(SubPbActivity subPbActivity, com.baidu.tieba.a.al alVar) {
        this.a = subPbActivity;
        this.b = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c(this.b.e().b());
    }
}
