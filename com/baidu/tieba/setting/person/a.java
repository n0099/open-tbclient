package com.baidu.tieba.setting.person;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
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
        fVar = this.ccF.ccw;
        int sex = fVar.vR().getSex();
        i = this.ccF.mSex;
        if (sex != i) {
            this.ccF.bOY = true;
        }
        z = this.ccF.bOY;
        if (!z) {
            fVar2 = this.ccF.ccw;
            if (fVar2 != null) {
                fVar3 = this.ccF.ccw;
                if (fVar3.vR().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.ccF.cck;
                    if (bool.booleanValue()) {
                        fVar5 = this.ccF.ccw;
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, fVar5.vR());
                    } else {
                        fVar4 = this.ccF.ccw;
                        intent.putExtra("data", fVar4.vR());
                    }
                    this.ccF.setResult(-1, intent);
                }
            }
            this.ccF.finish();
            return;
        }
        aVar = this.ccF.ccB;
        aVar.re();
    }
}
