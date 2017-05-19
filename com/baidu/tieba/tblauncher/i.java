package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    private final /* synthetic */ LinearLayout fyS;
    private final /* synthetic */ TbImageView fyT;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MainTabActivity mainTabActivity, LinearLayout linearLayout, TbImageView tbImageView) {
        this.this$0 = mainTabActivity;
        this.fyS = linearLayout;
        this.fyT = tbImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        MainTabActivity mainTabActivity = this.this$0;
        popupWindow = this.this$0.ajs;
        mainTabActivity.a(popupWindow, this.fyS, this.fyT);
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, ForumWriteData.class);
        String str = "0";
        String str2 = null;
        if (runTask != null && runTask.getData() != null) {
            ForumWriteData forumWriteData = (ForumWriteData) runTask.getData();
            str = forumWriteData.forumId;
            str2 = forumWriteData.forumName;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(TbadkCoreApplication.m9getInst().getApplicationContext(), str2, str, TbadkCoreApplication.getCurrentAccount(), true, false)));
    }
}
