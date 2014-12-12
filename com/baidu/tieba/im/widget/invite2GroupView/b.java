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
    private final /* synthetic */ TbPageContext Mm;
    final /* synthetic */ Invite2GroupView bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
        this.bpG = invite2GroupView;
        this.Mm = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.bpG.getContext();
        inviteMsgData = this.bpG.bpF;
        inviteMsgData2 = this.bpG.bpF;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.bpG.bpF;
        GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.Mm.getOrignalPage() instanceof BaseActivity) {
            this.Mm.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        } else if (this.Mm.getOrignalPage() instanceof BaseFragmentActivity) {
            this.Mm.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
        }
    }
}
