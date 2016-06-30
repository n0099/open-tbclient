package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class de implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ String bFK;
    final /* synthetic */ dd dQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar, String str) {
        this.dQL = ddVar;
        this.bFK = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        dcVar = this.dQL.dQK;
        TextView textView = new TextView(dcVar.bkc.getPageContext().getPageActivity());
        textView.setText(this.bFK);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.av.j((View) textView, u.d.cp_cont_i);
        dcVar2 = this.dQL.dQK;
        textView.setTextSize(0, dcVar2.bkc.getResources().getDimensionPixelSize(u.e.fontsize28));
        dcVar3 = this.dQL.dQK;
        textView.setWidth(dcVar3.bkc.getResources().getDimensionPixelSize(u.e.ds266));
        dcVar4 = this.dQL.dQK;
        textView.setHeight(dcVar4.bkc.getResources().getDimensionPixelSize(u.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, u.f.bg_tip_blue_left);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cV() {
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
