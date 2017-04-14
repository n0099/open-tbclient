package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbModel pbModel;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.ejU.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10125");
        pbModel = this.ejU.eif;
        TiebaStatic.log(asVar.aa("tid", pbModel.getThreadID()).s("obj_type", 1));
    }
}
