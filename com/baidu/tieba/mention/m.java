package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        BdListView bdListView2;
        int i;
        int i2;
        h hVar;
        h hVar2;
        String portrait;
        h hVar3;
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
                hVar = this.a.f;
                if (i4 < hVar.getCount()) {
                    hVar2 = this.a.f;
                    com.baidu.tieba.data.t tVar = (com.baidu.tieba.data.t) hVar2.getItem(i4);
                    if (tVar != null && (portrait = tVar.i().getPortrait()) != null && portrait.length() > 0) {
                        hVar3 = this.a.f;
                        hVar3.e().c(portrait, new n(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
