package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.cpR = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cpR.aiz();
    }
}
