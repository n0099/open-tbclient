package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    private final /* synthetic */ String crA;
    final /* synthetic */ PersonChangeActivity cry;
    private final /* synthetic */ String crz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cry = personChangeActivity;
        this.crz = str;
        this.crA = str2;
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
            this.cry.mSex = 1;
            textView4 = this.cry.cri;
            textView4.setText(this.crz);
        } else if (i == 1) {
            this.cry.mSex = 2;
            textView = this.cry.cri;
            textView.setText(this.crA);
        }
        this.cry.aja();
        i2 = this.cry.mSex;
        if (i2 != this.cry.crp.ajg().getSex()) {
            view2 = this.cry.cre;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.cry.bBR;
                com.baidu.tbadk.core.util.an.b(textView3, i.c.navi_op_text, 1);
                return;
            }
            textView2 = this.cry.bBR;
            com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_link_tip_a, 1);
        }
    }
}
