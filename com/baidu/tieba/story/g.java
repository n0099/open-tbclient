package com.baidu.tieba.story;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordStoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageViewGroup;
/* loaded from: classes.dex */
public class g implements View.OnClickListener, HeadImageViewGroup.a {
    private int fWk;
    private long forumId;
    private String forumName;
    private TbPageContext mG;

    public g(TbPageContext tbPageContext, int i, long j, String str) {
        this.mG = tbPageContext;
        this.fWk = i;
        this.forumId = j;
        this.forumName = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            TiebaStatic.log(new ak("c12358").f("fid", this.forumId).r("obj_locate", this.fWk == 1 ? 1 : 2).r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordStoryActivityConfig(this.mG.getPageActivity(), this.fWk, this.forumId, this.forumName)));
        }
    }
}
