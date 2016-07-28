package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dh dhVar;
        this.ebT.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.ebT.getPageContext().getPageActivity(), 23007)));
        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10125");
        dhVar = this.ebT.eas;
        TiebaStatic.log(ayVar.ab("tid", dhVar.getThreadID()).s("obj_type", 1));
    }
}
