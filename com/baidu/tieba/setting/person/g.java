package com.baidu.tieba.setting.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonChangeActivity ccU;
    private final /* synthetic */ String ccV;
    private final /* synthetic */ String ccW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.ccU = personChangeActivity;
        this.ccV = str;
        this.ccW = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        TextView textView;
        int i2;
        com.baidu.tbadk.coreExtra.c.f fVar;
        View view2;
        TextView textView2;
        TextView textView3;
        eVar.dismiss();
        if (i == 0) {
            this.ccU.mSex = 1;
            textView3 = this.ccU.ccE;
            textView3.setText(this.ccV);
        } else if (i == 1) {
            this.ccU.mSex = 2;
            textView = this.ccU.ccE;
            textView.setText(this.ccW);
        }
        this.ccU.ail();
        i2 = this.ccU.mSex;
        fVar = this.ccU.ccL;
        if (i2 != fVar.vX().getSex()) {
            view2 = this.ccU.ccA;
            view2.setEnabled(true);
            textView2 = this.ccU.bhl;
            ba.b(textView2, s.cp_link_tip_a, 1);
        }
    }
}
