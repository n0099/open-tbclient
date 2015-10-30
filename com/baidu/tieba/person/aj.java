package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ PersonChangeActivity cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.cqc = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cqc.cpT.aiA().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cqc.cpH.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cqc.cpT.aiA());
            } else {
                intent.putExtra("data", this.cqc.cpT.aiA());
            }
            this.cqc.setResult(-1, intent);
        }
        this.cqc.finish();
    }
}
