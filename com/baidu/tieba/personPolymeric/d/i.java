package com.baidu.tieba.personPolymeric.d;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eNn;
    private final /* synthetic */ com.baidu.tieba.personPolymeric.c.g eNo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.personPolymeric.c.g gVar) {
        this.eNn = hVar;
        this.eNo = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eNn.b(this.eNo);
    }
}
