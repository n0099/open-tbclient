package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    final /* synthetic */ PersonChangeActivity cpR;
    private final /* synthetic */ String cpS;
    private final /* synthetic */ String cpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cpR = personChangeActivity;
        this.cpS = str;
        this.cpT = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TextView textView;
        int i2;
        View view2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        cVar.dismiss();
        if (i == 0) {
            this.cpR.mSex = 1;
            textView4 = this.cpR.cpB;
            textView4.setText(this.cpS);
        } else if (i == 1) {
            this.cpR.mSex = 2;
            textView = this.cpR.cpB;
            textView.setText(this.cpT);
        }
        this.cpR.aiy();
        i2 = this.cpR.mSex;
        if (i2 != this.cpR.cpI.aiE().getSex()) {
            view2 = this.cpR.cpx;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.cpR.bBl;
                com.baidu.tbadk.core.util.am.b(textView3, i.c.navi_op_text, 1);
                return;
            }
            textView2 = this.cpR.bBl;
            com.baidu.tbadk.core.util.am.b(textView2, i.c.cp_link_tip_a, 1);
        }
    }
}
