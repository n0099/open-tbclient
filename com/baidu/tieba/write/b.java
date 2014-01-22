package com.baidu.tieba.write;

import android.widget.ListView;
import com.baidu.tieba.data.MetaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        k kVar;
        k kVar2;
        k kVar3;
        try {
            listView = this.a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                kVar = this.a.i;
                if (i < kVar.getCount()) {
                    kVar2 = this.a.i;
                    MetaData metaData = (MetaData) kVar2.getItem(i);
                    if (metaData != null && metaData.getPortrait() != null) {
                        kVar3 = this.a.i;
                        kVar3.b().c(metaData.getPortrait(), new c(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
