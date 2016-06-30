package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView cYa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Invite2GroupView invite2GroupView) {
        this.cYa = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        textView = this.cYa.Fb;
        Context context = textView.getContext();
        StringBuilder sb = new StringBuilder();
        inviteMsgData = this.cYa.cXZ;
        String sb2 = sb.append(inviteMsgData.getGroupId()).toString();
        inviteMsgData2 = this.cYa.cXZ;
        long fromUid = inviteMsgData2.getFromUid();
        inviteMsgData3 = this.cYa.cXZ;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(context, sb2, fromUid, inviteMsgData3.getText())));
    }
}
