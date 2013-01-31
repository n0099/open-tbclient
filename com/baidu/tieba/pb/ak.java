package com.baidu.tieba.pb;

import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0050 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ListView listView;
        ListView listView2;
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        int i;
        bv bvVar5;
        com.baidu.tieba.b.p pVar;
        bv bvVar6;
        bv bvVar7;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            bvVar = this.a.m;
            bvVar.b().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            bvVar2 = this.a.m;
            bvVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < bvVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    bvVar4 = this.a.m;
                    com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) bvVar4.getItem(i2);
                    if (anVar != null) {
                        ArrayList e = anVar.e();
                        int size = e.size();
                        bvVar5 = this.a.m;
                        if (bvVar5.i() && i4 < 13) {
                            int i5 = 0;
                            int i6 = i4;
                            while (true) {
                                if (i5 >= size) {
                                    i4 = i6;
                                    break;
                                }
                                if (((com.baidu.tieba.a.k) e.get(i5)).a() == 3 || ((com.baidu.tieba.a.k) e.get(i5)).a() == 5) {
                                    if (i6 >= 13) {
                                        i4 = i6;
                                        break;
                                    }
                                    i6++;
                                    bvVar7 = this.a.m;
                                    bvVar7.b().a(((com.baidu.tieba.a.k) e.get(i5)).f(), new al(this));
                                }
                                i5++;
                                i6 = i6;
                            }
                        }
                        String d = anVar.d().d();
                        pVar = this.a.o;
                        if (pVar.b() && d != null && d.length() > 0 && i3 < 30) {
                            i3++;
                            bvVar6 = this.a.m;
                            bvVar6.b().d(d, new am(this));
                        }
                        i = i3;
                        if (z && i4 >= 13 && i >= 30) {
                            return;
                        }
                    } else {
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.c.af.b("PbActivity", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
