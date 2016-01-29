package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SingleForumFeedActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m dal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.dal = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.dal.mContext;
        if (bi.ah(context)) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dal.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(context2)));
        }
    }
}
