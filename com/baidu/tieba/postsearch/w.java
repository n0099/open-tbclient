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
    final /* synthetic */ v cxI;
    private final /* synthetic */ j.a cxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, j.a aVar) {
        this.cxI = vVar;
        this.cxJ = aVar;
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
        tbPageContext = this.cxI.mContext;
        if (tbPageContext != null) {
            if (this.cxJ.is_floor == 1) {
                if (this.cxJ.thread_type == 33) {
                    tbPageContext8 = this.cxI.mContext;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.cxJ.tid)).toString(), new StringBuilder(String.valueOf(this.cxJ.pid)).toString(), true));
                    tbPageContext9 = this.cxI.mContext;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.cxI.mContext;
                tbPageContext7 = this.cxI.mContext;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.cxJ.tid)).toString(), new StringBuilder(String.valueOf(this.cxJ.pid)).toString(), "search_post", true)));
            } else if (this.cxJ.thread_type != 33) {
                tbPageContext2 = this.cxI.mContext;
                tbPageContext3 = this.cxI.mContext;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.cxJ.tid)).toString(), new StringBuilder(String.valueOf(this.cxJ.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.cxI.mContext;
                PhotoLiveActivityConfig ro = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.cxJ.tid)).cf(String.valueOf(this.cxJ.pid)).cg("search_post").ro();
                tbPageContext5 = this.cxI.mContext;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ro));
            }
        }
    }
}
