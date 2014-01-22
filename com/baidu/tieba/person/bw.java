package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        try {
            bdListView = this.a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                cdVar = this.a.e;
                if (i < cdVar.getCount()) {
                    cdVar2 = this.a.e;
                    UserData userData = (UserData) cdVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        cdVar3 = this.a.e;
                        cdVar3.c().c(userData.getPortrait(), new bx(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
