package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ s cfP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cfP = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        pbChosenActivity = this.cfP.cfO;
        pbChosenActivity.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        pbChosenActivity2 = this.cfP.cfO;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(pbChosenActivity2.getPageContext().getPageActivity(), 23007)));
        pbChosenActivity3 = this.cfP.cfO;
        TiebaStatic.eventStat(pbChosenActivity3.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
    }
}
