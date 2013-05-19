package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class au implements com.baidu.tieba.d.d {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        if (bitmap != null) {
            absoluteLayout = this.a.g;
            ImageView imageView = (ImageView) absoluteLayout.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bitmap);
                absoluteLayout2 = this.a.g;
                imageView = (ImageView) absoluteLayout2.findViewWithTag(str);
            }
        }
    }
}
