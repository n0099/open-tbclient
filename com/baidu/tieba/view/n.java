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
    final /* synthetic */ j fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.fQz = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.fQz.l(6, false);
        com.baidu.tieba.j.a.baD().C(6, false);
        TiebaStatic.log(new as("c10601"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fQz.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }
}
