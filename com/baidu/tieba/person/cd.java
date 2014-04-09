package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class cd implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        cjVar = this.a.g;
        if (cjVar != null) {
            cjVar2 = this.a.g;
            if (cjVar2.getItemViewType(intValue) == 0) {
                cjVar3 = this.a.g;
                UserData userData = (UserData) cjVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.a, userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
