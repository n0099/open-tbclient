package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbModel pbModel;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.enc.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10125");
        pbModel = this.enc.ele;
        TiebaStatic.log(asVar.Z("tid", pbModel.getThreadID()).r("obj_type", 1));
    }
}
