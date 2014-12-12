package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGa.aal();
    }
}
