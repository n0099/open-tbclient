package com.baidu.tieba.nearby;

import android.widget.ImageView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.a.d {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ListView listView;
        ListView listView2;
        ListView listView3;
        if (bVar != null) {
            listView = this.a.c;
            if (listView != null) {
                listView2 = this.a.c;
                ImageView imageView = (ImageView) listView2.findViewWithTag(str);
                while (imageView != null) {
                    imageView.setTag(null);
                    bVar.b(imageView);
                    listView3 = this.a.c;
                    imageView = (ImageView) listView3.findViewWithTag(str);
                }
            }
        }
    }
}
