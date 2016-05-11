package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar) {
        this.dwQ = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dwQ.cZE = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(this.dwQ.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.dwQ.getBaseFragmentActivity().getPageContext().getPageActivity(), this.dwQ.getString(t.j.login_to_chat), true, 11028)));
        } else {
            this.dwQ.atO();
        }
    }
}
