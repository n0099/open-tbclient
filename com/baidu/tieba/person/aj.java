package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
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
        com.baidu.tbadk.core.dialog.a aVar;
        fVar = this.bSN.bSE;
        int sex = fVar.wH().getSex();
        i = this.bSN.mSex;
        if (sex != i) {
            this.bSN.bRr = true;
        }
        z = this.bSN.bRr;
        if (!z) {
            fVar2 = this.bSN.bSE;
            if (fVar2 != null) {
                fVar3 = this.bSN.bSE;
                if (fVar3.wH().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bSN.bSs;
                    if (bool.booleanValue()) {
                        fVar5 = this.bSN.bSE;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.wH());
                    } else {
                        fVar4 = this.bSN.bSE;
                        intent.putExtra("data", fVar4.wH());
                    }
                    this.bSN.setResult(-1, intent);
                }
            }
            this.bSN.finish();
            return;
        }
        aVar = this.bSN.bSJ;
        aVar.rL();
    }
}
