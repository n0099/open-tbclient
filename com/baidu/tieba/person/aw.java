package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ at bCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(at atVar) {
        this.bCN = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonFriendActivity aab;
        this.bCN.bCG = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            aab = this.bCN.aab();
            LoginActivity.a((Activity) aab, this.bCN.getString(com.baidu.tieba.y.login_to_chat), true, 11028);
            return;
        }
        this.bCN.aad();
    }
}
