package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonChangeActivity bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        aVar.dismiss();
        fVar = this.bSN.bSE;
        if (fVar.wH().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bSN.bSs;
            if (bool.booleanValue()) {
                fVar3 = this.bSN.bSE;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.wH());
            } else {
                fVar2 = this.bSN.bSE;
                intent.putExtra("data", fVar2.wH());
            }
            this.bSN.setResult(-1, intent);
        }
        this.bSN.finish();
    }
}
