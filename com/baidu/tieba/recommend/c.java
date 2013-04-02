package com.baidu.tieba.recommend;

import android.widget.ListView;
import com.baidu.tieba.a.af;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x004d */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ListView listView;
        ListView listView2;
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        int i;
        n nVar5;
        try {
            listView = this.a.i;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.i;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            z c = com.baidu.tieba.c.w.c(this.a);
            nVar = this.a.j;
            nVar.a().a();
            boolean z = c == z.WIFI || c == z.ThreeG;
            nVar2 = this.a.j;
            nVar2.a().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < nVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    nVar4 = this.a.j;
                    ax axVar = (ax) nVar4.getItem(i2);
                    if (axVar != null) {
                        ArrayList p = axVar.p();
                        int size = p.size();
                        if (i3 < 13) {
                            int i4 = 0;
                            while (i4 < size) {
                                if (((af) p.get(i4)).a() == 3) {
                                    if (i3 >= 13) {
                                        i = i3;
                                        break;
                                    }
                                    i3++;
                                    nVar5 = this.a.j;
                                    nVar5.a().a(((af) p.get(i4)).b(), new d(this));
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        i = i3;
                        if (z && i >= 13 && 0 >= 30) {
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
            ag.b("GuessActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
