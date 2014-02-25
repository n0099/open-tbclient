package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
class cy implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        try {
            bdListView = this.a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                dgVar = this.a.g;
                if (i < dgVar.getCount()) {
                    dgVar2 = this.a.g;
                    UserData userData = (UserData) dgVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        dgVar3 = this.a.g;
                        dgVar3.c().c(userData.getPortrait(), new cz(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
