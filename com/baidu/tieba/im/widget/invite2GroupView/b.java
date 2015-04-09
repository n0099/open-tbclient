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
    private final /* synthetic */ TbPageContext Np;
    final /* synthetic */ Invite2GroupView boS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.boS = invite2GroupView;
        this.Np = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.boS.getContext();
        inviteMsgData = this.boS.boR;
        inviteMsgData2 = this.boS.boR;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.boS.boR;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.Np.getOrignalPage() instanceof BaseActivity) {
            this.Np.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.Np.getOrignalPage() instanceof BaseFragmentActivity) {
            this.Np.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
