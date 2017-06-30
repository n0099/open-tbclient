package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbModel pbModel;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.ewh.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10125");
        pbModel = this.ewh.eue;
        TiebaStatic.log(auVar.Z("tid", pbModel.getThreadID()).r("obj_type", 1));
    }
}
