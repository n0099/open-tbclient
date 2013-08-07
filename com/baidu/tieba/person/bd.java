package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PersonListActivity personListActivity) {
        this.f1587a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bl blVar;
        bl blVar2;
        bl blVar3;
        try {
            bdListView = this.f1587a.c;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f1587a.c;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                blVar = this.f1587a.f;
                if (i < blVar.getCount()) {
                    blVar2 = this.f1587a.f;
                    UserData userData = (UserData) blVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        blVar3 = this.f1587a.f;
                        blVar3.c().b(userData.getPortrait(), new be(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
