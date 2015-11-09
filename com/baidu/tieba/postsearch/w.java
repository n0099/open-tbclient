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
    final /* synthetic */ v cFX;
    private final /* synthetic */ j.a cFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, j.a aVar) {
        this.cFX = vVar;
        this.cFY = aVar;
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
        tbPageContext = this.cFX.mContext;
        if (tbPageContext != null) {
            if (this.cFY.is_floor == 1) {
                if (this.cFY.thread_type == 33) {
                    tbPageContext8 = this.cFX.mContext;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.cFY.tid)).toString(), new StringBuilder(String.valueOf(this.cFY.pid)).toString(), true));
                    tbPageContext9 = this.cFX.mContext;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.cFX.mContext;
                tbPageContext7 = this.cFX.mContext;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.cFY.tid)).toString(), new StringBuilder(String.valueOf(this.cFY.pid)).toString(), "search_post", true)));
            } else if (this.cFY.thread_type != 33) {
                tbPageContext2 = this.cFX.mContext;
                tbPageContext3 = this.cFX.mContext;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.cFY.tid)).toString(), new StringBuilder(String.valueOf(this.cFY.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.cFX.mContext;
                PhotoLiveActivityConfig ri = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.cFY.tid)).ce(String.valueOf(this.cFY.pid)).cf("search_post").ri();
                tbPageContext5 = this.cFX.mContext;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ri));
            }
        }
    }
}
