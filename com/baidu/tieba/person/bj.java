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
    final /* synthetic */ PersonListActivity f2225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonListActivity personListActivity) {
        this.f2225a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2225a.f2189a = ((Integer) view.getTag()).intValue();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            this.f2225a.c();
        } else {
            LoginActivity.a((Activity) this.f2225a, this.f2225a.getString(R.string.login_to_chat), true, 11028);
        }
    }
}
