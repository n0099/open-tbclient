package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.f2339a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        buVar = this.f2339a.e;
        if (buVar != null) {
            buVar2 = this.f2339a.e;
            if (buVar2.getItemViewType(intValue) == 0) {
                buVar3 = this.f2339a.e;
                UserData userData = (UserData) buVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.f2339a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
