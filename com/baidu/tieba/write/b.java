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
            listView = this.a.f;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.f;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                kVar = this.a.k;
                if (i < kVar.getCount()) {
                    kVar2 = this.a.k;
                    com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) kVar2.getItem(i);
                    if (afVar != null && afVar.d() != null) {
                        kVar3 = this.a.k;
                        kVar3.c().b(afVar.d(), new c(this));
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
