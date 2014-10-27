package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(at atVar) {
        this.bCz = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonFriendActivity ZZ;
        this.bCz.bCs = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            ZZ = this.bCz.ZZ();
            LoginActivity.a((Activity) ZZ, this.bCz.getString(com.baidu.tieba.y.login_to_chat), true, 11028);
            return;
        }
        this.bCz.aab();
    }
}
