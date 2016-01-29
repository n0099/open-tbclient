package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cYF.atH();
    }
}
