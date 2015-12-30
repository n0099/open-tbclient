package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity) {
        this.cPi = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cPi.kK(800);
    }
}
