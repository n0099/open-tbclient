package com.baidu.tieba.write;

import android.widget.ListView;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.f2700a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        k kVar;
        k kVar2;
        k kVar3;
        try {
            listView = this.f2700a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.f2700a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                kVar = this.f2700a.i;
                if (i < kVar.getCount()) {
                    kVar2 = this.f2700a.i;
                    MetaData metaData = (MetaData) kVar2.getItem(i);
                    if (metaData != null && metaData.getPortrait() != null) {
                        kVar3 = this.f2700a.i;
                        kVar3.b().b(metaData.getPortrait(), new c(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "mGetImageRunnble.run", e.getMessage());
        }
    }
}
