package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonListActivity personListActivity) {
        this.f2239a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        bnVar = this.f2239a.e;
        if (bnVar != null) {
            bnVar2 = this.f2239a.e;
            if (bnVar2.getItemViewType(intValue) == 0) {
                bnVar3 = this.f2239a.e;
                UserData userData = (UserData) bnVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.f2239a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
