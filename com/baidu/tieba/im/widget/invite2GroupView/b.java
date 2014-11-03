package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView bkr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView) {
        this.bkr = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.bkr.getContext();
        inviteMsgData = this.bkr.bkq;
        inviteMsgData2 = this.bkr.bkq;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.bkr.bkq;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.bkr.getContext() instanceof BaseActivity) {
            ((BaseActivity) this.bkr.getContext()).sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.bkr.getContext() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.bkr.getContext()).sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
