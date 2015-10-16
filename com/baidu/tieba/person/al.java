package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    final /* synthetic */ PersonChangeActivity cqc;
    private final /* synthetic */ String cqd;
    private final /* synthetic */ String cqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cqc = personChangeActivity;
        this.cqd = str;
        this.cqe = str2;
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
            this.cqc.mSex = 1;
            textView4 = this.cqc.cpM;
            textView4.setText(this.cqd);
        } else if (i == 1) {
            this.cqc.mSex = 2;
            textView = this.cqc.cpM;
            textView.setText(this.cqe);
        }
        this.cqc.aiy();
        i2 = this.cqc.mSex;
        if (i2 != this.cqc.cpT.aiE().getSex()) {
            view2 = this.cqc.cpI;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.cqc.bBw;
                com.baidu.tbadk.core.util.an.b(textView3, i.c.navi_op_text, 1);
                return;
            }
            textView2 = this.cqc.bBw;
            com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_link_tip_a, 1);
        }
    }
}
