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
    final /* synthetic */ w dVF;
    private final /* synthetic */ k.a dVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, k.a aVar) {
        this.dVF = wVar;
        this.dVG = aVar;
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
        tbPageContext = this.dVF.Do;
        if (tbPageContext != null) {
            if (this.dVG.is_floor == 1) {
                if (this.dVG.thread_type == 33) {
                    tbPageContext8 = this.dVF.Do;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext8.getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder(String.valueOf(this.dVG.tid)).toString(), new StringBuilder(String.valueOf(this.dVG.pid)).toString(), true));
                    tbPageContext9 = this.dVF.Do;
                    tbPageContext9.sendMessage(customMessage);
                    return;
                }
                tbPageContext6 = this.dVF.Do;
                tbPageContext7 = this.dVF.Do;
                tbPageContext6.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext7.getPageActivity()).createSubPbActivityConfig(new StringBuilder(String.valueOf(this.dVG.tid)).toString(), new StringBuilder(String.valueOf(this.dVG.pid)).toString(), "search_post", true)));
            } else if (this.dVG.thread_type != 33) {
                tbPageContext2 = this.dVF.Do;
                tbPageContext3 = this.dVF.Do;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(new StringBuilder(String.valueOf(this.dVG.tid)).toString(), new StringBuilder(String.valueOf(this.dVG.pid)).toString(), "search_post")));
            } else {
                TiebaStatic.log("c10256");
                tbPageContext4 = this.dVF.Do;
                PhotoLiveActivityConfig oq = new PhotoLiveActivityConfig.a(tbPageContext4.getPageActivity(), String.valueOf(this.dVG.tid)).ch(String.valueOf(this.dVG.pid)).ci("search_post").oq();
                tbPageContext5 = this.dVF.Do;
                tbPageContext5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oq));
            }
        }
    }
}
