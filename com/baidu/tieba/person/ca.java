package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        alertDialog = this.a.c;
        alertDialog.show();
    }
}
