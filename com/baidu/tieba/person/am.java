package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements c.b {
    final /* synthetic */ PersonChangeActivity dth;
    private final /* synthetic */ String dti;
    private final /* synthetic */ String dtj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.dth = personChangeActivity;
        this.dti = str;
        this.dtj = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TextView textView;
        int i2;
        View view2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        cVar.dismiss();
        if (i == 0) {
            this.dth.mSex = 1;
            textView4 = this.dth.dsQ;
            textView4.setText(this.dti);
        } else if (i == 1) {
            this.dth.mSex = 2;
            textView = this.dth.dsQ;
            textView.setText(this.dtj);
        }
        this.dth.aBm();
        i2 = this.dth.mSex;
        if (i2 != this.dth.dsY.aBt().getSex()) {
            view2 = this.dth.dsM;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.dth.cjl;
                com.baidu.tbadk.core.util.at.b(textView3, t.d.navi_op_text, 1);
                return;
            }
            textView2 = this.dth.cjl;
            com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_link_tip_a, 1);
        }
    }
}
