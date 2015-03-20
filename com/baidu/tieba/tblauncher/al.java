package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar) {
        this.crN = aiVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        MainTabActivity mainTabActivity;
        mainTabActivity = this.crN.crH;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(com.baidu.tieba.y.first_enter_addresslist_tip);
        textView.setBackgroundResource(com.baidu.tieba.u.tips_home_help);
        textView.setPadding(com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds10), com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds26), com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds10), com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds10));
        textView.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_g));
        textView.setTextSize(0, com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds28));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gT() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gU() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds40);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return -com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.t.ds6);
    }
}
