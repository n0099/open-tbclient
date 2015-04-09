package com.baidu.tieba.setting.person;

import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonChangeActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonChangeActivity personChangeActivity) {
        this.ccU = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.coreExtra.c.f fVar;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        aVar.dismiss();
        fVar = this.ccU.ccL;
        if (fVar.vX().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.ccU.ccz;
            if (bool.booleanValue()) {
                fVar3 = this.ccU.ccL;
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar3.vX());
            } else {
                fVar2 = this.ccU.ccL;
                intent.putExtra("data", fVar2.vX());
            }
            this.ccU.setResult(-1, intent);
        }
        this.ccU.finish();
    }
}
