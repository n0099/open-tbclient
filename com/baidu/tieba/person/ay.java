package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ay implements View.OnClickListener {
    final /* synthetic */ av ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.ckB = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ckB.cku = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.ckB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.ckB.getBaseFragmentActivity().getPageContext().getPageActivity(), this.ckB.getString(i.h.login_to_chat), true, 11028)));
        } else {
            this.ckB.agI();
        }
    }
}
