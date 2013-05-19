package com.baidu.tieba.mention;

import android.widget.ListView;
import com.baidu.tieba.d.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        e eVar;
        e eVar2;
        String e;
        e eVar3;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                eVar = this.a.e;
                if (i < eVar.getCount()) {
                    eVar2 = this.a.e;
                    com.baidu.tieba.a.r rVar = (com.baidu.tieba.a.r) eVar2.getItem(i);
                    if (rVar != null && (e = rVar.i().e()) != null && e.length() > 0) {
                        eVar3 = this.a.e;
                        eVar3.e().d(e, new j(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            ae.b("MentionView", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
