package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
    }
}
