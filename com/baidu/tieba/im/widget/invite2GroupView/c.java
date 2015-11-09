package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Invite2GroupView invite2GroupView) {
        this.bJF = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        if (this.bJF.getContext() instanceof Activity) {
            inviteMsgData = this.bJF.bJE;
            int groupId = inviteMsgData.getGroupId();
            inviteMsgData2 = this.bJF.bJE;
            String groupName = inviteMsgData2.getGroupName();
            inviteMsgData3 = this.bJF.bJE;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) this.bJF.getContext(), groupId, groupName, inviteMsgData3.getGroupOwnerId(), "invite add group")));
        }
    }
}
