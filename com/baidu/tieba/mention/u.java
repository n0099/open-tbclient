package com.baidu.tieba.mention;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.c.d {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.a.b;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            linearLayout2 = this.a.b;
            imageView = (ImageView) linearLayout2.findViewWithTag(str);
        }
    }
}
