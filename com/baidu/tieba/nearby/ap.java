package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.c.d {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ListView listView;
        ListView listView2;
        ListView listView3;
        if (bitmap != null) {
            listView = this.a.e;
            if (listView != null) {
                listView2 = this.a.e;
                ImageView imageView = (ImageView) listView2.findViewWithTag(str);
                while (imageView != null) {
                    imageView.setTag(null);
                    imageView.setImageBitmap(bitmap);
                    listView3 = this.a.e;
                    imageView = (ImageView) listView3.findViewWithTag(str);
                }
            }
        }
    }
}
