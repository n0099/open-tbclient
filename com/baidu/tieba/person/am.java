package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.bQe = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bQe.bPY = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bQe.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bQe.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bQe.getString(com.baidu.tieba.y.login_to_chat), true, 11028)));
        } else {
            this.bQe.add();
        }
    }
}
