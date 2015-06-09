package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
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
        fVar = this.bSO.bSF;
        int sex = fVar.wI().getSex();
        i = this.bSO.mSex;
        if (sex != i) {
            this.bSO.bRs = true;
        }
        z = this.bSO.bRs;
        if (!z) {
            fVar2 = this.bSO.bSF;
            if (fVar2 != null) {
                fVar3 = this.bSO.bSF;
                if (fVar3.wI().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bSO.bSt;
                    if (bool.booleanValue()) {
                        fVar5 = this.bSO.bSF;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.wI());
                    } else {
                        fVar4 = this.bSO.bSF;
                        intent.putExtra("data", fVar4.wI());
                    }
                    this.bSO.setResult(-1, intent);
                }
            }
            this.bSO.finish();
            return;
        }
        aVar = this.bSO.bSK;
        aVar.rL();
    }
}
