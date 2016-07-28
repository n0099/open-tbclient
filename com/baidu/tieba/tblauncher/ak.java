package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class ak implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bGY;
    final /* synthetic */ aj foY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, String str) {
        this.foY = ajVar;
        this.bGY = str;
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
        abVar = this.foY.foX;
        mainTabActivity = abVar.foM;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(this.bGY);
        textView.setGravity(17);
        av.j((View) textView, u.d.cp_cont_i);
        abVar2 = this.foY.foX;
        mainTabActivity2 = abVar2.foM;
        textView.setTextSize(0, mainTabActivity2.getResources().getDimensionPixelSize(u.e.fontsize28));
        abVar3 = this.foY.foX;
        mainTabActivity3 = abVar3.foM;
        textView.setWidth(mainTabActivity3.getResources().getDimensionPixelSize(u.e.ds300));
        abVar4 = this.foY.foX;
        mainTabActivity4 = abVar4.foM;
        textView.setHeight(mainTabActivity4.getResources().getDimensionPixelSize(u.e.ds76));
        av.k(textView, u.f.pic_sign_tip);
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
