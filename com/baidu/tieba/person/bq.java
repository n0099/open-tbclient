package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PersonListActivity csj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.csj = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.csj.ajj();
    }
}
