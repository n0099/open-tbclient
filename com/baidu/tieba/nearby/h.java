package com.baidu.tieba.nearby;

import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.tieba.a.ab;
import com.baidu.tieba.c.af;
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
            linearLayout = this.a.k;
            if (linearLayout.getParent() != null) {
                listView = this.a.l;
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                listView2 = this.a.l;
                int lastVisiblePosition = listView2.getLastVisiblePosition();
                com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
                mVar = this.a.h;
                mVar.a().a();
                boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
                while (true) {
                    int i2 = firstVisiblePosition;
                    int i3 = i;
                    mVar2 = this.a.h;
                    if (i2 < mVar2.getCount()) {
                        if (z || i2 <= lastVisiblePosition) {
                            mVar3 = this.a.h;
                            Object item = mVar3.getItem(i2);
                            if (item != null && (item instanceof ab)) {
                                ab abVar = (ab) item;
                                if (i3 < 13) {
                                    if (abVar.a() == 1) {
                                        mVar4 = this.a.h;
                                        com.baidu.tieba.c.a a = mVar4.a();
                                        String d = abVar.d();
                                        dVar = this.a.C;
                                        a.a(d, dVar);
                                        i = i3 + 1;
                                        firstVisiblePosition = i2 + 1;
                                    }
                                } else {
                                    return;
                                }
                            }
                            i = i3;
                            firstVisiblePosition = i2 + 1;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            af.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
