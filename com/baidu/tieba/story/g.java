package com.baidu.tieba.story;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordStoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageViewGroup;
/* loaded from: classes.dex */
public class g implements View.OnClickListener, HeadImageViewGroup.a {
    private TbPageContext ako;
    private int fWe;
    private long forumId;
    private String forumName;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i, long j, String str) {
        this.ako = tbPageContext;
        this.fWe = i;
        this.forumId = j;
        this.forumName = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && (view.getTag() instanceof com.baidu.tbadk.j.a)) {
            TiebaStatic.log(new aj("c12358").f("fid", this.forumId).r("obj_locate", this.fWe == 1 ? 1 : 2).r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordStoryActivityConfig(this.ako.getPageActivity(), this.fWe, this.forumId, this.forumName)));
        }
    }
}
