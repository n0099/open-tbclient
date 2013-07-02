package com.baidu.tieba.nearby;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.a.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        NearbyPbActivity nearbyPbActivity;
        ListView listView;
        NearbyPbActivity nearbyPbActivity2;
        ListView listView2;
        if (bVar != null) {
            nearbyPbActivity = this.a.a;
            listView = nearbyPbActivity.b;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.b(imageView);
                nearbyPbActivity2 = this.a.a;
                listView2 = nearbyPbActivity2.b;
                imageView = (ImageView) listView2.findViewWithTag(str);
            }
        }
    }
}
