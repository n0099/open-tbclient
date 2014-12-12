package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonListActivity personListActivity) {
        this.bGG = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGG.aat();
    }
}
