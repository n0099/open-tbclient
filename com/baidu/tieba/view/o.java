package com.baidu.tieba.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ j fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.fQz = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fQz.l(5, false);
        com.baidu.tieba.j.a.baD().C(5, false);
        TiebaStatic.log(new as("c10598"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
    }
}
