package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ j fIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.fIG = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.fIG.G(6, false);
        com.baidu.tieba.h.a.aZj().D(6, false);
        TiebaStatic.log(new as("c10601"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fIG.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }
}
