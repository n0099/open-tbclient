package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ be cYp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(be beVar) {
        this.cYp = beVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10598"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
    }
}
