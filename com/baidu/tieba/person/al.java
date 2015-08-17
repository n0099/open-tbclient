package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    final /* synthetic */ PersonChangeActivity cjt;
    private final /* synthetic */ String cju;
    private final /* synthetic */ String cjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.cjt = personChangeActivity;
        this.cju = str;
        this.cjv = str2;
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
            this.cjt.mSex = 1;
            textView3 = this.cjt.cje;
            textView3.setText(this.cju);
        } else if (i == 1) {
            this.cjt.mSex = 2;
            textView = this.cjt.cje;
            textView.setText(this.cjv);
        }
        this.cjt.agj();
        i2 = this.cjt.mSex;
        if (i2 != this.cjt.cjl.xR().getSex()) {
            view2 = this.cjt.cja;
            view2.setEnabled(true);
            textView2 = this.cjt.bxC;
            com.baidu.tbadk.core.util.al.b(textView2, i.c.cp_link_tip_a, 1);
        }
    }
}
