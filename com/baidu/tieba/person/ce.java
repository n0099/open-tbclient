package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
final class ce implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a = ((Integer) view.getTag()).intValue();
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.a.k.login_to_chat), true, 11028);
        } else {
            this.a.a();
        }
    }
}
