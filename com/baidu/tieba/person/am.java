package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ aj bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.bQu = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bQu.bQo = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bQu.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bQu.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bQu.getString(com.baidu.tieba.y.login_to_chat), true, 11028)));
        } else {
            this.bQu.ads();
        }
    }
}
