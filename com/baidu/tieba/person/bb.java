package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tieba.d.d {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ImageView imageView;
        if (bitmap != null) {
            imageView = this.a.d;
            imageView.setImageBitmap(bitmap);
        }
    }
}
