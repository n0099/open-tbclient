package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.bHX = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHX.bHR = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bHX.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bHX.getBaseFragmentActivity().getPageContext().getPageActivity(), this.bHX.getString(com.baidu.tieba.z.login_to_chat), true, 11028)));
        } else {
            this.bHX.aaZ();
        }
    }
}
