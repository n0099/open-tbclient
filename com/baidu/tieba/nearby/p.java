package com.baidu.tieba.nearby;

import android.widget.ListView;
import com.baidu.tieba.c.af;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ NearbyListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NearbyListActivity nearbyListActivity) {
        this.a = nearbyListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.b.l lVar;
        com.baidu.tieba.b.l lVar2;
        ListView listView;
        ListView listView2;
        com.baidu.tieba.b.l lVar3;
        com.baidu.tieba.b.l lVar4;
        w wVar;
        w wVar2;
        w wVar3;
        int i;
        w wVar4;
        w wVar5;
        w wVar6;
        int i2 = 0;
        try {
            lVar = this.a.h;
            if (lVar != null) {
                lVar2 = this.a.h;
                if (lVar2.b().size() != 0) {
                    listView = this.a.c;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    listView2 = this.a.c;
                    int lastVisiblePosition = listView2.getLastVisiblePosition();
                    lVar3 = this.a.h;
                    int size = lVar3.a().size();
                    lVar4 = this.a.h;
                    int size2 = (lVar4.b().size() + size) - 1;
                    if (firstVisiblePosition >= size) {
                        size = firstVisiblePosition;
                    }
                    com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
                    wVar = this.a.f;
                    wVar.a().a();
                    boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
                    wVar2 = this.a.f;
                    wVar2.a().a(z);
                    int i3 = size;
                    while (i3 < size2) {
                        if (z || i3 <= lastVisiblePosition) {
                            wVar3 = this.a.f;
                            if (wVar3.getItem(i3) instanceof com.baidu.tieba.b.o) {
                                wVar4 = this.a.f;
                                if (((com.baidu.tieba.b.o) wVar4.getItem(i3)).a() == 1) {
                                    wVar5 = this.a.f;
                                    String g = ((com.baidu.tieba.b.o) wVar5.getItem(i3)).g();
                                    if (g != null && !g.equals("")) {
                                        i = i2 + 1;
                                        wVar6 = this.a.f;
                                        wVar6.a().a(g, new q(this));
                                        if (z || i < 13) {
                                            i3++;
                                            i2 = i;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                            i = i2;
                            if (z) {
                            }
                            i3++;
                            i2 = i;
                        } else {
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            af.b("NearbyListActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
