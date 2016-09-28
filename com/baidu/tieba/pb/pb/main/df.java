package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class df implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bRX;
    final /* synthetic */ de erd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, String str) {
        this.erd = deVar;
        this.bRX = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        dd ddVar;
        dd ddVar2;
        dd ddVar3;
        dd ddVar4;
        ddVar = this.erd.erc;
        TextView textView = new TextView(ddVar.aRd.getPageContext().getPageActivity());
        textView.setText(this.bRX);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.av.j((View) textView, r.d.cp_cont_i);
        ddVar2 = this.erd.erc;
        textView.setTextSize(0, ddVar2.aRd.getResources().getDimensionPixelSize(r.e.fontsize28));
        ddVar3 = this.erd.erc;
        textView.setWidth(ddVar3.aRd.getResources().getDimensionPixelSize(r.e.ds266));
        ddVar4 = this.erd.erc;
        textView.setHeight(ddVar4.aRd.getResources().getDimensionPixelSize(r.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, r.f.bg_tip_blue_left);
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
