package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
final class da implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        dgVar = this.a.g;
        if (dgVar != null) {
            dgVar2 = this.a.g;
            if (dgVar2.getItemViewType(intValue) == 0) {
                dgVar3 = this.a.g;
                UserData userData = (UserData) dgVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    cm.a(this.a, userData.getUserId(), userData.getName_show());
                }
            }
        }
    }
}
