package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity dwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PersonChangeActivity personChangeActivity) {
        this.dwD = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.dwD.dwu.aBP().getSex();
        i = this.dwD.mSex;
        if (sex != i) {
            this.dwD.duV = true;
        }
        z = this.dwD.duV;
        if (!z) {
            if (this.dwD.dwu != null && this.dwD.dwu.aBP().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.dwD.dwg.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.dwD.dwu.aBP());
                } else {
                    intent.putExtra("data", this.dwD.dwu.aBP());
                }
                this.dwD.aBO();
                this.dwD.setResult(-1, intent);
            }
            this.dwD.finish();
            return;
        }
        aVar = this.dwD.dwz;
        aVar.rU();
    }
}
