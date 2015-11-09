package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cry.crp.ajg().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cry.crd.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cry.crp.ajg());
            } else {
                intent.putExtra("data", this.cry.crp.ajg());
            }
            this.cry.setResult(-1, intent);
        }
        this.cry.finish();
    }
}
