package com.baidu.tieba.write;

import android.widget.ListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        k kVar;
        k kVar2;
        k kVar3;
        try {
            listView = this.a.e;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.e;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                kVar = this.a.j;
                if (i >= kVar.getCount()) {
                    return;
                }
                kVar2 = this.a.j;
                com.baidu.tieba.a.ah ahVar = (com.baidu.tieba.a.ah) kVar2.getItem(i);
                if (ahVar != null && ahVar.d() != null) {
                    kVar3 = this.a.j;
                    kVar3.c().b(ahVar.d(), new c(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
