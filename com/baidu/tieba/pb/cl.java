package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements com.baidu.tieba.c.d {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(SubPbActivity subPbActivity, ImageView imageView) {
        this.a = subPbActivity;
        this.b = imageView;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        this.b.setImageBitmap(bitmap);
    }
}
