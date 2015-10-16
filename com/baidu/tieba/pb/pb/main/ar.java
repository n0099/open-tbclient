package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        this.ciK.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.ciK.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10125");
        blVar = this.ciK.cih;
        TiebaStatic.log(aqVar.ae("tid", blVar.getThreadID()).r("obj_type", 1));
    }
}
