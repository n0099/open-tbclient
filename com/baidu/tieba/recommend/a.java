package com.baidu.tieba.recommend;

import android.widget.ListView;
import com.baidu.tieba.a.ag;
import com.baidu.tieba.a.av;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.w;
import com.baidu.tieba.c.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuessActivity guessActivity) {
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
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        int i;
        l lVar5;
        try {
            listView = this.a.i;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.i;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            z c = w.c(this.a);
            lVar = this.a.j;
            lVar.a().a();
            boolean z = c == z.WIFI || c == z.ThreeG;
            lVar2 = this.a.j;
            lVar2.a().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < lVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    lVar4 = this.a.j;
                    av avVar = (av) lVar4.getItem(i2);
                    if (avVar != null) {
                        ArrayList n = avVar.n();
                        int size = n.size();
                        if (i3 < 13) {
                            int i4 = 0;
                            while (i4 < size) {
                                if (((ag) n.get(i4)).a() == 3) {
                                    if (i3 >= 13) {
                                        i = i3;
                                        break;
                                    }
                                    i3++;
                                    lVar5 = this.a.j;
                                    lVar5.a().a(((ag) n.get(i4)).b(), new b(this));
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
            af.b("GuessActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
