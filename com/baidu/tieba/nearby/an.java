package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.a.d {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ListView listView;
        ListView listView2;
        if (bVar != null) {
            listView = this.a.c;
            if (listView != null) {
                listView2 = this.a.c;
                View findViewWithTag = listView2.findViewWithTag(str);
                if (findViewWithTag != null) {
                    findViewWithTag.invalidate();
                }
            }
        }
    }
}
