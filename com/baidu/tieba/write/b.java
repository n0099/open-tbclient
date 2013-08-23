package com.baidu.tieba.write;

import android.widget.ListView;
import com.baidu.tieba.data.MetaData;
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.f1926a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        k kVar;
        k kVar2;
        k kVar3;
        try {
            listView = this.f1926a.e;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.f1926a.e;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                kVar = this.f1926a.l;
                if (i < kVar.getCount()) {
                    kVar2 = this.f1926a.l;
                    MetaData metaData = (MetaData) kVar2.getItem(i);
                    if (metaData != null && metaData.getPortrait() != null) {
                        kVar3 = this.f1926a.l;
                        kVar3.b().b(metaData.getPortrait(), new c(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
