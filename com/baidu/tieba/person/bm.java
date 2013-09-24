package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.f1682a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar;
        br brVar2;
        br brVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        brVar = this.f1682a.e;
        if (brVar != null) {
            brVar2 = this.f1682a.e;
            if (brVar2.getItemViewType(intValue) == 0) {
                brVar3 = this.f1682a.e;
                UserData userData = (UserData) brVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.f1682a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
