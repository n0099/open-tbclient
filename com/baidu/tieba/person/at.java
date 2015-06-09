package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSO.aet();
    }
}
