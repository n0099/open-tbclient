package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.cko = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cko.ckf.xY().getSex();
        i = this.cko.mSex;
        if (sex != i) {
            this.cko.ciQ = true;
        }
        z = this.cko.ciQ;
        if (!z) {
            if (this.cko.ckf != null && this.cko.ckf.xY().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cko.cjT.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cko.ckf.xY());
                } else {
                    intent.putExtra("data", this.cko.ckf.xY());
                }
                this.cko.setResult(-1, intent);
            }
            this.cko.finish();
            return;
        }
        aVar = this.cko.ckk;
        aVar.sU();
    }
}
