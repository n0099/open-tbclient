package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.c.d {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        AbsoluteLayout absoluteLayout;
        if (bitmap != null) {
            absoluteLayout = this.a.d;
            ImageView imageView = (ImageView) absoluteLayout.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
