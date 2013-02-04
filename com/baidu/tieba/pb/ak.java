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
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        int i;
        bt btVar5;
        com.baidu.tieba.b.n nVar;
        bt btVar6;
        bt btVar7;
        try {
            listView = this.a.c;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.c;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            btVar = this.a.l;
            btVar.b().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            btVar2 = this.a.l;
            btVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < btVar3.getCount()) {
                if (!z && i2 > lastVisiblePosition) {
                    return;
                }
                btVar4 = this.a.l;
                com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) btVar4.getItem(i2);
                if (amVar != null) {
                    ArrayList e = amVar.e();
                    int size = e.size();
                    btVar5 = this.a.l;
                    if (btVar5.i() && i4 < 13) {
                        int i5 = 0;
                        int i6 = i4;
                        while (true) {
                            if (i5 >= size) {
                                i4 = i6;
                                break;
                            }
                            if (((com.baidu.tieba.a.j) e.get(i5)).a() == 3 || ((com.baidu.tieba.a.j) e.get(i5)).a() == 5) {
                                if (i6 >= 13) {
                                    i4 = i6;
                                    break;
                                }
                                i6++;
                                btVar7 = this.a.l;
                                btVar7.b().a(((com.baidu.tieba.a.j) e.get(i5)).f(), new al(this));
                            }
                            i5++;
                            i6 = i6;
                        }
                    }
                    String d = amVar.d().d();
                    nVar = this.a.n;
                    if (nVar.b() && d != null && d.length() > 0 && i3 < 30) {
                        i3++;
                        btVar6 = this.a.l;
                        btVar6.b().d(d, new am(this));
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
            }
        } catch (Exception e2) {
            com.baidu.tieba.c.ae.b("PbActivity", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
