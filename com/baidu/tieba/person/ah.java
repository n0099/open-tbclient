package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCA;
    private final /* synthetic */ String bCB;
    private final /* synthetic */ String bCC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bCA = personChangeActivity;
        this.bCB = str;
        this.bCC = str2;
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
            this.bCA.mSex = 1;
            textView3 = this.bCA.bCj;
            textView3.setText(this.bCB);
        } else if (i == 1) {
            this.bCA.mSex = 2;
            textView = this.bCA.bCj;
            textView.setText(this.bCC);
        }
        this.bCA.ZV();
        i2 = this.bCA.mSex;
        auVar = this.bCA.bCr;
        if (i2 != auVar.TW().getSex()) {
            textView2 = this.bCA.bCf;
            textView2.setEnabled(true);
        }
        dialog = this.bCA.bCx;
        com.baidu.adp.lib.g.j.b(dialog, this.bCA);
    }
}
