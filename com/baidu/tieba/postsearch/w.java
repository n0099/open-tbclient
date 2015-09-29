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
import com.baidu.tieba.postsearch.j;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ v cEq;
    private final /* synthetic */ j.a cEr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, j.a aVar) {
        this.cEq = vVar;
        this.cEr = aVar;
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
        tbPageContext = this.cEq.mContext;
        if (tbPageContext != null) {
            if (this.cEr.is_floor == 1) {
                if (this.cEr.thread_type == 33) {
                    tbPageContext8 = this.cEq.mContext;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.cEr.tid)).toString(), new StringBuilder(String.valueOf(this.cEr.pid)).toString(), true));
                    tbPageContext9 = this.cEq.mContext;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.cEq.mContext;
                tbPageContext7 = this.cEq.mContext;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.cEr.tid)).toString(), new StringBuilder(String.valueOf(this.cEr.pid)).toString(), "search_post", true)));
            } else if (this.cEr.thread_type != 33) {
                tbPageContext2 = this.cEq.mContext;
                tbPageContext3 = this.cEq.mContext;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.cEr.tid)).toString(), new StringBuilder(String.valueOf(this.cEr.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.cEq.mContext;
                PhotoLiveActivityConfig rk = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.cEr.tid)).cf(String.valueOf(this.cEr.pid)).cg("search_post").rk();
                tbPageContext5 = this.cEq.mContext;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, rk));
            }
        }
    }
}
