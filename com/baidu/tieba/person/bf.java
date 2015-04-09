package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonListActivity personListActivity) {
        this.bQP = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bQP.adr();
    }
}
