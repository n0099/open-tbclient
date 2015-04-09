package com.baidu.tieba.setting.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonChangeActivity personChangeActivity) {
        this.ccU = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.c.f fVar;
        int i;
        boolean z;
        com.baidu.tbadk.coreExtra.c.f fVar2;
        com.baidu.tbadk.coreExtra.c.f fVar3;
        Boolean bool;
        com.baidu.tbadk.coreExtra.c.f fVar4;
        com.baidu.tbadk.coreExtra.c.f fVar5;
        com.baidu.tbadk.core.dialog.a aVar;
        fVar = this.ccU.ccL;
        int sex = fVar.vX().getSex();
        i = this.ccU.mSex;
        if (sex != i) {
            this.ccU.bPo = true;
        }
        z = this.ccU.bPo;
        if (!z) {
            fVar2 = this.ccU.ccL;
            if (fVar2 != null) {
                fVar3 = this.ccU.ccL;
                if (fVar3.vX().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.ccU.ccz;
                    if (bool.booleanValue()) {
                        fVar5 = this.ccU.ccL;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.vX());
                    } else {
                        fVar4 = this.ccU.ccL;
                        intent.putExtra("data", fVar4.vX());
                    }
                    this.ccU.setResult(-1, intent);
                }
            }
            this.ccU.finish();
            return;
        }
        aVar = this.ccU.ccQ;
        aVar.re();
    }
}
