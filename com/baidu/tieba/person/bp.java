package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        try {
            bdListView = this.a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                bwVar = this.a.e;
                if (i < bwVar.getCount()) {
                    bwVar2 = this.a.e;
                    UserData userData = (UserData) bwVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        bwVar3 = this.a.e;
                        bwVar3.c().b(userData.getPortrait(), new bq(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
