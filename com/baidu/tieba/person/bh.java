package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonListActivity personListActivity) {
        this.bIs = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bIs.aaY();
    }
}
