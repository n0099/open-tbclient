package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w bYr;
    private final /* synthetic */ k bYs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, k kVar) {
        this.bYr = wVar;
        this.bYs = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        tbPageContext = this.bYr.LH;
        if (tbPageContext != null) {
            tbPageContext2 = this.bYr.LH;
            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "search_4_" + this.bYs.tid, "click", 1, new Object[0]);
            if (this.bYs.is_floor == 1) {
                tbPageContext5 = this.bYr.LH;
                tbPageContext6 = this.bYr.LH;
                tbPageContext5.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(tbPageContext6.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.bYs.tid)).toString(), new StringBuilder(String.valueOf(this.bYs.pid)).toString(), "search_post", true)));
                return;
            }
            tbPageContext3 = this.bYr.LH;
            tbPageContext4 = this.bYr.LH;
            tbPageContext3.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext4.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.bYs.tid)).toString(), new StringBuilder(String.valueOf(this.bYs.pid)).toString(), "search_post")));
        }
    }
}
