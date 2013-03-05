package com.baidu.tieba.nearby;

import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0050 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ListView listView;
        ListView listView2;
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        int i;
        af afVar5;
        com.baidu.tieba.b.q qVar;
        af afVar6;
        af afVar7;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            afVar = this.a.m;
            afVar.b().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            afVar2 = this.a.m;
            afVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < afVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    afVar4 = this.a.m;
                    com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) afVar4.getItem(i2);
                    if (alVar != null) {
                        ArrayList f = alVar.f();
                        int size = f.size();
                        afVar5 = this.a.m;
                        if (afVar5.g() && i4 < 13) {
                            int i5 = 0;
                            int i6 = i4;
                            while (true) {
                                if (i5 >= size) {
                                    i4 = i6;
                                    break;
                                }
                                if (((com.baidu.tieba.a.k) f.get(i5)).a() == 3 || ((com.baidu.tieba.a.k) f.get(i5)).a() == 5) {
                                    if (i6 >= 13) {
                                        i4 = i6;
                                        break;
                                    }
                                    i6++;
                                    afVar7 = this.a.m;
                                    afVar7.b().a(((com.baidu.tieba.a.k) f.get(i5)).f(), new l(this));
                                }
                                i5++;
                                i6 = i6;
                            }
                        }
                        String d = alVar.e().d();
                        qVar = this.a.o;
                        if (qVar.b() && d != null && d.length() > 0 && i3 < 30) {
                            i3++;
                            afVar6 = this.a.m;
                            afVar6.b().d(d, new m(this));
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
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("NearbyPbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
