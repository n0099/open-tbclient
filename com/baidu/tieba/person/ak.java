package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.dth.dsY.aBt().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.dth.dsK.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.dth.dsY.aBt());
            } else {
                intent.putExtra("data", this.dth.dsY.aBt());
            }
            this.dth.setResult(-1, intent);
            this.dth.aBs();
        }
        this.dth.finish();
    }
}
