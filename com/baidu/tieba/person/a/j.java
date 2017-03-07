package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i eBE;
    private final /* synthetic */ com.baidu.tieba.person.data.c eBF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.person.data.c cVar) {
        this.eBE = iVar;
        this.eBF = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eBE.nQ(this.eBF.aQe());
    }
}
