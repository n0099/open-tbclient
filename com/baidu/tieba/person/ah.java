package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCm;
    private final /* synthetic */ String bCn;
    private final /* synthetic */ String bCo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bCm = personChangeActivity;
        this.bCn = str;
        this.bCo = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TextView textView;
        int i2;
        com.baidu.tieba.model.au auVar;
        Dialog dialog;
        TextView textView2;
        TextView textView3;
        if (i == 0) {
            this.bCm.mSex = 1;
            textView3 = this.bCm.bBV;
            textView3.setText(this.bCn);
        } else if (i == 1) {
            this.bCm.mSex = 2;
            textView = this.bCm.bBV;
            textView.setText(this.bCo);
        }
        this.bCm.ZT();
        i2 = this.bCm.mSex;
        auVar = this.bCm.bCd;
        if (i2 != auVar.TT().getSex()) {
            textView2 = this.bCm.bBR;
            textView2.setEnabled(true);
        }
        dialog = this.bCm.bCj;
        com.baidu.adp.lib.g.j.b(dialog, this.bCm);
    }
}
