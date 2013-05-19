package com.baidu.tieba.person;

import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bc implements Runnable {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PersonLbsActivity personLbsActivity) {
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
        bi biVar;
        bi biVar2;
        bi biVar3;
        int i;
        bi biVar4;
        try {
            listView = this.a.c;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.c;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(this.a);
            biVar = this.a.n;
            biVar.a().a();
            boolean z = c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG;
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < biVar2.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    biVar3 = this.a.n;
                    com.baidu.tieba.a.ao aoVar = (com.baidu.tieba.a.ao) biVar3.getItem(i2);
                    if (aoVar != null) {
                        ArrayList j = aoVar.e().j();
                        int size = j.size();
                        if (i3 < 13) {
                            for (int i4 = 0; i4 < size; i4++) {
                                if (((com.baidu.tieba.a.k) j.get(i4)).a() == 3) {
                                    int i5 = i3 + 1;
                                    biVar4 = this.a.n;
                                    biVar4.a().a(((com.baidu.tieba.a.k) j.get(i4)).f(), new bd(this));
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
            com.baidu.tieba.d.ae.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
