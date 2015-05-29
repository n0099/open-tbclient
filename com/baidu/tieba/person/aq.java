package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonChangeActivity bSN;
    private final /* synthetic */ String bSO;
    private final /* synthetic */ String bSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bSN = personChangeActivity;
        this.bSO = str;
        this.bSP = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        TextView textView;
        int i2;
        com.baidu.tbadk.coreExtra.c.f fVar;
        View view2;
        TextView textView2;
        TextView textView3;
        eVar.dismiss();
        if (i == 0) {
            this.bSN.mSex = 1;
            textView3 = this.bSN.bSx;
            textView3.setText(this.bSO);
        } else if (i == 1) {
            this.bSN.mSex = 2;
            textView = this.bSN.bSx;
            textView.setText(this.bSP);
        }
        this.bSN.aer();
        i2 = this.bSN.mSex;
        fVar = this.bSN.bSE;
        if (i2 != fVar.wH().getSex()) {
            view2 = this.bSN.bSt;
            view2.setEnabled(true);
            textView2 = this.bSN.bjR;
            com.baidu.tbadk.core.util.ay.b(textView2, com.baidu.tieba.n.cp_link_tip_a, 1);
        }
    }
}
