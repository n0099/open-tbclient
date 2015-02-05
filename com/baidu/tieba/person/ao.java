package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ al bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.bHW = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHW.bHQ = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bHW.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bHW.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bHW.getString(com.baidu.tieba.z.login_to_chat), true, 11028)));
        } else {
            this.bHW.aaU();
        }
    }
}
