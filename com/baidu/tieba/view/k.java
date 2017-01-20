package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ j fDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.fDw = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.fDw.G(6, false);
        com.baidu.tieba.h.a.bap().D(6, false);
        TiebaStatic.log(new ar("c10601"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fDw.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }
}
