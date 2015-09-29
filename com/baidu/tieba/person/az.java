package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ aw cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(aw awVar) {
        this.cqf = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cqf.cpY = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.cqf.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cqf.getBaseFragmentActivity().getPageContext().getPageActivity(), this.cqf.getString(i.h.login_to_chat), true, 11028)));
        } else {
            this.cqf.aiI();
        }
    }
}
