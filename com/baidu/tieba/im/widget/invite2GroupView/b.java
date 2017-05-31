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
    private final /* synthetic */ TbPageContext Qp;
    final /* synthetic */ Invite2GroupView diA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.diA = invite2GroupView;
        this.Qp = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.diA.getContext();
        inviteMsgData = this.diA.diz;
        inviteMsgData2 = this.diA.diz;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.diA.diz;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.Qp.getOrignalPage() instanceof BaseActivity) {
            this.Qp.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
        } else if (this.Qp.getOrignalPage() instanceof BaseFragmentActivity) {
            this.Qp.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
        }
    }
}
