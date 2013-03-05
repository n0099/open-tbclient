package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.c.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        NearbyPbActivity nearbyPbActivity;
        ListView listView;
        if (bitmap != null) {
            nearbyPbActivity = this.a.a;
            listView = nearbyPbActivity.d;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
