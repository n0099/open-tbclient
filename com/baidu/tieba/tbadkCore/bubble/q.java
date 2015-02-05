package com.baidu.tieba.tbadkCore.bubble;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ p bXT;
    private final /* synthetic */ BaseActivity baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, BaseActivity baseActivity) {
        this.bXT = pVar;
        this.baY = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        d dVar2;
        dVar = m.bXP;
        if (dVar != null) {
            dVar2 = m.bXP;
            dVar2.dismiss();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.baY.getPageContext().getPageActivity(), true, 23004, "expiring")));
    }
}
