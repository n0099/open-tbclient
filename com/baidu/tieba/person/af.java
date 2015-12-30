package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.cPi = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cPi.cOZ.aoU().getSex();
        i = this.cPi.mSex;
        if (sex != i) {
            this.cPi.cNE = true;
        }
        z = this.cPi.cNE;
        if (!z) {
            if (this.cPi.cOZ != null && this.cPi.cOZ.aoU().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cPi.cON.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cPi.cOZ.aoU());
                } else {
                    intent.putExtra("data", this.cPi.cOZ.aoU());
                }
                this.cPi.sendUpdateMessage();
                this.cPi.setResult(-1, intent);
            }
            this.cPi.finish();
            return;
        }
        aVar = this.cPi.cPe;
        aVar.tf();
    }
}
