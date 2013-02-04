package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.c.d {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ImageView imageView;
        if (bitmap != null) {
            imageView = this.a.d;
            imageView.setImageBitmap(bitmap);
        }
    }
}
