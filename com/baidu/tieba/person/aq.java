package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2315a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity) {
        this.f2315a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        alertDialog = this.f2315a.c;
        alertDialog.show();
    }
}
