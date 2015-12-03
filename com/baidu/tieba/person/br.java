package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ PersonListActivity cLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.cLD = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cLD.anM();
    }
}
