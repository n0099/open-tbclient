package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cc ccVar;
        this.cCm.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.cCm.getPageContext().getPageActivity(), 23003)));
        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10125");
        ccVar = this.cCm.cBG;
        TiebaStatic.log(avVar.ab("tid", ccVar.getThreadID()).r("obj_type", 2));
    }
}
