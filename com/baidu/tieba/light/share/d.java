package com.baidu.tieba.light.share;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ LightappGameShare byH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LightappGameShare lightappGameShare) {
        this.byH = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.byH.aQx;
        if (dVar != null) {
            dVar2 = this.byH.aQx;
            dVar2.dismiss();
            this.byH.aQx = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.byH.getPageContext().getPageActivity(), 23007, 0)));
        TiebaStatic.eventStat(this.byH.getPageContext().getPageActivity(), "game_share_tbf", "click", 1, "dev_id", this.byH.aQz.getGameId(), "share_type", 5);
        this.byH.finish();
    }
}
