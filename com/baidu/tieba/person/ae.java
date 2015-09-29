package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.cpR = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cpR.cpI.aiE().getSex();
        i = this.cpR.mSex;
        if (sex != i) {
            this.cpR.f128com = true;
        }
        z = this.cpR.f128com;
        if (!z) {
            if (this.cpR.cpI != null && this.cpR.cpI.aiE().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cpR.cpw.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cpR.cpI.aiE());
                } else {
                    intent.putExtra("data", this.cpR.cpI.aiE());
                }
                this.cpR.setResult(-1, intent);
            }
            this.cpR.finish();
            return;
        }
        aVar = this.cpR.cpN;
        aVar.sR();
    }
}
