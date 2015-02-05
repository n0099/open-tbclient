package com.baidu.tieba.light.share;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ LightappGameShare bsk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LightappGameShare lightappGameShare) {
        this.bsk = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.bsk.aKe;
        if (dVar != null) {
            dVar2 = this.bsk.aKe;
            dVar2.dismiss();
            this.bsk.aKe = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.bsk.getPageContext().getPageActivity(), 23007, 0)));
        TiebaStatic.eventStat(this.bsk.getPageContext().getPageActivity(), "game_share_tbf", "click", 1, "dev_id", this.bsk.aKg.getGameId(), "share_type", 5);
        this.bsk.finish();
    }
}
