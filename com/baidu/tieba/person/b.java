package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity cnX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BasePersonInfoActivity basePersonInfoActivity) {
        this.cnX = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cnX.cnT && this.cnX.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.c.b.b(this.cnX.getPageContext().getPageActivity(), 200, false);
        }
        this.cnX.finish();
    }
}
