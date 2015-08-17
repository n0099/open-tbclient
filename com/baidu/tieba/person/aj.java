package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ PersonChangeActivity cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.cjt = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cjt.cjl.xR().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cjt.ciZ.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cjt.cjl.xR());
            } else {
                intent.putExtra("data", this.cjt.cjl.xR());
            }
            this.cjt.setResult(-1, intent);
        }
        this.cjt.finish();
    }
}
