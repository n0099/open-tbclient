package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonListActivity personListActivity) {
        this.f2237a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        try {
            bdListView = this.f2237a.b;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f2237a.b;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                bnVar = this.f2237a.e;
                if (i < bnVar.getCount()) {
                    bnVar2 = this.f2237a.e;
                    UserData userData = (UserData) bnVar2.getItem(i);
                    if (userData != null && userData.getPortrait() != null) {
                        bnVar3 = this.f2237a.e;
                        bnVar3.c().b(userData.getPortrait(), new bh(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
