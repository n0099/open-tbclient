package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    final /* synthetic */ PersonChangeActivity cko;
    private final /* synthetic */ String ckp;
    private final /* synthetic */ String ckq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cko = personChangeActivity;
        this.ckp = str;
        this.ckq = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TextView textView;
        int i2;
        View view2;
        TextView textView2;
        TextView textView3;
        cVar.dismiss();
        if (i == 0) {
            this.cko.mSex = 1;
            textView3 = this.cko.cjY;
            textView3.setText(this.ckp);
        } else if (i == 1) {
            this.cko.mSex = 2;
            textView = this.cko.cjY;
            textView.setText(this.ckq);
        }
        this.cko.agz();
        i2 = this.cko.mSex;
        if (i2 != this.cko.ckf.xY().getSex()) {
            view2 = this.cko.cjU;
            view2.setEnabled(true);
            textView2 = this.cko.byj;
            com.baidu.tbadk.core.util.al.b(textView2, i.c.cp_link_tip_a, 1);
        }
    }
}
