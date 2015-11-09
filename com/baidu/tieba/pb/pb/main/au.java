package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ca caVar;
        this.cjN.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.cjN.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10125");
        caVar = this.cjN.cjj;
        TiebaStatic.log(aqVar.ae("tid", caVar.getThreadID()).r("obj_type", 1));
    }
}
