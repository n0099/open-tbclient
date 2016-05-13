package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity dwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity) {
        this.dwD = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dwD.aBM();
    }
}
