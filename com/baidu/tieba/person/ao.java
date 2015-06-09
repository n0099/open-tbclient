package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        aVar.dismiss();
        fVar = this.bSO.bSF;
        if (fVar.wI().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bSO.bSt;
            if (bool.booleanValue()) {
                fVar3 = this.bSO.bSF;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.wI());
            } else {
                fVar2 = this.bSO.bSF;
                intent.putExtra("data", fVar2.wI());
            }
            this.bSO.setResult(-1, intent);
        }
        this.bSO.finish();
    }
}
