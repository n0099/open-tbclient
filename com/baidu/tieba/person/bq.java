package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PersonListActivity cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.cqN = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cqN.aiD();
    }
}
