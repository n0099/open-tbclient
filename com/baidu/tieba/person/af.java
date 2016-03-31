package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.dth.dsY.aBt().getSex();
        i = this.dth.mSex;
        if (sex != i) {
            this.dth.drA = true;
        }
        z = this.dth.drA;
        if (!z) {
            if (this.dth.dsY != null && this.dth.dsY.aBt().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.dth.dsK.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.dth.dsY.aBt());
                } else {
                    intent.putExtra("data", this.dth.dsY.aBt());
                }
                this.dth.aBs();
                this.dth.setResult(-1, intent);
            }
            this.dth.finish();
            return;
        }
        aVar = this.dth.dtd;
        aVar.up();
    }
}
