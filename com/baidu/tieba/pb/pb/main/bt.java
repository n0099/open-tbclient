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
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbModel pbModel;
        this.eiV.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.eiV.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10125");
        pbModel = this.eiV.ehh;
        TiebaStatic.log(arVar.ab("tid", pbModel.getThreadID()).s("obj_type", 1));
    }
}
