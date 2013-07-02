package com.baidu.tieba.mention;

import android.widget.ListView;
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
        String portrait;
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
                    com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) eVar2.getItem(i);
                    if (qVar != null && (portrait = qVar.i().getPortrait()) != null && portrait.length() > 0) {
                        eVar3 = this.a.e;
                        eVar3.e().d(portrait, new j(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
