package com.baidu.tieba.person;

import android.widget.ListView;
/* loaded from: classes.dex */
class br implements Runnable {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        com.baidu.tieba.write.k kVar;
        com.baidu.tieba.write.k kVar2;
        com.baidu.tieba.write.k kVar3;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                kVar = this.a.f;
                if (i < kVar.getCount()) {
                    kVar2 = this.a.f;
                    com.baidu.tieba.a.ah ahVar = (com.baidu.tieba.a.ah) kVar2.getItem(i);
                    if (ahVar != null && ahVar.d() != null) {
                        kVar3 = this.a.f;
                        kVar3.c().b(ahVar.d(), new bs(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
