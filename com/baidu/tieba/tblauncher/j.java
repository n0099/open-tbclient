package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    private final /* synthetic */ LinearLayout fyS;
    private final /* synthetic */ TbImageView fyT;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MainTabActivity mainTabActivity, LinearLayout linearLayout, TbImageView tbImageView) {
        this.this$0 = mainTabActivity;
        this.fyS = linearLayout;
        this.fyT = tbImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        int i;
        MainTabActivity mainTabActivity = this.this$0;
        popupWindow = this.this$0.ajs;
        mainTabActivity.a(popupWindow, this.fyS, this.fyT);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, ForumWriteData.class);
        String str = "0";
        String str2 = null;
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (runTask == null || runTask.getData() == null) {
            i = -1;
        } else {
            ForumWriteData forumWriteData = (ForumWriteData) runTask.getData();
            str = forumWriteData.forumId;
            str2 = forumWriteData.forumName;
            postPrefixData = forumWriteData.prefixData;
            antiData = forumWriteData.antiData;
            i = forumWriteData.forumLevel;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.this$0.getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.setCallFrom("1");
        writeActivityConfig.setForumLevel(i);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }
}
