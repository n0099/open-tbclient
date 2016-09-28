package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ j fYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.fYo = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.fYo.T(6, false);
        com.baidu.tieba.f.a.bcl().O(6, false);
        TiebaStatic.log(new ax("c10601"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fYo.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }
}
