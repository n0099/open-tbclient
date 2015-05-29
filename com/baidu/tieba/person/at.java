package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSN.aes();
    }
}
