package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.y;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.a.getContext();
        inviteMsgData = this.a.e;
        inviteMsgData2 = this.a.e;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.a.e;
        y yVar = new y(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.a.getContext() instanceof BaseActivity) {
            ((BaseActivity) this.a.getContext()).sendMessage(new CustomMessage(2008011, yVar));
        } else if (this.a.getContext() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.a.getContext()).a(new CustomMessage(2008011, yVar));
        }
    }
}
