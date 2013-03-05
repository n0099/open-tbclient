package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.c.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        NearbyPbActivity nearbyPbActivity;
        ListView listView;
        NearbyPbActivity nearbyPbActivity2;
        ListView listView2;
        if (bitmap != null) {
            nearbyPbActivity = this.a.a;
            listView = nearbyPbActivity.d;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bitmap);
                nearbyPbActivity2 = this.a.a;
                listView2 = nearbyPbActivity2.d;
                imageView = (ImageView) listView2.findViewWithTag(str);
            }
        }
    }
}
