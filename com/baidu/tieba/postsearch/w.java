package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.postsearch.j;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ v cpl;
    private final /* synthetic */ j.a cpm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, j.a aVar) {
        this.cpl = vVar;
        this.cpm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        tbPageContext = this.cpl.LS;
        if (tbPageContext != null) {
            if (this.cpm.is_floor == 1) {
                tbPageContext4 = this.cpl.LS;
                tbPageContext5 = this.cpl.LS;
                tbPageContext4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext5.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.cpm.tid)).toString(), new StringBuilder(String.valueOf(this.cpm.pid)).toString(), "search_post", true)));
                return;
            }
            tbPageContext2 = this.cpl.LS;
            tbPageContext3 = this.cpl.LS;
            tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.cpm.tid)).toString(), new StringBuilder(String.valueOf(this.cpm.pid)).toString(), "search_post")));
        }
    }
}
