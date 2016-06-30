package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements c.b {
    final /* synthetic */ PersonChangeActivity eeV;
    private final /* synthetic */ String eeW;
    private final /* synthetic */ String eeX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.eeV = personChangeActivity;
        this.eeW = str;
        this.eeX = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TextView textView;
        int i2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        cVar.dismiss();
        if (i == 0) {
            this.eeV.mSex = 1;
            textView4 = this.eeV.eeE;
            textView4.setText(this.eeW);
        } else if (i == 1) {
            this.eeV.mSex = 2;
            textView = this.eeV.eeE;
            textView.setText(this.eeX);
        }
        this.eeV.aKD();
        i2 = this.eeV.mSex;
        if (i2 != this.eeV.eeM.aKK().getSex()) {
            this.eeV.civ = true;
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView3 = this.eeV.cPx;
                com.baidu.tbadk.core.util.av.c(textView3, u.d.navi_op_text, 1);
                return;
            }
            textView2 = this.eeV.cPx;
            com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_link_tip_a, 1);
        }
    }
}
