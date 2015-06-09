package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(aj ajVar) {
        this.cwo = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cwo.fq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
    }
}
