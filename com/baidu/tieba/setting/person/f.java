package com.baidu.tieba.setting.person;

import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        aVar.dismiss();
        fVar = this.ccF.ccw;
        if (fVar.vR().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.ccF.cck;
            if (bool.booleanValue()) {
                fVar3 = this.ccF.ccw;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.vR());
            } else {
                fVar2 = this.ccF.ccw;
                intent.putExtra("data", fVar2.vR());
            }
            this.ccF.setResult(-1, intent);
        }
        this.ccF.finish();
    }
}
