package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        Dialog dialog2;
        dialog = this.bHK.bHG;
        if (dialog != null) {
            dialog2 = this.bHK.bHG;
            com.baidu.adp.lib.g.k.b(dialog2, this.bHK.getPageContext());
        }
        fVar = this.bHK.bHB;
        if (fVar.sv().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bHK.bHq;
            if (bool.booleanValue()) {
                fVar3 = this.bHK.bHB;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.sv());
            } else {
                fVar2 = this.bHK.bHB;
                intent.putExtra("data", fVar2.sv());
            }
            this.bHK.setResult(-1, intent);
        }
        this.bHK.finish();
    }
}
