package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        if (this.a.getContext() instanceof Activity) {
            inviteMsgData = this.a.e;
            int groupId = inviteMsgData.getGroupId();
            inviteMsgData2 = this.a.e;
            String groupName = inviteMsgData2.getGroupName();
            inviteMsgData3 = this.a.e;
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tieba.a.b((Activity) this.a.getContext(), groupId, groupName, inviteMsgData3.getGroupOwnerId(), "invite add group")));
        }
    }
}
