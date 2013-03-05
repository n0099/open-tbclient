package com.baidu.tieba.pb;

import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
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
        ca caVar;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        int i;
        ca caVar5;
        com.baidu.tieba.b.q qVar;
        ca caVar6;
        ca caVar7;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            caVar = this.a.n;
            caVar.b().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            caVar2 = this.a.n;
            caVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < caVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    caVar4 = this.a.n;
                    com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) caVar4.getItem(i2);
                    if (alVar != null) {
                        ArrayList f = alVar.f();
                        int size = f.size();
                        caVar5 = this.a.n;
                        if (caVar5.i() && i4 < 13) {
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
                                    caVar7 = this.a.n;
                                    caVar7.b().a(((com.baidu.tieba.a.k) f.get(i5)).f(), new ap(this));
                                }
                                i5++;
                                i6 = i6;
                            }
                        }
                        String d = alVar.e().d();
                        qVar = this.a.p;
                        if (qVar.b() && d != null && d.length() > 0 && i3 < 30) {
                            i3++;
                            caVar6 = this.a.n;
                            caVar6.b().d(d, new aq(this));
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
            com.baidu.tieba.c.ag.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
