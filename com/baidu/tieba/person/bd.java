package com.baidu.tieba.person;

import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PersonLbsActivity personLbsActivity) {
        this.a = personLbsActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0040 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ListView listView;
        ListView listView2;
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        int i;
        bj bjVar4;
        try {
            listView = this.a.c;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.c;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            bjVar = this.a.n;
            bjVar.a().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < bjVar2.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    bjVar3 = this.a.n;
                    com.baidu.tieba.a.aj ajVar = (com.baidu.tieba.a.aj) bjVar3.getItem(i2);
                    if (ajVar != null) {
                        ArrayList f = ajVar.c().f();
                        int size = f.size();
                        if (i3 < 13) {
                            for (int i4 = 0; i4 < size; i4++) {
                                if (((com.baidu.tieba.a.k) f.get(i4)).a() == 3) {
                                    int i5 = i3 + 1;
                                    bjVar4 = this.a.n;
                                    bjVar4.a().a(((com.baidu.tieba.a.k) f.get(i4)).f(), new be(this));
                                    i = i5;
                                    break;
                                }
                            }
                        }
                        i = i3;
                        if (z && i >= 13) {
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
