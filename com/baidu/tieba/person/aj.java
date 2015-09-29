package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ PersonChangeActivity cpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.cpR = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cpR.cpI.aiE().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cpR.cpw.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cpR.cpI.aiE());
            } else {
                intent.putExtra("data", this.cpR.cpI.aiE());
            }
            this.cpR.setResult(-1, intent);
        }
        this.cpR.finish();
    }
}
