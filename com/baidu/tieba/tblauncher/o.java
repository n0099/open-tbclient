package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ GridLayout fGP;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MainTabActivity mainTabActivity, GridLayout gridLayout) {
        this.this$0 = mainTabActivity;
        this.fGP = gridLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbImageView tbImageView;
        MainTabActivity mainTabActivity = this.this$0;
        GridLayout gridLayout = this.fGP;
        tbImageView = this.this$0.fGB;
        mainTabActivity.d(gridLayout, tbImageView);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, ForumWriteData.class);
        String str = "0";
        String str2 = null;
        if (runTask != null && runTask.getData() != null) {
            ForumWriteData forumWriteData = (ForumWriteData) runTask.getData();
            str = forumWriteData.forumId;
            str2 = forumWriteData.forumName;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteUrlActivityConfig(this.this$0.getPageContext().getPageActivity(), str, str2, "1")));
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12162").Z("obj_locate", "1"));
    }
}
