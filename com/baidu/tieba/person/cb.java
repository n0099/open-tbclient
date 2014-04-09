package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class cb implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        BdListView bdListView2;
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        try {
            bdListView = this.a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                cjVar = this.a.g;
                if (i < cjVar.getCount()) {
                    cjVar2 = this.a.g;
                    UserData userData = (UserData) cjVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        cjVar3 = this.a.g;
                        cjVar3.c().c(userData.getPortrait(), new cc(this));
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
