package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.f2337a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bt btVar;
        bt btVar2;
        bt btVar3;
        try {
            bdListView = this.f2337a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f2337a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                btVar = this.f2337a.e;
                if (i < btVar.getCount()) {
                    btVar2 = this.f2337a.e;
                    UserData userData = (UserData) btVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        btVar3 = this.f2337a.e;
                        btVar3.c().b(userData.getPortrait(), new bn(this));
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
