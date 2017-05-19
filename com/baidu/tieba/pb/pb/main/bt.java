package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbModel pbModel;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.ehy.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10125");
        pbModel = this.ehy.efE;
        TiebaStatic.log(asVar.aa("tid", pbModel.getThreadID()).s("obj_type", 1));
    }
}
