package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGa.aao();
    }
}
