package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonListActivity personListActivity) {
        this.f1591a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1591a.f1556a = ((Integer) view.getTag()).intValue();
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this.f1591a, this.f1591a.getString(R.string.login_to_chat), true, 11028);
        } else {
            this.f1591a.c();
        }
    }
}
