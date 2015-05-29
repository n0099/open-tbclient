package com.baidu.tieba.tbadkCore.c;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ BaseActivity bfU;
    final /* synthetic */ d crP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, BaseActivity baseActivity) {
        this.crP = dVar;
        this.bfU = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = a.crL;
        if (dVar != null) {
            dVar2 = a.crL;
            dVar2.dismiss();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig((Context) this.bfU.getPageContext().getPageActivity(), true, 23004, "expiring")));
    }
}
