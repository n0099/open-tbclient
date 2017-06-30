package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ j gaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.gaq = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.gaq.l(6, false);
        com.baidu.tieba.j.a.beN().C(6, false);
        TiebaStatic.log(new au("c10601"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.gaq.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }
}
