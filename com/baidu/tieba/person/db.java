package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a = ((Integer) view.getTag()).intValue();
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_chat), true, 11028);
        } else {
            this.a.c();
        }
    }
}
