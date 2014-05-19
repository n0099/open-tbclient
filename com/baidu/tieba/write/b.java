package com.baidu.tieba.write;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        n nVar;
        n nVar2;
        n nVar3;
        try {
            bdListView = this.a.d;
            int firstVisiblePosition = bdListView.getFirstVisiblePosition();
            bdListView2 = this.a.d;
            int lastVisiblePosition = bdListView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                nVar = this.a.l;
                if (i < nVar.getCount()) {
                    nVar2 = this.a.l;
                    MetaData metaData = (MetaData) nVar2.getItem(i);
                    if (metaData != null && metaData.getPortrait() != null) {
                        nVar3 = this.a.l;
                        nVar3.a().c(metaData.getPortrait(), new c(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
