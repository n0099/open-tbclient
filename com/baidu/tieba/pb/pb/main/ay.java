package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cf cfVar;
        this.cFS.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.cFS.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10125");
        cfVar = this.cFS.cFl;
        TiebaStatic.log(avVar.aa("tid", cfVar.getThreadID()).r("obj_type", 1));
    }
}
