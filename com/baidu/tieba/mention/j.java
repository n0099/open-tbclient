package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f1368a = iVar;
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
            bdListView = this.f1368a.e;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.f1368a.e;
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
                fVar = this.f1368a.f;
                if (i4 < fVar.getCount()) {
                    fVar2 = this.f1368a.f;
                    com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) fVar2.getItem(i4);
                    if (uVar != null && (portrait = uVar.i().getPortrait()) != null && portrait.length() > 0) {
                        fVar3 = this.f1368a.f;
                        fVar3.e().d(portrait, new k(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            av.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
