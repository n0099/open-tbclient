package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.cjt = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cjt.agk();
    }
}
