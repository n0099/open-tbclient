package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;
    private final /* synthetic */ String bGb;
    private final /* synthetic */ String bGc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bGa = personChangeActivity;
        this.bGb = str;
        this.bGc = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TextView textView;
        int i2;
        com.baidu.tbadk.coreExtra.c.f fVar;
        Dialog dialog;
        TextView textView2;
        TextView textView3;
        if (i == 0) {
            this.bGa.mSex = 1;
            textView3 = this.bGa.bFK;
            textView3.setText(this.bGb);
        } else if (i == 1) {
            this.bGa.mSex = 2;
            textView = this.bGa.bFK;
            textView.setText(this.bGc);
        }
        this.bGa.aam();
        i2 = this.bGa.mSex;
        fVar = this.bGa.bFR;
        if (i2 != fVar.sl().getSex()) {
            textView2 = this.bGa.ben;
            textView2.setEnabled(true);
        }
        dialog = this.bGa.bFX;
        com.baidu.adp.lib.g.k.b(dialog, this.bGa.getPageContext());
    }
}
