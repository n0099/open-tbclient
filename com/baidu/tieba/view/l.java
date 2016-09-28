package com.baidu.tieba.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j fYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.fYo = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fYo.T(5, false);
        com.baidu.tieba.f.a.bcl().O(5, false);
        TiebaStatic.log(new ax("c10598"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
    }
}
