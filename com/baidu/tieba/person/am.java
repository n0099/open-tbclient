package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements c.b {
    final /* synthetic */ PersonChangeActivity cYF;
    private final /* synthetic */ String cYG;
    private final /* synthetic */ String cYH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cYF = personChangeActivity;
        this.cYG = str;
        this.cYH = str2;
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
            this.cYF.mSex = 1;
            textView4 = this.cYF.cYo;
            textView4.setText(this.cYG);
        } else if (i == 1) {
            this.cYF.mSex = 2;
            textView = this.cYF.cYo;
            textView.setText(this.cYH);
        }
        this.cYF.atG();
        i2 = this.cYF.mSex;
        if (i2 != this.cYF.cYw.atN().getSex()) {
            view2 = this.cYF.cYk;
            view2.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView3 = this.cYF.bYI;
                com.baidu.tbadk.core.util.ar.b(textView3, t.d.navi_op_text, 1);
                return;
            }
            textView2 = this.cYF.bYI;
            com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_link_tip_a, 1);
        }
    }
}
