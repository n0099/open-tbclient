package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class fz implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ fy dnj;
    private final /* synthetic */ String dnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(fy fyVar, String str) {
        this.dnj = fyVar;
        this.dnk = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        eu euVar;
        PbActivity pbActivity;
        eu euVar2;
        PbActivity pbActivity2;
        eu euVar3;
        PbActivity pbActivity3;
        eu euVar4;
        PbActivity pbActivity4;
        euVar = this.dnj.dnc;
        pbActivity = euVar.dfw;
        TextView textView = new TextView(pbActivity.getPageContext().getPageActivity());
        textView.setText(this.dnk);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.at.j((View) textView, t.d.cp_cont_i);
        euVar2 = this.dnj.dnc;
        pbActivity2 = euVar2.dfw;
        textView.setTextSize(0, pbActivity2.getResources().getDimensionPixelSize(t.e.fontsize28));
        euVar3 = this.dnj.dnc;
        pbActivity3 = euVar3.dfw;
        textView.setWidth(pbActivity3.getResources().getDimensionPixelSize(t.e.ds266));
        euVar4 = this.dnj.dnc;
        pbActivity4 = euVar4.dfw;
        textView.setHeight(pbActivity4.getResources().getDimensionPixelSize(t.e.ds76));
        com.baidu.tbadk.core.util.at.k(textView, t.f.bg_tip_blue_left);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gG() {
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
