package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHK;
    private final /* synthetic */ String bHL;
    private final /* synthetic */ String bHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bHK = personChangeActivity;
        this.bHL = str;
        this.bHM = str2;
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
            this.bHK.mSex = 1;
            textView3 = this.bHK.bHu;
            textView3.setText(this.bHL);
        } else if (i == 1) {
            this.bHK.mSex = 2;
            textView = this.bHK.bHu;
            textView.setText(this.bHM);
        }
        this.bHK.aaM();
        i2 = this.bHK.mSex;
        fVar = this.bHK.bHB;
        if (i2 != fVar.sv().getSex()) {
            textView2 = this.bHK.bfH;
            textView2.setEnabled(true);
        }
        dialog = this.bHK.bHH;
        com.baidu.adp.lib.g.k.b(dialog, this.bHK.getPageContext());
    }
}
