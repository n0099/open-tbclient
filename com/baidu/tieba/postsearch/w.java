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
    final /* synthetic */ v cEB;
    private final /* synthetic */ j.a cEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, j.a aVar) {
        this.cEB = vVar;
        this.cEC = aVar;
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
        tbPageContext = this.cEB.mContext;
        if (tbPageContext != null) {
            if (this.cEC.is_floor == 1) {
                if (this.cEC.thread_type == 33) {
                    tbPageContext8 = this.cEB.mContext;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.cEC.tid)).toString(), new StringBuilder(String.valueOf(this.cEC.pid)).toString(), true));
                    tbPageContext9 = this.cEB.mContext;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.cEB.mContext;
                tbPageContext7 = this.cEB.mContext;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.cEC.tid)).toString(), new StringBuilder(String.valueOf(this.cEC.pid)).toString(), "search_post", true)));
            } else if (this.cEC.thread_type != 33) {
                tbPageContext2 = this.cEB.mContext;
                tbPageContext3 = this.cEB.mContext;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.cEC.tid)).toString(), new StringBuilder(String.valueOf(this.cEC.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.cEB.mContext;
                PhotoLiveActivityConfig rk = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.cEC.tid)).cg(String.valueOf(this.cEC.pid)).ch("search_post").rk();
                tbPageContext5 = this.cEB.mContext;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, rk));
            }
        }
    }
}
