package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class al implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bSe;
    final /* synthetic */ ak fwS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, String str) {
        this.fwS = akVar;
        this.bSe = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ac acVar;
        MainTabActivity mainTabActivity;
        ac acVar2;
        MainTabActivity mainTabActivity2;
        ac acVar3;
        MainTabActivity mainTabActivity3;
        ac acVar4;
        MainTabActivity mainTabActivity4;
        acVar = this.fwS.fwR;
        mainTabActivity = acVar.fwG;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(this.bSe);
        textView.setGravity(17);
        av.j((View) textView, t.d.cp_cont_i);
        acVar2 = this.fwS.fwR;
        mainTabActivity2 = acVar2.fwG;
        textView.setTextSize(0, mainTabActivity2.getResources().getDimensionPixelSize(t.e.fontsize28));
        acVar3 = this.fwS.fwR;
        mainTabActivity3 = acVar3.fwG;
        textView.setWidth(mainTabActivity3.getResources().getDimensionPixelSize(t.e.ds300));
        acVar4 = this.fwS.fwR;
        mainTabActivity4 = acVar4.fwG;
        textView.setHeight(mainTabActivity4.getResources().getDimensionPixelSize(t.e.ds76));
        av.k(textView, t.f.pic_sign_tip);
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
