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
    private final /* synthetic */ TbPageContext Kq;
    final /* synthetic */ Invite2GroupView cYa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.cYa = invite2GroupView;
        this.Kq = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.cYa.getContext();
        inviteMsgData = this.cYa.cXZ;
        inviteMsgData2 = this.cYa.cXZ;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.cYa.cXZ;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.Kq.getOrignalPage() instanceof BaseActivity) {
            this.Kq.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
        } else if (this.Kq.getOrignalPage() instanceof BaseFragmentActivity) {
            this.Kq.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
        }
    }
}
