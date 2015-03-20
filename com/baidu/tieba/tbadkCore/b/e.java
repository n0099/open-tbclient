package com.baidu.tieba.tbadkCore.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ BaseActivity bda;
    final /* synthetic */ d cnB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, BaseActivity baseActivity) {
        this.cnB = dVar;
        this.bda = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = a.cnx;
        if (dVar != null) {
            dVar2 = a.cnx;
            dVar2.dismiss();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.bda.getPageContext().getPageActivity(), true, 23004, "expiring")));
    }
}
