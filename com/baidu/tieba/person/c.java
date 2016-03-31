package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity dra;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BasePersonInfoActivity basePersonInfoActivity) {
        this.dra = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dra.dqW && this.dra.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.d.b.b(this.dra.getPageContext().getPageActivity(), 200, false);
        }
        this.dra.finish();
    }
}
