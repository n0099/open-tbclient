package com.baidu.tieba.nearby;

import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.c.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ListView listView;
        ListView listView2;
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        com.baidu.tieba.c.d dVar;
        int i = 0;
        try {
            linearLayout = this.a.j;
            if (linearLayout.getParent() == null) {
                return;
            }
            listView = this.a.k;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.k;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            mVar = this.a.g;
            mVar.a().a();
            boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
            while (true) {
                int i2 = firstVisiblePosition;
                int i3 = i;
                mVar2 = this.a.g;
                if (i2 >= mVar2.getCount()) {
                    return;
                }
                if (!z && i2 > lastVisiblePosition) {
                    return;
                }
                mVar3 = this.a.g;
                Object item = mVar3.getItem(i2);
                if (item != null && (item instanceof aa)) {
                    aa aaVar = (aa) item;
                    if (i3 >= 13) {
                        return;
                    }
                    if (aaVar.a() == 1) {
                        mVar4 = this.a.g;
                        com.baidu.tieba.c.a a = mVar4.a();
                        String d = aaVar.d();
                        dVar = this.a.B;
                        a.a(d, dVar);
                        i = i3 + 1;
                        firstVisiblePosition = i2 + 1;
                    }
                }
                i = i3;
                firstVisiblePosition = i2 + 1;
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
