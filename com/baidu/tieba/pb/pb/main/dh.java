package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class dh implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ dg ewV;
    private final /* synthetic */ String ewW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dg dgVar, String str) {
        this.ewV = dgVar;
        this.ewW = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        dfVar = this.ewV.ewU;
        TextView textView = new TextView(dfVar.aTb.getPageContext().getPageActivity());
        textView.setText(this.ewW);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.at.j((View) textView, r.d.cp_cont_i);
        dfVar2 = this.ewV.ewU;
        textView.setTextSize(0, dfVar2.aTb.getResources().getDimensionPixelSize(r.e.fontsize28));
        dfVar3 = this.ewV.ewU;
        textView.setWidth(dfVar3.aTb.getResources().getDimensionPixelSize(r.e.ds266));
        dfVar4 = this.ewV.ewU;
        textView.setHeight(dfVar4.aTb.getResources().getDimensionPixelSize(r.e.ds76));
        com.baidu.tbadk.core.util.at.k(textView, r.f.bg_tip_blue_left);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
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
