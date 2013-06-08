package com.baidu.tieba.nearby;

import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x0068 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.baidu.tieba.c.av avVar;
        com.baidu.tieba.c.av avVar2;
        aq aqVar;
        aq aqVar2;
        ListView listView;
        ListView listView2;
        aq aqVar3;
        aq aqVar4;
        int i;
        int i2;
        aq aqVar5;
        com.baidu.tieba.a.ai m;
        String e;
        aq aqVar6;
        com.baidu.tbadk.a.d dVar;
        com.baidu.tieba.a.ai l;
        String e2;
        aq aqVar7;
        com.baidu.tbadk.a.d dVar2;
        String g;
        aq aqVar8;
        com.baidu.tbadk.a.d dVar3;
        int i3 = 0;
        try {
            avVar = this.a.d;
            if (avVar != null) {
                avVar2 = this.a.d;
                if (avVar2.a().size() != 0) {
                    com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(this.a);
                    aqVar = this.a.f;
                    aqVar.a().a();
                    boolean z = c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG;
                    aqVar2 = this.a.f;
                    aqVar2.a().a(z);
                    listView = this.a.e;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    listView2 = this.a.e;
                    int lastVisiblePosition = listView2.getLastVisiblePosition();
                    int i4 = firstVisiblePosition;
                    int i5 = 0;
                    while (i4 < aqVar3.getCount()) {
                        if (z || i4 <= lastVisiblePosition) {
                            aqVar4 = this.a.f;
                            if (aqVar4.getItem(i4) instanceof com.baidu.tieba.c.aw) {
                                aqVar5 = this.a.f;
                                com.baidu.tieba.c.aw awVar = (com.baidu.tieba.c.aw) aqVar5.getItem(i4);
                                if (awVar.a() == 0 || awVar.a() == 1 || awVar.a() == 2) {
                                    if (i5 < 13 && (g = awVar.g()) != null && !g.equals("")) {
                                        i5++;
                                        aqVar8 = this.a.f;
                                        com.baidu.tieba.d.a a = aqVar8.a();
                                        dVar3 = this.a.o;
                                        a.a(g, dVar3);
                                    }
                                    if (i3 < 30 && (l = awVar.l()) != null && (e2 = l.e()) != null && !e2.equals("")) {
                                        i3++;
                                        aqVar7 = this.a.f;
                                        com.baidu.tieba.d.a a2 = aqVar7.a();
                                        dVar2 = this.a.p;
                                        a2.d(e2, dVar2);
                                    }
                                    if (i3 < 30 && (m = awVar.m()) != null && (e = m.e()) != null && !e.equals("")) {
                                        i = i3 + 1;
                                        aqVar6 = this.a.f;
                                        com.baidu.tieba.d.a a3 = aqVar6.a();
                                        dVar = this.a.p;
                                        a3.d(e, dVar);
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
        } catch (Exception e3) {
            com.baidu.tieba.d.ae.b("NearbyPostListActivity", "mLoadImageRunnable.run", "error = " + e3.getMessage());
        }
    }
}
