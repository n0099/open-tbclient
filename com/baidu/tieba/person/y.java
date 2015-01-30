package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PersonChangeActivity personChangeActivity) {
        this.bHL = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        Dialog dialog2;
        dialog = this.bHL.bHH;
        if (dialog != null) {
            dialog2 = this.bHL.bHH;
            com.baidu.adp.lib.g.k.b(dialog2, this.bHL.getPageContext());
        }
        fVar = this.bHL.bHC;
        if (fVar.sB().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bHL.bHr;
            if (bool.booleanValue()) {
                fVar3 = this.bHL.bHC;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.sB());
            } else {
                fVar2 = this.bHL.bHC;
                intent.putExtra("data", fVar2.sB());
            }
            this.bHL.setResult(-1, intent);
        }
        this.bHL.finish();
    }
}
