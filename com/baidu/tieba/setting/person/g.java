package com.baidu.tieba.setting.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonChangeActivity ccF;
    private final /* synthetic */ String ccG;
    private final /* synthetic */ String ccH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.ccF = personChangeActivity;
        this.ccG = str;
        this.ccH = str2;
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
            this.ccF.mSex = 1;
            textView3 = this.ccF.ccp;
            textView3.setText(this.ccG);
        } else if (i == 1) {
            this.ccF.mSex = 2;
            textView = this.ccF.ccp;
            textView.setText(this.ccH);
        }
        this.ccF.ahW();
        i2 = this.ccF.mSex;
        fVar = this.ccF.ccw;
        if (i2 != fVar.vR().getSex()) {
            view2 = this.ccF.ccl;
            view2.setEnabled(true);
            textView2 = this.ccF.bgV;
            ba.b(textView2, s.cp_link_tip_a, 1);
        }
    }
}
