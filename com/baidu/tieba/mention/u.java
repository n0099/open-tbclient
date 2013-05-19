package com.baidu.tieba.mention;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.d.d {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.a.c;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            linearLayout2 = this.a.c;
            imageView = (ImageView) linearLayout2.findViewWithTag(str);
        }
    }
}
