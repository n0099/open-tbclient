package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cry.crp.ajg().getSex();
        i = this.cry.mSex;
        if (sex != i) {
            this.cry.cpT = true;
        }
        z = this.cry.cpT;
        if (!z) {
            if (this.cry.crp != null && this.cry.crp.ajg().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cry.crd.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cry.crp.ajg());
                } else {
                    intent.putExtra("data", this.cry.crp.ajg());
                }
                this.cry.setResult(-1, intent);
            }
            this.cry.finish();
            return;
        }
        aVar = this.cry.cru;
        aVar.sR();
    }
}
