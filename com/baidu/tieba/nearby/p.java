package com.baidu.tieba.nearby;

import android.widget.ListView;
import com.baidu.tieba.c.ae;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ NearbyListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NearbyListActivity nearbyListActivity) {
        this.a = nearbyListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.b.j jVar;
        com.baidu.tieba.b.j jVar2;
        ListView listView;
        ListView listView2;
        com.baidu.tieba.b.j jVar3;
        com.baidu.tieba.b.j jVar4;
        w wVar;
        w wVar2;
        w wVar3;
        int i;
        w wVar4;
        w wVar5;
        w wVar6;
        int i2 = 0;
        try {
            jVar = this.a.g;
            if (jVar != null) {
                jVar2 = this.a.g;
                if (jVar2.b().size() == 0) {
                    return;
                }
                listView = this.a.b;
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                listView2 = this.a.b;
                int lastVisiblePosition = listView2.getLastVisiblePosition();
                jVar3 = this.a.g;
                int size = jVar3.a().size();
                jVar4 = this.a.g;
                int size2 = (jVar4.b().size() + size) - 1;
                if (firstVisiblePosition >= size) {
                    size = firstVisiblePosition;
                }
                com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
                wVar = this.a.e;
                wVar.a().a();
                boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
                wVar2 = this.a.e;
                wVar2.a().a(z);
                int i3 = size;
                while (i3 < size2) {
                    if (!z && i3 > lastVisiblePosition) {
                        return;
                    }
                    wVar3 = this.a.e;
                    if (wVar3.getItem(i3) instanceof com.baidu.tieba.b.m) {
                        wVar4 = this.a.e;
                        if (((com.baidu.tieba.b.m) wVar4.getItem(i3)).a() == 1) {
                            wVar5 = this.a.e;
                            String g = ((com.baidu.tieba.b.m) wVar5.getItem(i3)).g();
                            if (g != null && !g.equals("")) {
                                i = i2 + 1;
                                wVar6 = this.a.e;
                                wVar6.a().a(g, new q(this));
                                if (!z && i >= 13) {
                                    return;
                                }
                                i3++;
                                i2 = i;
                            }
                        }
                    }
                    i = i2;
                    if (!z) {
                    }
                    i3++;
                    i2 = i;
                }
            }
        } catch (Exception e) {
            ae.b("NearbyListActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
