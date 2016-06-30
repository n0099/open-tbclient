package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ PersonChangeActivity eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.eeV = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.eeV.eeM.aKK().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.eeV.eey.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.eeV.eeM.aKK());
            } else {
                intent.putExtra("data", this.eeV.eeM.aKK());
            }
            this.eeV.setResult(-1, intent);
            this.eeV.aKJ();
        }
        this.eeV.finish();
    }
}
