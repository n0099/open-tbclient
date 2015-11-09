package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext RY;
    final /* synthetic */ Invite2GroupView bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.bJF = invite2GroupView;
        this.RY = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.bJF.getContext();
        inviteMsgData = this.bJF.bJE;
        inviteMsgData2 = this.bJF.bJE;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.bJF.bJE;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.RY.getOrignalPage() instanceof BaseActivity) {
            this.RY.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
        } else if (this.RY.getOrignalPage() instanceof BaseFragmentActivity) {
            this.RY.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
        }
    }
}
