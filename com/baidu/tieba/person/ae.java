package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.cjt = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cjt.cjl.xR().getSex();
        i = this.cjt.mSex;
        if (sex != i) {
            this.cjt.chV = true;
        }
        z = this.cjt.chV;
        if (!z) {
            if (this.cjt.cjl != null && this.cjt.cjl.xR().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cjt.ciZ.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cjt.cjl.xR());
                } else {
                    intent.putExtra("data", this.cjt.cjl.xR());
                }
                this.cjt.setResult(-1, intent);
            }
            this.cjt.finish();
            return;
        }
        aVar = this.cjt.cjp;
        aVar.sP();
    }
}
