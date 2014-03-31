package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class cb implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        chVar = this.a.g;
        if (chVar != null) {
            chVar2 = this.a.g;
            if (chVar2.getItemViewType(intValue) == 0) {
                chVar3 = this.a.g;
                UserData userData = (UserData) chVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.a, userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
