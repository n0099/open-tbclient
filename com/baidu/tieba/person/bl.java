package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tieba.model.at atVar;
        Boolean bool;
        com.baidu.tieba.model.at atVar2;
        com.baidu.tieba.model.at atVar3;
        Dialog dialog2;
        dialog = this.a.B;
        if (dialog != null) {
            dialog2 = this.a.B;
            dialog2.dismiss();
        }
        atVar = this.a.u;
        if (atVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.a.b;
            if (bool.booleanValue()) {
                atVar3 = this.a.u;
                intent.putExtra("person_change_data", atVar3.a());
            } else {
                atVar2 = this.a.u;
                intent.putExtra("data", atVar2.a());
            }
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
