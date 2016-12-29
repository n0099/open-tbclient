package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dc dcVar;
        this.eah.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.eah.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10125");
        dcVar = this.eah.dYA;
        TiebaStatic.log(atVar.ab("tid", dcVar.getThreadID()).s("obj_type", 1));
    }
}
