package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.c.f fVar;
        int i;
        boolean z;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar4;
        com.baidu.tbadk.coreExtra.c.f fVar5;
        Dialog dialog;
        fVar = this.bGa.bFR;
        int sex = fVar.sl().getSex();
        i = this.bGa.mSex;
        if (sex != i) {
            this.bGa.Pg = true;
        }
        z = this.bGa.Pg;
        if (!z) {
            fVar2 = this.bGa.bFR;
            if (fVar2 != null) {
                fVar3 = this.bGa.bFR;
                if (fVar3.sl().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bGa.bFG;
                    if (bool.booleanValue()) {
                        fVar5 = this.bGa.bFR;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.sl());
                    } else {
                        fVar4 = this.bGa.bFR;
                        intent.putExtra("data", fVar4.sl());
                    }
                    this.bGa.setResult(-1, intent);
                }
            }
            this.bGa.finish();
            return;
        }
        dialog = this.bGa.bFW;
        com.baidu.adp.lib.g.k.a(dialog, this.bGa.getPageContext());
    }
}
