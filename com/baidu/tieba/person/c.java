package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity cWy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BasePersonInfoActivity basePersonInfoActivity) {
        this.cWy = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cWy.cWu && this.cWy.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.c.b.b(this.cWy.getPageContext().getPageActivity(), 200, false);
        }
        this.cWy.finish();
    }
}
