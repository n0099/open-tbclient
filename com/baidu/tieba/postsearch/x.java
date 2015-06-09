package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w bYs;
    private final /* synthetic */ k bYt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, k kVar) {
        this.bYs = wVar;
        this.bYt = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        tbPageContext = this.bYs.LH;
        if (tbPageContext != null) {
            tbPageContext2 = this.bYs.LH;
            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "search_4_" + this.bYt.tid, "click", 1, new Object[0]);
            if (this.bYt.is_floor == 1) {
                tbPageContext5 = this.bYs.LH;
                tbPageContext6 = this.bYs.LH;
                tbPageContext5.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(tbPageContext6.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.bYt.tid)).toString(), new StringBuilder(String.valueOf(this.bYt.pid)).toString(), "search_post", true)));
                return;
            }
            tbPageContext3 = this.bYs.LH;
            tbPageContext4 = this.bYs.LH;
            tbPageContext3.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext4.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.bYt.tid)).toString(), new StringBuilder(String.valueOf(this.bYt.pid)).toString(), "search_post")));
        }
    }
}
