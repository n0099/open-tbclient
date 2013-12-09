package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.f2340a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2340a.f2298a = ((Integer) view.getTag()).intValue();
        String B = TiebaApplication.B();
        if (B != null && B.length() > 0) {
            this.f2340a.c();
        } else {
            LoginActivity.a((Activity) this.f2340a, this.f2340a.getString(R.string.login_to_chat), true, 11028);
        }
    }
}
