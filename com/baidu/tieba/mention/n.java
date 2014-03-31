package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements Runnable {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        BdListView bdListView2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        String portrait;
        g gVar3;
        try {
            bdListView = this.a.e;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.e;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                int i3 = lastVisiblePosition - 1;
                i = firstVisiblePosition - 1;
                i2 = i3;
            } else {
                i = firstVisiblePosition;
                i2 = lastVisiblePosition;
            }
            for (int i4 = i; i4 <= i2; i4++) {
                gVar = this.a.f;
                if (i4 < gVar.getCount()) {
                    gVar2 = this.a.f;
                    com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) gVar2.getItem(i4);
                    if (oVar != null && (portrait = oVar.l().getPortrait()) != null && portrait.length() > 0) {
                        gVar3 = this.a.f;
                        gVar3.e().c(portrait, new o(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
