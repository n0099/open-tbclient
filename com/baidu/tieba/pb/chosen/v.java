package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t cBY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.cBY = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        pbChosenActivity = this.cBY.cBX;
        pbChosenActivity.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        pbChosenActivity2 = this.cBY.cBX;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(pbChosenActivity2.getPageContext().getPageActivity(), 23007)));
        pbChosenActivity3 = this.cBY.cBX;
        TiebaStatic.eventStat(pbChosenActivity3.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
    }
}
