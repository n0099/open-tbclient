package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cfo = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        pbChosenActivity = this.cfo.cfn;
        pbChosenActivity.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        pbChosenActivity2 = this.cfo.cfn;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(pbChosenActivity2.getPageContext().getPageActivity(), 23003)));
        pbChosenActivity3 = this.cfo.cfn;
        TiebaStatic.eventStat(pbChosenActivity3.getPageContext().getPageActivity(), "pb_new_share", "loc", 1, new Object[0]);
    }
}
