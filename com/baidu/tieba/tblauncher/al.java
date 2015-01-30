package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements b {
    final /* synthetic */ ai cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar) {
        this.cdw = aiVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        MainTabActivity mainTabActivity;
        mainTabActivity = this.cdw.cdr;
        TextView textView = new TextView(mainTabActivity.getPageContext().getPageActivity());
        textView.setText(com.baidu.tieba.z.first_enter_personinfo_tip);
        textView.setBackgroundResource(com.baidu.tieba.v.tips_home_help);
        textView.setPadding(com.baidu.adp.lib.util.l.d(TbadkCoreApplication.m255getInst(), com.baidu.tieba.u.ds32), com.baidu.adp.lib.util.l.d(TbadkCoreApplication.m255getInst(), com.baidu.tieba.u.ds48), com.baidu.adp.lib.util.l.d(TbadkCoreApplication.m255getInst(), com.baidu.tieba.u.ds32), com.baidu.adp.lib.util.l.d(TbadkCoreApplication.m255getInst(), com.baidu.tieba.u.ds32));
        textView.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_g));
        textView.setTextSize(0, com.baidu.adp.lib.util.l.d(TbadkCoreApplication.m255getInst(), com.baidu.tieba.u.ds28));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dv() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dw() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return -com.baidu.adp.lib.util.l.d(TbadkCoreApplication.m255getInst(), com.baidu.tieba.u.ds10);
    }
}
