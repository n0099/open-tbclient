package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ az efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar) {
        this.efi = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.efi.dGm = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.efi.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.efi.getBaseFragmentActivity().getPageContext().getPageActivity(), this.efi.getString(u.j.login_to_chat), true, 11028)));
        } else {
            this.efi.aBW();
        }
    }
}
