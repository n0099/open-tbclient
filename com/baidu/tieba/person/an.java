package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements c.b {
    final /* synthetic */ PersonChangeActivity dwD;
    private final /* synthetic */ String dwE;
    private final /* synthetic */ String dwF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.dwD = personChangeActivity;
        this.dwE = str;
        this.dwF = str2;
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
            this.dwD.mSex = 1;
            textView4 = this.dwD.dwm;
            textView4.setText(this.dwE);
        } else if (i == 1) {
            this.dwD.mSex = 2;
            textView = this.dwD.dwm;
            textView.setText(this.dwF);
        }
        this.dwD.aBI();
        i2 = this.dwD.mSex;
        if (i2 != this.dwD.dwu.aBP().getSex()) {
            this.dwD.bKq = true;
            if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                textView3 = this.dwD.ckh;
                com.baidu.tbadk.core.util.at.c(textView3, t.d.navi_op_text, 1);
                return;
            }
            textView2 = this.dwD.ckh;
            com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_link_tip_a, 1);
        }
    }
}
