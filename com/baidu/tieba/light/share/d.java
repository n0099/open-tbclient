package com.baidu.tieba.light.share;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ LightappGameShare bqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LightappGameShare lightappGameShare) {
        this.bqN = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.bqN.aIX;
        if (dVar != null) {
            dVar2 = this.bqN.aIX;
            dVar2.dismiss();
            this.bqN.aIX = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.bqN.getPageContext().getPageActivity(), 23007, 0)));
        TiebaStatic.eventStat(this.bqN.getPageContext().getPageActivity(), "game_share_tbf", "click", 1, "dev_id", this.bqN.aIZ.getGameId(), "share_type", 5);
        this.bqN.finish();
    }
}
