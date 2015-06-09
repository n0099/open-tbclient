package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PersonListActivity personListActivity) {
        this.bTv = personListActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.person.PersonListActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTv.bSU = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bTv.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.bTv.getPageContext().getPageActivity(), this.bTv.getPageContext().getString(com.baidu.tieba.t.login_to_chat), true, 11028)));
        } else {
            this.bTv.aeB();
        }
    }
}
