package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ bc bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar) {
        this.bTa = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTa.bSU = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bTa.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.bTa.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bTa.getString(com.baidu.tieba.t.login_to_chat), true, 11028)));
        } else {
            this.bTa.aeB();
        }
    }
}
