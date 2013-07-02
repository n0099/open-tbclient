package com.baidu.tieba.nearby;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.a.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        NearbyPbActivity nearbyPbActivity;
        ListView listView;
        if (bVar != null) {
            nearbyPbActivity = this.a.a;
            listView = nearbyPbActivity.b;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
