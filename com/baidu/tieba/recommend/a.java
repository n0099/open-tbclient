package com.baidu.tieba.recommend;

import android.widget.ListView;
import com.baidu.tieba.a.af;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.ae;
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
            listView = this.a.h;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.h;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            z c = w.c(this.a);
            lVar = this.a.i;
            lVar.a().a();
            boolean z = c == z.WIFI || c == z.ThreeG;
            lVar2 = this.a.i;
            lVar2.a().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (i2 < lVar3.getCount()) {
                if (!z && i2 > lastVisiblePosition) {
                    return;
                }
                lVar4 = this.a.i;
                as asVar = (as) lVar4.getItem(i2);
                if (asVar != null) {
                    ArrayList n = asVar.n();
                    int size = n.size();
                    if (i3 < 13) {
                        int i4 = 0;
                        while (i4 < size) {
                            if (((af) n.get(i4)).a() == 3) {
                                if (i3 >= 13) {
                                    i = i3;
                                    break;
                                }
                                i3++;
                                lVar5 = this.a.i;
                                lVar5.a().a(((af) n.get(i4)).b(), new b(this));
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
            }
        } catch (Exception e) {
            ae.b("GuessActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
