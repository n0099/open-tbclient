package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class cg implements View.OnClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cd cdVar) {
        this.a = cdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonFriendActivity f;
        this.a.c = ((Integer) view.getTag()).intValue();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            f = this.a.f();
            LoginActivity.a((Activity) f, this.a.getString(com.baidu.tieba.x.login_to_chat), true, 11028);
            return;
        }
        this.a.h();
    }
}
