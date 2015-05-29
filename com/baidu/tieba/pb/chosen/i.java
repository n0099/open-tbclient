package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bJc = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        PbChosenActivity pbChosenActivity2;
        PbChosenActivity pbChosenActivity3;
        pbChosenActivity = this.bJc.bJb;
        pbChosenActivity.sendMessage(new CustomMessage(2001284));
        pbChosenActivity2 = this.bJc.bJb;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(pbChosenActivity2.getPageContext().getPageActivity(), 23003)));
        pbChosenActivity3 = this.bJc.bJb;
        TiebaStatic.eventStat(pbChosenActivity3.getPageContext().getPageActivity(), "pb_new_share", "loc", 1, new Object[0]);
    }
}
