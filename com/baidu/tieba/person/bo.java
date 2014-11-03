package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonListActivity personListActivity) {
        this.bDh = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bDh.bCG = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this.bDh, this.bDh.getString(com.baidu.tieba.y.login_to_chat), true, 11028);
        } else {
            this.bDh.aad();
        }
    }
}
