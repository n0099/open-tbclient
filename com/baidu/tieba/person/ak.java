package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.cYF.cYw.atN().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.cYF.cYi.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cYF.cYw.atN());
            } else {
                intent.putExtra("data", this.cYF.cYw.atN());
            }
            this.cYF.setResult(-1, intent);
            this.cYF.atM();
        }
        this.cYF.finish();
    }
}
