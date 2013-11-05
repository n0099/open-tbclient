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
    final /* synthetic */ PersonListActivity f2204a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.f2204a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2204a.f2162a = ((Integer) view.getTag()).intValue();
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            this.f2204a.d();
        } else {
            LoginActivity.a((Activity) this.f2204a, this.f2204a.getString(R.string.login_to_chat), true, 11028);
        }
    }
}
