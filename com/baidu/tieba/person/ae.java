package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.cqc = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cqc.cpT.aiE().getSex();
        i = this.cqc.mSex;
        if (sex != i) {
            this.cqc.cox = true;
        }
        z = this.cqc.cox;
        if (!z) {
            if (this.cqc.cpT != null && this.cqc.cpT.aiE().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cqc.cpH.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cqc.cpT.aiE());
                } else {
                    intent.putExtra("data", this.cqc.cpT.aiE());
                }
                this.cqc.setResult(-1, intent);
            }
            this.cqc.finish();
            return;
        }
        aVar = this.cqc.cpY;
        aVar.sR();
    }
}
