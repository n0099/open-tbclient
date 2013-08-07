package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonListActivity personListActivity) {
        this.f1590a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        blVar = this.f1590a.f;
        if (blVar != null) {
            blVar2 = this.f1590a.f;
            if (blVar2.getItemViewType(intValue) == 0) {
                blVar3 = this.f1590a.f;
                UserData userData = (UserData) blVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.f1590a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
