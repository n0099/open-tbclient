package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p cMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cMz = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        TiebaStatic.log(new av("c10591"));
        MessageManager messageManager = MessageManager.getInstance();
        context = this.cMz.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(context)));
    }
}
