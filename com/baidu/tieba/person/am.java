package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements c.b {
    final /* synthetic */ PersonChangeActivity cKS;
    private final /* synthetic */ String cKT;
    private final /* synthetic */ String cKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cKS = personChangeActivity;
        this.cKT = str;
        this.cKU = str2;
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
            this.cKS.mSex = 1;
            textView4 = this.cKS.cKC;
            textView4.setText(this.cKT);
        } else if (i == 1) {
            this.cKS.mSex = 2;
            textView = this.cKS.cKC;
            textView.setText(this.cKU);
        }
        this.cKS.anD();
        i2 = this.cKS.mSex;
        if (i2 != this.cKS.cKJ.anJ().getSex()) {
            view2 = this.cKS.cKy;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.cKS.bQX;
                com.baidu.tbadk.core.util.as.b(textView3, n.c.navi_op_text, 1);
                return;
            }
            textView2 = this.cKS.bQX;
            com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_link_tip_a, 1);
        }
    }
}
