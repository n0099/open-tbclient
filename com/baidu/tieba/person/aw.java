package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSO.aer();
    }
}
