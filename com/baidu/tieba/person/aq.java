package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonChangeActivity bSO;
    private final /* synthetic */ String bSP;
    private final /* synthetic */ String bSQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.bSO = personChangeActivity;
        this.bSP = str;
        this.bSQ = str2;
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
            this.bSO.mSex = 1;
            textView3 = this.bSO.bSy;
            textView3.setText(this.bSP);
        } else if (i == 1) {
            this.bSO.mSex = 2;
            textView = this.bSO.bSy;
            textView.setText(this.bSQ);
        }
        this.bSO.aes();
        i2 = this.bSO.mSex;
        fVar = this.bSO.bSF;
        if (i2 != fVar.wI().getSex()) {
            view2 = this.bSO.bSu;
            view2.setEnabled(true);
            textView2 = this.bSO.bjS;
            com.baidu.tbadk.core.util.ay.b(textView2, com.baidu.tieba.n.cp_link_tip_a, 1);
        }
    }
}
