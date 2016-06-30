package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class ak implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bFK;
    final /* synthetic */ aj fbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, String str) {
        this.fbU = ajVar;
        this.bFK = str;
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
        abVar = this.fbU.fbT;
        mainTabActivity = abVar.fbI;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(this.bFK);
        textView.setGravity(17);
        av.j((View) textView, u.d.cp_cont_i);
        abVar2 = this.fbU.fbT;
        mainTabActivity2 = abVar2.fbI;
        textView.setTextSize(0, mainTabActivity2.getResources().getDimensionPixelSize(u.e.fontsize28));
        abVar3 = this.fbU.fbT;
        mainTabActivity3 = abVar3.fbI;
        textView.setWidth(mainTabActivity3.getResources().getDimensionPixelSize(u.e.ds300));
        abVar4 = this.fbU.fbT;
        mainTabActivity4 = abVar4.fbI;
        textView.setHeight(mainTabActivity4.getResources().getDimensionPixelSize(u.e.ds76));
        av.k(textView, u.f.pic_sign_tip);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cV() {
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
