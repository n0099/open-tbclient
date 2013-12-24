package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        if (this.a.a.getContext() instanceof Activity) {
            inviteMsgData = this.a.a.e;
            int groupId = inviteMsgData.getGroupId();
            inviteMsgData2 = this.a.a.e;
            String groupName = inviteMsgData2.getGroupName();
            inviteMsgData3 = this.a.a.e;
            GroupChatActivity.a((Activity) this.a.a.getContext(), groupId, groupName, inviteMsgData3.getGroupOwnerId(), "invite add group");
        }
    }
}
