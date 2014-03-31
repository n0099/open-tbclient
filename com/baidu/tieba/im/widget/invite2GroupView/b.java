package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.o;
import com.baidu.tieba.im.data.InviteMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Context context = this.a.getContext();
        inviteMsgData = this.a.e;
        inviteMsgData2 = this.a.e;
        String text = inviteMsgData2.getText();
        inviteMsgData3 = this.a.e;
        o oVar = new o(context, inviteMsgData.getGroupId(), 7, text, inviteMsgData3.getFromUid());
        if (this.a.getContext() instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) this.a.getContext()).sendMessage(new com.baidu.adp.framework.message.a(2008011, oVar));
        } else if (this.a.getContext() instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) this.a.getContext()).a(new com.baidu.adp.framework.message.a(2008011, oVar));
        }
    }
}
