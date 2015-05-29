package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity bQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BasePersonInfoActivity basePersonInfoActivity) {
        this.bQS = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bQS.bQO && this.bQS.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.c.b.a(this.bQS.getPageContext().getPageActivity(), 200, false);
        }
        this.bQS.finish();
    }
}
