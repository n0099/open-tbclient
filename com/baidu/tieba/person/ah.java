package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dth.mz(800);
    }
}
