package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Nn;
    final /* synthetic */ Invite2GroupView boC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.boC = invite2GroupView;
        this.Nn = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.boC.getContext();
        inviteMsgData = this.boC.boB;
        inviteMsgData2 = this.boC.boB;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.boC.boB;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.Nn.getOrignalPage() instanceof BaseActivity) {
            this.Nn.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.Nn.getOrignalPage() instanceof BaseFragmentActivity) {
            this.Nn.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
