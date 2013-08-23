package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonListActivity personListActivity) {
        this.f1631a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bt btVar;
        bt btVar2;
        bt btVar3;
        try {
            bdListView = this.f1631a.c;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f1631a.c;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                btVar = this.f1631a.f;
                if (i < btVar.getCount()) {
                    btVar2 = this.f1631a.f;
                    UserData userData = (UserData) btVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        btVar3 = this.f1631a.f;
                        btVar3.c().b(userData.getPortrait(), new bm(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
