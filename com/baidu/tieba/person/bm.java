package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.f1346a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bu buVar;
        bu buVar2;
        bu buVar3;
        try {
            bdListView = this.f1346a.c;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f1346a.c;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                buVar = this.f1346a.f;
                if (i < buVar.getCount()) {
                    buVar2 = this.f1346a.f;
                    UserData userData = (UserData) buVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        buVar3 = this.f1346a.f;
                        buVar3.c().b(userData.getPortrait(), new bn(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
