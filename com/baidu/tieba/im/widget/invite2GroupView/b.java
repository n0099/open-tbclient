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
    private final /* synthetic */ TbPageContext MI;
    final /* synthetic */ Invite2GroupView bre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.bre = invite2GroupView;
        this.MI = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.bre.getContext();
        inviteMsgData = this.bre.brd;
        inviteMsgData2 = this.bre.brd;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.bre.brd;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.MI.getOrignalPage() instanceof BaseActivity) {
            this.MI.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.MI.getOrignalPage() instanceof BaseFragmentActivity) {
            this.MI.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
