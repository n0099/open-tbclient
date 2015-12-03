package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ PersonChangeActivity cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.cKS = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cKS.cKJ.anJ().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cKS.cKx.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cKS.cKJ.anJ());
            } else {
                intent.putExtra("data", this.cKS.cKJ.anJ());
            }
            this.cKS.setResult(-1, intent);
            this.cKS.sendUpdateMessage();
        }
        this.cKS.finish();
    }
}
