package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String dkV;
    final /* synthetic */ an exh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String str) {
        this.exh = anVar;
        this.dkV = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ab abVar;
        MainTabActivity mainTabActivity;
        ab abVar2;
        MainTabActivity mainTabActivity2;
        ab abVar3;
        MainTabActivity mainTabActivity3;
        ab abVar4;
        MainTabActivity mainTabActivity4;
        abVar = this.exh.exg;
        mainTabActivity = abVar.ewR;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(this.dkV);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.at.j((View) textView, t.d.cp_cont_i);
        abVar2 = this.exh.exg;
        mainTabActivity2 = abVar2.ewR;
        textView.setTextSize(0, mainTabActivity2.getResources().getDimensionPixelSize(t.e.fontsize28));
        abVar3 = this.exh.exg;
        mainTabActivity3 = abVar3.ewR;
        textView.setWidth(mainTabActivity3.getResources().getDimensionPixelSize(t.e.ds300));
        abVar4 = this.exh.exg;
        mainTabActivity4 = abVar4.ewR;
        textView.setHeight(mainTabActivity4.getResources().getDimensionPixelSize(t.e.ds76));
        com.baidu.tbadk.core.util.at.k(textView, t.f.pic_sign_tip);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cT() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
