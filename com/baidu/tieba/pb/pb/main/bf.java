package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cm cmVar;
        this.cNq.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.cNq.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10125");
        cmVar = this.cNq.cMF;
        TiebaStatic.log(auVar.aa("tid", cmVar.getThreadID()).r("obj_type", 1));
    }
}
