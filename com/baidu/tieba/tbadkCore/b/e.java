package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ BaseActivity bXg;
    final /* synthetic */ d fBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, BaseActivity baseActivity) {
        this.fBB = dVar;
        this.bXg = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = a.fBx;
        if (dVar != null) {
            dVar2 = a.fBx;
            dVar2.dismiss();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) this.bXg.getPageContext().getPageActivity(), true, 23004, "expiring")));
    }
}
