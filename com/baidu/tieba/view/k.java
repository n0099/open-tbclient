package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ j gfJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.gfJ = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.gfJ.W(6, false);
        com.baidu.tieba.f.a.beM().R(6, false);
        TiebaStatic.log(new av("c10601"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.gfJ.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }
}
