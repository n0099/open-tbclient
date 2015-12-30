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
    final /* synthetic */ w dkm;
    private final /* synthetic */ k.a dkn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, k.a aVar) {
        this.dkm = wVar;
        this.dkn = aVar;
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
        tbPageContext = this.dkm.mContext;
        if (tbPageContext != null) {
            if (this.dkn.is_floor == 1) {
                if (this.dkn.thread_type == 33) {
                    tbPageContext8 = this.dkm.mContext;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.dkn.tid)).toString(), new StringBuilder(String.valueOf(this.dkn.pid)).toString(), true));
                    tbPageContext9 = this.dkm.mContext;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.dkm.mContext;
                tbPageContext7 = this.dkm.mContext;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.dkn.tid)).toString(), new StringBuilder(String.valueOf(this.dkn.pid)).toString(), "search_post", true)));
            } else if (this.dkn.thread_type != 33) {
                tbPageContext2 = this.dkm.mContext;
                tbPageContext3 = this.dkm.mContext;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.dkn.tid)).toString(), new StringBuilder(String.valueOf(this.dkn.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.dkm.mContext;
                PhotoLiveActivityConfig rf = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.dkn.tid)).cn(String.valueOf(this.dkn.pid)).co("search_post").rf();
                tbPageContext5 = this.dkm.mContext;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, rf));
            }
        }
    }
}
