package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class df implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bGY;
    final /* synthetic */ de eda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, String str) {
        this.eda = deVar;
        this.bGY = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        dd ddVar;
        dd ddVar2;
        dd ddVar3;
        dd ddVar4;
        ddVar = this.eda.ecZ;
        TextView textView = new TextView(ddVar.bem.getPageContext().getPageActivity());
        textView.setText(this.bGY);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.av.j((View) textView, u.d.cp_cont_i);
        ddVar2 = this.eda.ecZ;
        textView.setTextSize(0, ddVar2.bem.getResources().getDimensionPixelSize(u.e.fontsize28));
        ddVar3 = this.eda.ecZ;
        textView.setWidth(ddVar3.bem.getResources().getDimensionPixelSize(u.e.ds266));
        ddVar4 = this.eda.ecZ;
        textView.setHeight(ddVar4.bem.getResources().getDimensionPixelSize(u.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, u.f.bg_tip_blue_left);
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
