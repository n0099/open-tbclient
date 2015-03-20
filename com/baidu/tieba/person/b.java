package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity bOA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BasePersonInfoActivity basePersonInfoActivity) {
        this.bOA = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bOA.bOx) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.c.b.a(this.bOA.getPageContext().getPageActivity(), 200, false);
        }
        this.bOA.finish();
    }
}
