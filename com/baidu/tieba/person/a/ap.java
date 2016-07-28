package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ ao erp;
    private final /* synthetic */ com.baidu.tieba.person.data.s erq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, com.baidu.tieba.person.data.s sVar) {
        this.erp = aoVar;
        this.erq = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.erp.oH(this.erq.aNT());
    }
}
