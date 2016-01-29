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
    final /* synthetic */ w dyh;
    private final /* synthetic */ k.a dyi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, k.a aVar) {
        this.dyh = wVar;
        this.dyi = aVar;
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
        tbPageContext = this.dyh.MR;
        if (tbPageContext != null) {
            if (this.dyi.is_floor == 1) {
                if (this.dyi.thread_type == 33) {
                    tbPageContext8 = this.dyh.MR;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.dyi.tid)).toString(), new StringBuilder(String.valueOf(this.dyi.pid)).toString(), true));
                    tbPageContext9 = this.dyh.MR;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.dyh.MR;
                tbPageContext7 = this.dyh.MR;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.dyi.tid)).toString(), new StringBuilder(String.valueOf(this.dyi.pid)).toString(), "search_post", true)));
            } else if (this.dyi.thread_type != 33) {
                tbPageContext2 = this.dyh.MR;
                tbPageContext3 = this.dyh.MR;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.dyi.tid)).toString(), new StringBuilder(String.valueOf(this.dyi.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.dyh.MR;
                PhotoLiveActivityConfig rC = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.dyi.tid)).cm(String.valueOf(this.dyi.pid)).cn("search_post").rC();
                tbPageContext5 = this.dyh.MR;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, rC));
            }
        }
    }
}
