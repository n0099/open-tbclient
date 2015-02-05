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
    private final /* synthetic */ TbPageContext MF;
    final /* synthetic */ Invite2GroupView brd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.brd = invite2GroupView;
        this.MF = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.brd.getContext();
        inviteMsgData = this.brd.brc;
        inviteMsgData2 = this.brd.brc;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.brd.brc;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.MF.getOrignalPage() instanceof BaseActivity) {
            this.MF.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.MF.getOrignalPage() instanceof BaseFragmentActivity) {
            this.MF.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
