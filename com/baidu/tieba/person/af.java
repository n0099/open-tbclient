package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cYF.cYw.atN().getSex();
        i = this.cYF.mSex;
        if (sex != i) {
            this.cYF.cWY = true;
        }
        z = this.cYF.cWY;
        if (!z) {
            if (this.cYF.cYw != null && this.cYF.cYw.atN().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cYF.cYi.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cYF.cYw.atN());
                } else {
                    intent.putExtra("data", this.cYF.cYw.atN());
                }
                this.cYF.atM();
                this.cYF.setResult(-1, intent);
            }
            this.cYF.finish();
            return;
        }
        aVar = this.cYF.cYB;
        aVar.uj();
    }
}
