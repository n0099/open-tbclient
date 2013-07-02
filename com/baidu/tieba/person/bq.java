package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a = ((Integer) view.getTag()).intValue();
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_chat), true, 1100028);
        } else {
            this.a.c();
        }
    }
}
