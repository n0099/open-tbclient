package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ PersonChangeActivity cko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.cko = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cko.ckf.xY().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cko.cjT.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cko.ckf.xY());
            } else {
                intent.putExtra("data", this.cko.ckf.xY());
            }
            this.cko.setResult(-1, intent);
        }
        this.cko.finish();
    }
}
