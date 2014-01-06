package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        cdVar = this.a.e;
        if (cdVar != null) {
            cdVar2 = this.a.e;
            if (cdVar2.getItemViewType(intValue) == 0) {
                cdVar3 = this.a.e;
                UserData userData = (UserData) cdVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
