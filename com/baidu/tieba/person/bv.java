package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
/* loaded from: classes.dex */
final class bv implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tieba.model.bo boVar;
        Boolean bool;
        com.baidu.tieba.model.bo boVar2;
        com.baidu.tieba.model.bo boVar3;
        Dialog dialog2;
        dialog = this.a.D;
        if (dialog != null) {
            dialog2 = this.a.D;
            dialog2.dismiss();
        }
        boVar = this.a.w;
        if (boVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.a.b;
            if (bool.booleanValue()) {
                boVar3 = this.a.w;
                intent.putExtra("person_change_data", boVar3.a());
            } else {
                boVar2 = this.a.w;
                intent.putExtra("data", boVar2.a());
            }
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
