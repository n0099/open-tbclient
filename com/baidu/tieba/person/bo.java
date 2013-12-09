package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonListActivity personListActivity) {
        this.f2339a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        btVar = this.f2339a.e;
        if (btVar != null) {
            btVar2 = this.f2339a.e;
            if (btVar2.getItemViewType(intValue) == 0) {
                btVar3 = this.f2339a.e;
                UserData userData = (UserData) btVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.f2339a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
