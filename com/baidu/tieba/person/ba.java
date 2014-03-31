package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.view.View;
/* loaded from: classes.dex */
final class ba implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlertDialog alertDialog;
        alertDialog = this.a.c;
        alertDialog.show();
    }
}
