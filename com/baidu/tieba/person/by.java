package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PersonListActivity personListActivity) {
        this.bTv = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTv.aeA();
    }
}
