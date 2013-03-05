package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class av implements com.baidu.tieba.c.d {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        if (bitmap != null) {
            absoluteLayout = this.a.f;
            ImageView imageView = (ImageView) absoluteLayout.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bitmap);
                absoluteLayout2 = this.a.f;
                imageView = (ImageView) absoluteLayout2.findViewWithTag(str);
            }
        }
    }
}
