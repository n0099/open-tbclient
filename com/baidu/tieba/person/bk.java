package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonListActivity personListActivity) {
        this.f1680a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        br brVar;
        br brVar2;
        br brVar3;
        try {
            bdListView = this.f1680a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f1680a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                brVar = this.f1680a.e;
                if (i < brVar.getCount()) {
                    brVar2 = this.f1680a.e;
                    UserData userData = (UserData) brVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        brVar3 = this.f1680a.e;
                        brVar3.c().b(userData.getPortrait(), new bl(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
