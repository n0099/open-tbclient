package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ PersonListActivity ckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.ckd = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ckd.agr();
    }
}
