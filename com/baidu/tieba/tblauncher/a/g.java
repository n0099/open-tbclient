package com.baidu.tieba.tblauncher.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ d cst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.cst = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001267));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), currentAccountObj.getID(), currentAccountObj.getAccount())));
        }
    }
}
