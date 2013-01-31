package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.c.d {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        LinearLayout linearLayout;
        if (bitmap != null) {
            linearLayout = this.a.k;
            ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
