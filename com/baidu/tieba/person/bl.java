package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bl implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        bt btVar;
        bt btVar2;
        bt btVar3;
        try {
            bdListView = this.a.e;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.e;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                btVar = this.a.h;
                if (i < btVar.getCount()) {
                    btVar2 = this.a.h;
                    com.baidu.tieba.a.be beVar = (com.baidu.tieba.a.be) btVar2.getItem(i);
                    if (beVar != null && beVar.e() != null) {
                        btVar3 = this.a.h;
                        btVar3.c().b(beVar.e(), new bm(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
