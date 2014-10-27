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
    final /* synthetic */ Invite2GroupView bkd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView) {
        this.bkd = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.bkd.getContext();
        inviteMsgData = this.bkd.bkc;
        inviteMsgData2 = this.bkd.bkc;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.bkd.bkc;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.bkd.getContext() instanceof BaseActivity) {
            ((BaseActivity) this.bkd.getContext()).sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.bkd.getContext() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.bkd.getContext()).sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
