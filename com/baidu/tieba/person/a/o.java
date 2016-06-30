package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SingleForumFeedActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n egh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.egh = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.egh.mContext;
        if (bn.ab(context)) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.egh.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(context2)));
        }
    }
}
