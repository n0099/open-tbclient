package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
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
        fVar = this.bHK.bHB;
        int sex = fVar.sv().getSex();
        i = this.bHK.mSex;
        if (sex != i) {
            this.bHK.PE = true;
        }
        z = this.bHK.PE;
        if (!z) {
            fVar2 = this.bHK.bHB;
            if (fVar2 != null) {
                fVar3 = this.bHK.bHB;
                if (fVar3.sv().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bHK.bHq;
                    if (bool.booleanValue()) {
                        fVar5 = this.bHK.bHB;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.sv());
                    } else {
                        fVar4 = this.bHK.bHB;
                        intent.putExtra("data", fVar4.sv());
                    }
                    this.bHK.setResult(-1, intent);
                }
            }
            this.bHK.finish();
            return;
        }
        dialog = this.bHK.bHG;
        com.baidu.adp.lib.g.k.a(dialog, this.bHK.getPageContext());
    }
}
