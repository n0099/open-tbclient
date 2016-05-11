package com.baidu.tieba.recommendfrs.control;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ q dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar) {
        this.dZi = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.dZi.mContext;
        if (context != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dZi.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(context2)));
        }
    }
}
