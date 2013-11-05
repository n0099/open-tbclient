package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1866a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1866a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        String portrait;
        f fVar3;
        try {
            bdListView = this.f1866a.e;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f1866a.e;
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
                fVar = this.f1866a.f;
                if (i4 < fVar.getCount()) {
                    fVar2 = this.f1866a.f;
                    com.baidu.tieba.data.v vVar = (com.baidu.tieba.data.v) fVar2.getItem(i4);
                    if (vVar != null && (portrait = vVar.i().getPortrait()) != null && portrait.length() > 0) {
                        fVar3 = this.f1866a.f;
                        fVar3.e().d(portrait, new l(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            be.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
