package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonListActivity personListActivity) {
        this.f2337a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bu buVar;
        bu buVar2;
        bu buVar3;
        try {
            bdListView = this.f2337a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f2337a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                buVar = this.f2337a.e;
                if (i < buVar.getCount()) {
                    buVar2 = this.f2337a.e;
                    UserData userData = (UserData) buVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        buVar3 = this.f2337a.e;
                        buVar3.c().b(userData.getPortrait(), new bo(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
