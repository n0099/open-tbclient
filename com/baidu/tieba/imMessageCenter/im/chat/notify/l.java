package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ d bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.bpB = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig((Context) this.bpB.getPageContext().getPageActivity(), true, true)));
        }
    }
}
