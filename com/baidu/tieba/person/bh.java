package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bIr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonListActivity personListActivity) {
        this.bIr = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bIr.aaT();
    }
}
