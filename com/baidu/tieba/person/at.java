package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity dwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PersonChangeActivity personChangeActivity) {
        this.dwD = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dwD.aBK();
    }
}
