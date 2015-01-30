package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHL;
    private final /* synthetic */ String bHM;
    private final /* synthetic */ String bHN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bHL = personChangeActivity;
        this.bHM = str;
        this.bHN = str2;
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
            this.bHL.mSex = 1;
            textView3 = this.bHL.bHv;
            textView3.setText(this.bHM);
        } else if (i == 1) {
            this.bHL.mSex = 2;
            textView = this.bHL.bHv;
            textView.setText(this.bHN);
        }
        this.bHL.aaR();
        i2 = this.bHL.mSex;
        fVar = this.bHL.bHC;
        if (i2 != fVar.sB().getSex()) {
            textView2 = this.bHL.bfI;
            textView2.setEnabled(true);
        }
        dialog = this.bHL.bHI;
        com.baidu.adp.lib.g.k.b(dialog, this.bHL.getPageContext());
    }
}
