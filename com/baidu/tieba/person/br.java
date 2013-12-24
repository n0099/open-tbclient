package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        bwVar = this.a.e;
        if (bwVar != null) {
            bwVar2 = this.a.e;
            if (bwVar2.getItemViewType(intValue) == 0) {
                bwVar3 = this.a.e;
                UserData userData = (UserData) bwVar3.getItem(intValue);
                if (userData != null && userData.getId() != null) {
                    PersonInfoActivity.a(this.a, userData.getId(), userData.getName_show());
                }
            }
        }
    }
}
