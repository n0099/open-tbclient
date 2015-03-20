package com.baidu.tieba.light.share;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ LightappGameShare byr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LightappGameShare lightappGameShare) {
        this.byr = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.byr.aQg;
        if (dVar != null) {
            dVar2 = this.byr.aQg;
            dVar2.dismiss();
            this.byr.aQg = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.byr.getPageContext().getPageActivity(), 23003, 2)));
        TiebaStatic.eventStat(this.byr.getPageContext().getPageActivity(), "game_share_tbg", "click", 1, "dev_id", this.byr.aQi.getGameId(), "share_type", 5);
        this.byr.finish();
    }
}
