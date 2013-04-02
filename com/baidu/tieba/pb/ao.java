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
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        cd cdVar4;
        int i;
        cd cdVar5;
        com.baidu.tieba.b.r rVar;
        cd cdVar6;
        cd cdVar7;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            cdVar = this.a.m;
            cdVar.b().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            cdVar2 = this.a.m;
            cdVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < cdVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    cdVar4 = this.a.m;
                    com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) cdVar4.getItem(i2);
                    if (anVar != null) {
                        ArrayList f = anVar.f();
                        int size = f.size();
                        cdVar5 = this.a.m;
                        if (cdVar5.i() && i4 < 13) {
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
                                    cdVar7 = this.a.m;
                                    cdVar7.b().a(((com.baidu.tieba.a.k) f.get(i5)).f(), new ap(this));
                                }
                                i5++;
                                i6 = i6;
                            }
                        }
                        String d = anVar.e().d();
                        rVar = this.a.o;
                        if (rVar.b() && d != null && d.length() > 0 && i3 < 30) {
                            i3++;
                            cdVar6 = this.a.m;
                            cdVar6.b().d(d, new aq(this));
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
