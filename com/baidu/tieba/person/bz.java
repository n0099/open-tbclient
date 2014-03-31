package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class bz implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        BdListView bdListView2;
        ch chVar;
        ch chVar2;
        ch chVar3;
        try {
            bdListView = this.a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                chVar = this.a.g;
                if (i < chVar.getCount()) {
                    chVar2 = this.a.g;
                    UserData userData = (UserData) chVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        chVar3 = this.a.g;
                        chVar3.c().c(userData.getPortrait(), new ca(this));
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
