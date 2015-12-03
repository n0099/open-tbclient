package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.cKS = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        com.baidu.tbadk.core.dialog.a aVar;
        int sex = this.cKS.cKJ.anJ().getSex();
        i = this.cKS.mSex;
        if (sex != i) {
            this.cKS.cJo = true;
        }
        z = this.cKS.cJo;
        if (!z) {
            if (this.cKS.cKJ != null && this.cKS.cKJ.anJ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (this.cKS.cKx.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cKS.cKJ.anJ());
                } else {
                    intent.putExtra("data", this.cKS.cKJ.anJ());
                }
                this.cKS.sendUpdateMessage();
                this.cKS.setResult(-1, intent);
            }
            this.cKS.finish();
            return;
        }
        aVar = this.cKS.cKO;
        aVar.tv();
    }
}
