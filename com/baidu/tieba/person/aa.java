package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.au auVar;
        int i;
        boolean z;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        Boolean bool;
        com.baidu.tieba.model.au auVar4;
        com.baidu.tieba.model.au auVar5;
        Dialog dialog;
        auVar = this.bCA.bCr;
        int sex = auVar.TW().getSex();
        i = this.bCA.mSex;
        if (sex != i) {
            this.bCA.JV = true;
        }
        z = this.bCA.JV;
        if (!z) {
            auVar2 = this.bCA.bCr;
            if (auVar2 != null) {
                auVar3 = this.bCA.bCr;
                if (auVar3.TW().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bCA.bCe;
                    if (bool.booleanValue()) {
                        auVar5 = this.bCA.bCr;
                        intent.putExtra("person_change_data", auVar5.TW());
                    } else {
                        auVar4 = this.bCA.bCr;
                        intent.putExtra("data", auVar4.TW());
                    }
                    this.bCA.setResult(-1, intent);
                }
            }
            this.bCA.finish();
            return;
        }
        dialog = this.bCA.bCw;
        com.baidu.adp.lib.g.j.a(dialog, this.bCA);
    }
}
