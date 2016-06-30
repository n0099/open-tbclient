package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity) {
        this.eeV = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.eeV.eeM.aKK().getSex();
        i = this.eeV.mSex;
        if (sex != i) {
            this.eeV.edn = true;
        }
        z = this.eeV.edn;
        if (!z) {
            if (this.eeV.eeM != null && this.eeV.eeM.aKK().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.eeV.eey.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.eeV.eeM.aKK());
                } else {
                    intent.putExtra("data", this.eeV.eeM.aKK());
                }
                this.eeV.aKJ();
                this.eeV.setResult(-1, intent);
            }
            this.eeV.finish();
            return;
        }
        aVar = this.eeV.eeR;
        aVar.rT();
    }
}
