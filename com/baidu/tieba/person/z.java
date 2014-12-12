package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        Dialog dialog2;
        dialog = this.bGa.bFW;
        if (dialog != null) {
            dialog2 = this.bGa.bFW;
            com.baidu.adp.lib.g.k.b(dialog2, this.bGa.getPageContext());
        }
        fVar = this.bGa.bFR;
        if (fVar.sl().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bGa.bFG;
            if (bool.booleanValue()) {
                fVar3 = this.bGa.bFR;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.sl());
            } else {
                fVar2 = this.bGa.bFR;
                intent.putExtra("data", fVar2.sl());
            }
            this.bGa.setResult(-1, intent);
        }
        this.bGa.finish();
    }
}
