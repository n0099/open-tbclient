package com.baidu.tieba.imMessageCenter.chatmessage;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChatMessageActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatMessageActivity chatMessageActivity) {
        this.bFY = chatMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        imageView = this.bFY.bFW;
        if (view == imageView && TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(this.bFY.getPageContext().getContext(), "msg_newchat_tab_c", "click", 1, new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig(this.bFY.getPageContext().getPageActivity(), true)));
        }
    }
}
