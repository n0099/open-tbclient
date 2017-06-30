package com.baidu.tieba.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ j gaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.gaq = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gaq.l(5, false);
        com.baidu.tieba.j.a.beN().C(5, false);
        TiebaStatic.log(new au("c10598"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
    }
}
