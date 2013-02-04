package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.c.d {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        NearbyListActivity nearbyListActivity;
        ListView listView;
        if (bitmap == null) {
            return;
        }
        nearbyListActivity = this.a.a;
        listView = nearbyListActivity.b;
        View findViewWithTag = listView.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
