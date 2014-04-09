package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
/* loaded from: classes.dex */
final class aw implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tieba.model.au auVar;
        Boolean bool;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        Dialog dialog2;
        dialog = this.a.B;
        if (dialog != null) {
            dialog2 = this.a.B;
            dialog2.dismiss();
        }
        auVar = this.a.u;
        if (auVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.a.b;
            if (bool.booleanValue()) {
                auVar3 = this.a.u;
                intent.putExtra("person_change_data", auVar3.a());
            } else {
                auVar2 = this.a.u;
                intent.putExtra("data", auVar2.a());
            }
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
