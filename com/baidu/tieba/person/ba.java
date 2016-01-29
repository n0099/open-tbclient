package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ ax cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ax axVar) {
        this.cYT = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cYT.cYM = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.cYT.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cYT.getBaseFragmentActivity().getPageContext().getPageActivity(), this.cYT.getString(t.j.login_to_chat), true, 11028)));
        } else {
            this.cYT.atR();
        }
    }
}
