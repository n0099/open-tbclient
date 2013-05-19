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
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ae aeVar4;
        int i;
        ae aeVar5;
        com.baidu.tieba.c.bd bdVar;
        ae aeVar6;
        ae aeVar7;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(this.a);
            aeVar = this.a.l;
            aeVar.b().a();
            boolean z = c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG;
            aeVar2 = this.a.l;
            aeVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < aeVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    aeVar4 = this.a.l;
                    com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) aeVar4.getItem(i2);
                    if (aqVar != null) {
                        ArrayList j = aqVar.j();
                        int size = j.size();
                        aeVar5 = this.a.l;
                        if (aeVar5.g() && i4 < 13) {
                            int i5 = 0;
                            int i6 = i4;
                            while (true) {
                                if (i5 >= size) {
                                    i4 = i6;
                                    break;
                                }
                                if (((com.baidu.tieba.a.k) j.get(i5)).a() == 3 || ((com.baidu.tieba.a.k) j.get(i5)).a() == 5) {
                                    if (i6 >= 13) {
                                        i4 = i6;
                                        break;
                                    }
                                    i6++;
                                    aeVar7 = this.a.l;
                                    aeVar7.b().a(((com.baidu.tieba.a.k) j.get(i5)).f(), new l(this));
                                }
                                i5++;
                                i6 = i6;
                            }
                        }
                        String e = aqVar.h().e();
                        bdVar = this.a.n;
                        if (bdVar.b() && e != null && e.length() > 0 && i3 < 30) {
                            i3++;
                            aeVar6 = this.a.l;
                            aeVar6.b().d(e, new m(this));
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
            com.baidu.tieba.d.ae.b("NearbyPbActivity", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
