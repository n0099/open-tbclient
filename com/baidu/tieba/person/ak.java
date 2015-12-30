package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ PersonChangeActivity cPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.cPi = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cPi.cOZ.aoU().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cPi.cON.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cPi.cOZ.aoU());
            } else {
                intent.putExtra("data", this.cPi.cOZ.aoU());
            }
            this.cPi.setResult(-1, intent);
            this.cPi.sendUpdateMessage();
        }
        this.cPi.finish();
    }
}
