package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements c.b {
    final /* synthetic */ PersonChangeActivity cPi;
    private final /* synthetic */ String cPj;
    private final /* synthetic */ String cPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cPi = personChangeActivity;
        this.cPj = str;
        this.cPk = str2;
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
            this.cPi.mSex = 1;
            textView4 = this.cPi.cOS;
            textView4.setText(this.cPj);
        } else if (i == 1) {
            this.cPi.mSex = 2;
            textView = this.cPi.cOS;
            textView.setText(this.cPk);
        }
        this.cPi.aoO();
        i2 = this.cPi.mSex;
        if (i2 != this.cPi.cOZ.aoU().getSex()) {
            view2 = this.cPi.cOO;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.cPi.bUD;
                com.baidu.tbadk.core.util.as.b(textView3, n.d.navi_op_text, 1);
                return;
            }
            textView2 = this.cPi.bUD;
            com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_link_tip_a, 1);
        }
    }
}
