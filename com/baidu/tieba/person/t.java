package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonChangeActivity personChangeActivity) {
        this.bHL = personChangeActivity;
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
        fVar = this.bHL.bHC;
        int sex = fVar.sB().getSex();
        i = this.bHL.mSex;
        if (sex != i) {
            this.bHL.PH = true;
        }
        z = this.bHL.PH;
        if (!z) {
            fVar2 = this.bHL.bHC;
            if (fVar2 != null) {
                fVar3 = this.bHL.bHC;
                if (fVar3.sB().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bHL.bHr;
                    if (bool.booleanValue()) {
                        fVar5 = this.bHL.bHC;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.sB());
                    } else {
                        fVar4 = this.bHL.bHC;
                        intent.putExtra("data", fVar4.sB());
                    }
                    this.bHL.setResult(-1, intent);
                }
            }
            this.bHL.finish();
            return;
        }
        dialog = this.bHL.bHH;
        com.baidu.adp.lib.g.k.a(dialog, this.bHL.getPageContext());
    }
}
