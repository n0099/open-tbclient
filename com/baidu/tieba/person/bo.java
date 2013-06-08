package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        btVar = this.a.h;
        if (btVar != null) {
            btVar2 = this.a.h;
            if (btVar2.getItemViewType(intValue) == 0) {
                btVar3 = this.a.h;
                com.baidu.tieba.a.be beVar = (com.baidu.tieba.a.be) btVar3.getItem(intValue);
                if (beVar != null && beVar.a() != null) {
                    PersonInfoActivity.a(this.a, beVar.a(), beVar.d());
                }
            }
        }
    }
}
