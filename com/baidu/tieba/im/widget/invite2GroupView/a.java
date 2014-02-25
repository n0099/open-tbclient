package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        button = this.a.d;
        Context context = button.getContext();
        StringBuilder sb = new StringBuilder();
        inviteMsgData = this.a.e;
        String sb2 = sb.append(inviteMsgData.getGroupId()).toString();
        inviteMsgData2 = this.a.e;
        long fromUid = inviteMsgData2.getFromUid();
        inviteMsgData3 = this.a.e;
        ApplyJoinGroupActivity.a(context, sb2, fromUid, inviteMsgData3.getText());
    }
}
