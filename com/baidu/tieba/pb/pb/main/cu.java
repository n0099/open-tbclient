package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class cu implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ct dkU;
    private final /* synthetic */ String dkV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar, String str) {
        this.dkU = ctVar;
        this.dkV = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        cs csVar4;
        csVar = this.dkU.dkT;
        TextView textView = new TextView(csVar.bek.getPageContext().getPageActivity());
        textView.setText(this.dkV);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.at.j((View) textView, t.d.cp_cont_i);
        csVar2 = this.dkU.dkT;
        textView.setTextSize(0, csVar2.bek.getResources().getDimensionPixelSize(t.e.fontsize28));
        csVar3 = this.dkU.dkT;
        textView.setWidth(csVar3.bek.getResources().getDimensionPixelSize(t.e.ds266));
        csVar4 = this.dkU.dkT;
        textView.setHeight(csVar4.bek.getResources().getDimensionPixelSize(t.e.ds76));
        com.baidu.tbadk.core.util.at.k(textView, t.f.bg_tip_blue_left);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cT() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return -10;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
