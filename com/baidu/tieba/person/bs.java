package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ PersonListActivity cZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PersonListActivity personListActivity) {
        this.cZq = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cZq.atQ();
    }
}
