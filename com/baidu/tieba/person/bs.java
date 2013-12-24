package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a = ((Integer) view.getTag()).intValue();
        String B = TiebaApplication.B();
        if (B != null && B.length() > 0) {
            this.a.c();
        } else {
            LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_chat), true, 11028);
        }
    }
}
