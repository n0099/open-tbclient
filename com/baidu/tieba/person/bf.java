package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar) {
        this.bSZ = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSZ.bST = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bSZ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.bSZ.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bSZ.getString(com.baidu.tieba.t.login_to_chat), true, 11028)));
        } else {
            this.bSZ.aeA();
        }
    }
}
