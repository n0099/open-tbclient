package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dj djVar;
        this.evL.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.evL.getPageContext().getPageActivity(), 23003)));
        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10125");
        djVar = this.evL.euf;
        TiebaStatic.log(avVar.ab("tid", djVar.getThreadID()).s("obj_type", 2));
    }
}
