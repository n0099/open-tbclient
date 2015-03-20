package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PersonListActivity personListActivity) {
        this.bQz = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bQz.bPY = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bQz.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bQz.getPageContext().getPageActivity(), this.bQz.getPageContext().getString(com.baidu.tieba.y.login_to_chat), true, 11028)));
        } else {
            this.bQz.add();
        }
    }
}
