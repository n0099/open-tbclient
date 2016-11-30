package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class an implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String ewW;
    final /* synthetic */ am fGX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, String str) {
        this.fGX = amVar;
        this.ewW = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ae aeVar;
        MainTabActivity mainTabActivity;
        ae aeVar2;
        MainTabActivity mainTabActivity2;
        ae aeVar3;
        MainTabActivity mainTabActivity3;
        ae aeVar4;
        MainTabActivity mainTabActivity4;
        aeVar = this.fGX.fGW;
        mainTabActivity = aeVar.fGL;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(this.ewW);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.at.j((View) textView, r.d.cp_cont_i);
        aeVar2 = this.fGX.fGW;
        mainTabActivity2 = aeVar2.fGL;
        textView.setTextSize(0, mainTabActivity2.getResources().getDimensionPixelSize(r.e.fontsize28));
        aeVar3 = this.fGX.fGW;
        mainTabActivity3 = aeVar3.fGL;
        textView.setWidth(mainTabActivity3.getResources().getDimensionPixelSize(r.e.ds300));
        aeVar4 = this.fGX.fGW;
        mainTabActivity4 = aeVar4.fGL;
        textView.setHeight(mainTabActivity4.getResources().getDimensionPixelSize(r.e.ds76));
        com.baidu.tbadk.core.util.at.k(textView, r.f.pic_sign_tip);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
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
