package com.baidu.tieba.person;

import android.widget.ListView;
import com.baidu.tieba.util.NetWorkCore;
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
            listView = this.a.a;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.a;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this.a);
            bjVar = this.a.n;
            bjVar.a().a();
            boolean z = c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG;
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < bjVar2.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    bjVar3 = this.a.n;
                    com.baidu.tieba.data.al alVar = (com.baidu.tieba.data.al) bjVar3.getItem(i2);
                    if (alVar != null) {
                        ArrayList j = alVar.e().j();
                        int size = j.size();
                        if (i3 < 13) {
                            for (int i4 = 0; i4 < size; i4++) {
                                if (((com.baidu.tieba.data.i) j.get(i4)).a() == 3) {
                                    int i5 = i3 + 1;
                                    bjVar4 = this.a.n;
                                    bjVar4.a().a(((com.baidu.tieba.data.i) j.get(i4)).f(), new be(this));
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
            com.baidu.tieba.util.z.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
