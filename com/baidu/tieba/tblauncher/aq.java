package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ai aiVar) {
        this.crN = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.crN.eX(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
    }
}
