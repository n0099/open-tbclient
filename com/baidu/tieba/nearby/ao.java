package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tieba.c.d {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ListView listView;
        ListView listView2;
        if (bitmap != null) {
            listView = this.a.e;
            if (listView != null) {
                listView2 = this.a.e;
                View findViewWithTag = listView2.findViewWithTag(str);
                if (findViewWithTag != null) {
                    findViewWithTag.invalidate();
                }
            }
        }
    }
}
