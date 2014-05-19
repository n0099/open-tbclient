package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ca implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        try {
            bdListView = this.a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                ciVar = this.a.g;
                if (i < ciVar.getCount()) {
                    ciVar2 = this.a.g;
                    UserData userData = (UserData) ciVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        ciVar3 = this.a.g;
                        ciVar3.c().c(userData.getPortrait(), new cb(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
