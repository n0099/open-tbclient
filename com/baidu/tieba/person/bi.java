package com.baidu.tieba.person;

import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bi implements Runnable {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonLbsActivity personLbsActivity) {
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
        bo boVar;
        bo boVar2;
        bo boVar3;
        int i;
        bo boVar4;
        try {
            listView = this.a.c;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.c;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            boVar = this.a.n;
            boVar.a().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < boVar2.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    boVar3 = this.a.n;
                    com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) boVar3.getItem(i2);
                    if (alVar != null) {
                        ArrayList f = alVar.c().f();
                        int size = f.size();
                        if (i3 < 13) {
                            for (int i4 = 0; i4 < size; i4++) {
                                if (((com.baidu.tieba.a.k) f.get(i4)).a() == 3) {
                                    int i5 = i3 + 1;
                                    boVar4 = this.a.n;
                                    boVar4.a().a(((com.baidu.tieba.a.k) f.get(i4)).f(), new bj(this));
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
