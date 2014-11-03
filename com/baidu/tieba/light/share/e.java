package com.baidu.tieba.light.share;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ LightappGameShare blY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LightappGameShare lightappGameShare) {
        this.blY = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.blY.aIl;
        if (dVar != null) {
            dVar2 = this.blY.aIl;
            dVar2.dismiss();
            this.blY.aIl = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.blY, 23007, 0)));
        TiebaStatic.eventStat(this.blY, "game_share_tbf", "click", 1, "dev_id", this.blY.aIn.getGameId(), "share_type", 5);
        this.blY.finish();
    }
}
