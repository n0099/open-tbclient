package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.bGm = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGm.bGg = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bGm.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bGm.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bGm.getString(com.baidu.tieba.z.login_to_chat), true, 11028)));
        } else {
            this.bGm.aau();
        }
    }
}
