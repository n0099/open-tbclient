package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cw cwVar;
        this.djE.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.djE.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10125");
        cwVar = this.djE.dih;
        TiebaStatic.log(awVar.ac("tid", cwVar.getThreadID()).s("obj_type", 1));
    }
}
