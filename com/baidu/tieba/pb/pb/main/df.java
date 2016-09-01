package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class df implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bSe;
    final /* synthetic */ de epf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, String str) {
        this.epf = deVar;
        this.bSe = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        dd ddVar;
        dd ddVar2;
        dd ddVar3;
        dd ddVar4;
        ddVar = this.epf.epe;
        TextView textView = new TextView(ddVar.aPR.getPageContext().getPageActivity());
        textView.setText(this.bSe);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.av.j((View) textView, t.d.cp_cont_i);
        ddVar2 = this.epf.epe;
        textView.setTextSize(0, ddVar2.aPR.getResources().getDimensionPixelSize(t.e.fontsize28));
        ddVar3 = this.epf.epe;
        textView.setWidth(ddVar3.aPR.getResources().getDimensionPixelSize(t.e.ds266));
        ddVar4 = this.epf.epe;
        textView.setHeight(ddVar4.aPR.getResources().getDimensionPixelSize(t.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, t.f.bg_tip_blue_left);
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
