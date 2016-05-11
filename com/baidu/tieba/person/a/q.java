package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p dxM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.dxM = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.dxM.mContext;
        if (bl.ac(context)) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dxM.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(context2)));
        }
    }
}
