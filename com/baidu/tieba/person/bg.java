package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonListActivity personListActivity) {
        this.bGG = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGG.bGg = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bGG.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bGG.getPageContext().getPageActivity(), this.bGG.getPageContext().getString(com.baidu.tieba.z.login_to_chat), true, 11028)));
        } else {
            this.bGG.aau();
        }
    }
}
