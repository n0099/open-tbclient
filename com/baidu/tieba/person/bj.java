package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonListActivity personListActivity) {
        this.f2240a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2240a.f2204a = ((Integer) view.getTag()).intValue();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            this.f2240a.c();
        } else {
            LoginActivity.a((Activity) this.f2240a, this.f2240a.getString(R.string.login_to_chat), true, 11028);
        }
    }
}
