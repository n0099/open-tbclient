package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.postsearch.k;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w dSN;
    private final /* synthetic */ k.a dSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, k.a aVar) {
        this.dSN = wVar;
        this.dSO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        TbPageContext tbPageContext7;
        TbPageContext tbPageContext8;
        TbPageContext tbPageContext9;
        tbPageContext = this.dSN.MX;
        if (tbPageContext != null) {
            if (this.dSO.is_floor == 1) {
                if (this.dSO.thread_type == 33) {
                    tbPageContext8 = this.dSN.MX;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.dSO.tid)).toString(), new StringBuilder(String.valueOf(this.dSO.pid)).toString(), true));
                    tbPageContext9 = this.dSN.MX;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.dSN.MX;
                tbPageContext7 = this.dSN.MX;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.dSO.tid)).toString(), new StringBuilder(String.valueOf(this.dSO.pid)).toString(), "search_post", true)));
            } else if (this.dSO.thread_type != 33) {
                tbPageContext2 = this.dSN.MX;
                tbPageContext3 = this.dSN.MX;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.dSO.tid)).toString(), new StringBuilder(String.valueOf(this.dSO.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.dSN.MX;
                PhotoLiveActivityConfig qT = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.dSO.tid)).cj(String.valueOf(this.dSO.pid)).ck("search_post").qT();
                tbPageContext5 = this.dSN.MX;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, qT));
            }
        }
    }
}
