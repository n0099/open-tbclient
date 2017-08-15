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
    private int fZj;
    private long forumId;
    private String forumName;
    private TbPageContext oV;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i, long j, String str) {
        this.oV = tbPageContext;
        this.fZj = i;
        this.forumId = j;
        this.forumName = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && (view.getTag() instanceof com.baidu.tbadk.j.a)) {
            TiebaStatic.log(new aj("c12358").g("fid", this.forumId).r("obj_locate", this.fZj == 1 ? 1 : 2).r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordStoryActivityConfig(this.oV.getPageActivity(), this.fZj, this.forumId, this.forumName)));
        }
    }
}
