package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai dbh;
    private final /* synthetic */ com.baidu.tieba.person.data.q dbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, com.baidu.tieba.person.data.q qVar) {
        this.dbh = aiVar;
        this.dbi = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dbh.la(this.dbi.auu());
    }
}
