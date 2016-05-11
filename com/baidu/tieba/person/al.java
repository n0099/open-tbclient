package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    final /* synthetic */ PersonChangeActivity dwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity) {
        this.dwD = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.dwD.dwu.aBP().getPhotoChanged()) {
            Intent intent = new Intent();
            if (this.dwD.dwg.booleanValue()) {
                intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.dwD.dwu.aBP());
            } else {
                intent.putExtra("data", this.dwD.dwu.aBP());
            }
            this.dwD.setResult(-1, intent);
            this.dwD.aBO();
        }
        this.dwD.finish();
    }
}
