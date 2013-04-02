package com.baidu.tieba.nearby;

import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x0068 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        ar arVar;
        ar arVar2;
        ListView listView;
        ListView listView2;
        ar arVar3;
        ar arVar4;
        int i;
        int i2;
        ar arVar5;
        com.baidu.tieba.a.ah m;
        String d;
        ar arVar6;
        com.baidu.tieba.c.d dVar;
        com.baidu.tieba.a.ah l;
        String d2;
        ar arVar7;
        com.baidu.tieba.c.d dVar2;
        String g;
        ar arVar8;
        com.baidu.tieba.c.d dVar3;
        int i3 = 0;
        try {
            pVar = this.a.d;
            if (pVar != null) {
                pVar2 = this.a.d;
                if (pVar2.a().size() != 0) {
                    com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
                    arVar = this.a.f;
                    arVar.a().a();
                    boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
                    arVar2 = this.a.f;
                    arVar2.a().a(z);
                    listView = this.a.e;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    listView2 = this.a.e;
                    int lastVisiblePosition = listView2.getLastVisiblePosition();
                    int i4 = firstVisiblePosition;
                    int i5 = 0;
                    while (i4 < arVar3.getCount()) {
                        if (z || i4 <= lastVisiblePosition) {
                            arVar4 = this.a.f;
                            if (arVar4.getItem(i4) instanceof com.baidu.tieba.b.q) {
                                arVar5 = this.a.f;
                                com.baidu.tieba.b.q qVar = (com.baidu.tieba.b.q) arVar5.getItem(i4);
                                if (qVar.a() == 0 || qVar.a() == 1 || qVar.a() == 2) {
                                    if (i5 < 13 && (g = qVar.g()) != null && !g.equals("")) {
                                        i5++;
                                        arVar8 = this.a.f;
                                        com.baidu.tieba.c.a a = arVar8.a();
                                        dVar3 = this.a.o;
                                        a.a(g, dVar3);
                                    }
                                    if (i3 < 30 && (l = qVar.l()) != null && (d2 = l.d()) != null && !d2.equals("")) {
                                        i3++;
                                        arVar7 = this.a.f;
                                        com.baidu.tieba.c.a a2 = arVar7.a();
                                        dVar2 = this.a.p;
                                        a2.d(d2, dVar2);
                                    }
                                    if (i3 < 30 && (m = qVar.m()) != null && (d = m.d()) != null && !d.equals("")) {
                                        i = i3 + 1;
                                        arVar6 = this.a.f;
                                        com.baidu.tieba.c.a a3 = arVar6.a();
                                        dVar = this.a.p;
                                        a3.d(d, dVar);
                                        i2 = i5;
                                        if (i2 >= 13 || i < 30) {
                                            i4++;
                                            i5 = i2;
                                            i3 = i;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                            i = i3;
                            i2 = i5;
                            if (i2 >= 13) {
                            }
                            i4++;
                            i5 = i2;
                            i3 = i;
                        } else {
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("NearbyPostListActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
